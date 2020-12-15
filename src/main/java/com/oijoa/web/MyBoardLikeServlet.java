package com.oijoa.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.RecipeService;

@WebServlet("/mypage/mylikerecipe/list")
public class MyBoardLikeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");

    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    try {

      User loginUser = (User) session.getAttribute("loginUser");

      List<Recipe> list = recipeService.myLikeList(loginUser.getUserNo());

      request.setAttribute("list", list);

      request.getRequestDispatcher("/mypage/recipe/likeRecipe.jsp").include(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}