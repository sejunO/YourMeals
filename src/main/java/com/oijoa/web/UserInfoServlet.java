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
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>사용자 레시피</title></head>");
    out.println("<body>");
    try {
      out.printf("<h1>[%s]님의 레시피</h1>\n", name);


      List<Recipe> recipeList = recipeService.userNoList(no);

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>제목</th>"
          + "<th>사진</th>"
          + "<th>등록일</th></tr>");

      for (Recipe recipe : recipeList) {
        out.println("<tr>");
        out.printf("<td>%d</td>\n",recipe.getRecipeNo());
        out.printf("<td><a href='../recipe/detail?recipeNo=%d'>%s</a></td>",recipe.getRecipeNo(),recipe.getTitle());
        out.printf("<td>%s</td>\n",recipe.getPhoto());
        out.printf("<td>%s</td>\n",recipe.getCreatedDate());
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("<hr>\n");

      out.println("<h1>[Follower 목록]</h1>");


      List<Follow> followerList = followService.FollowerList(no);

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>이름</th>"
          + "<th>닉네임</th></tr>");

      for (Follow follow : followerList) {
        User user = follow.getUser();
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            user.getUserNo(),
            user.getName(),
            user.getNick());
      }
      out.println("</table>");
      out.println("<hr>\n");

      out.println("<h1>[Following 목록]</h1>");


      List<Follow> followinglist = followService.FollowingList(no);

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>이름</th>"
          + "<th>닉네임</th></tr>");

      for (Follow follow : followinglist) {
        User user = follow.getUser();
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            user.getUserNo(),
            user.getName(),
            user.getNick());
      }
      out.println("</table>");

      out.println("<hr>\n");
      out.println("<a href=list>뒤로가기</a><br>\n");
      out.println("<a href=../index.html>홈으로</a><br>\n");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    out.println("</body>");
    out.println("</html>");
  }
}