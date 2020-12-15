package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Follow;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.RecipeService;

@WebServlet("/user/info")
public class UserInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");
    FollowService followService = (FollowService) ctx.getAttribute("followService");

    int no = Integer.parseInt(request.getParameter("userNo"));
    String name = request.getParameter("userName");

    response.setContentType("text/html;charset=UTF-8");
    try {
      request.setAttribute("userName", name);

      List<Recipe> recipeList = recipeService.userNoList(no);
      request.setAttribute("recipeList", recipeList);

      
      List<Follow> followerList = followService.FollowerList(no);
      request.setAttribute("followerList", followerList);

      List<Follow> followinglist = followService.FollowingList(no);
      request.setAttribute("followinglist", followinglist);

      request.getRequestDispatcher("/mypage/user/info.jsp").include(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}