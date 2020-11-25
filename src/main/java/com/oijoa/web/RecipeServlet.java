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
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.RecipeService;

@WebServlet("/recipe")
public class RecipeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Recipe Test</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      List<Recipe> list = recipeService.list();

      out.println("<table border='1'><tr>"
          + "<th>제목</th>"
          //          + "<th>작성자</th>"
          //          + "<th>방법</th>"
          + "<th>작성일</th>"
          + "<th>조회</th></tr>");

      for (Recipe recipe : list) {
        User user = recipe.getUser();
        out.println("<tr>");
        out.printf("<td>%s</td>", recipe.getTitle());
        out.printf("<td>%s</td>", recipe.getCreatedDate());
        out.printf("<td>%s</td>", user.getName());
        out.printf("<td>%d</td>", recipe.getHits());
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
