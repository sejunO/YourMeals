package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Recipe;
import com.oijoa.service.RecipeService;


//@WebServlet("/recipe/list")
public class RecipeListServlet_backup extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>Recipe Test</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>레시피 목록</h1>");


      List<Recipe> list = null;
      String keyword = request.getParameter("keyword");
      String keywordTitle = request.getParameter("keywordTitle");
      String keywordWriter = request.getParameter("keywordWriter");
      String keywordCategory = request.getParameter("keywordCategory"); ;

      if (keyword != null) {

        list = recipeService.list(keyword);

      } else if (keywordTitle != null) { 
        HashMap<String,Object> keywordMap = new HashMap<>();
        keywordMap.put("title", keywordTitle);
        keywordMap.put("writer", keywordWriter);
        keywordMap.put("category", keywordCategory);

        list = recipeService.list(keywordMap);

      } else {
        list = recipeService.list();
      }

      out.println("<a href='form'>새 레시피</a><br>");
      out.println("<table border='1'>"
          + "<thead><tr>"
          + "<th>번호</th>"
          + "<th>사진</th>"
          + "<th>제목</th>"
          + "<th>작성자</th>"
          + "<th>방법</th>"
          + "<th>작성일</th>"
          + "<th>조회</th>"
          + "</thead></tr>");

      for (Recipe recipe : list) {
        out.println("<tbody><tr>");
        out.printf("<td>%d</td>", recipe.getRecipeNo());
        out.printf("<td><img src='../upload/%1$s_30x30.jpg'>%s</td>", recipe.getPhoto());
        out.printf("<td><a href='detail?recipeNo=%d'>%s</a></td>",recipe.getRecipeNo(),recipe.getTitle());
        out.printf("<td>%s</td>", recipe.getWriter().getNick());
        out.printf("<td>%s</td>", recipe.getCategory().getCategoryName());
        out.printf("<td>%s</td>", recipe.getCreatedDate());
        out.printf("<td>%d</td>", recipe.getHits());
        out.println("</tbody></tr>");
      }

      out.println("<hr>");

      out.println("<h3>상세 검색</h3>");
      out.println("<p>");
      out.println("<form action='list' method='get'>");
      out.printf("레시피: <input type='text' name='keywordTitle' value='%s'><br>\n",
          keywordTitle != null ? keywordTitle : "");
      out.printf("작성자: <input type='text' name='keywordWriter' value='%s'><br>\n",
          keywordWriter != null ? keywordWriter : "");
      out.printf("카테고리: <input type='text' name='keywordCategory' value='%s'><br>\n",
          keywordCategory != null ? keywordCategory : "");
      out.println("<button>검색</button>");
      out.println("</form>");
      out.println("</p>");

      out.println("<hr>");

      out.println("</table></body></html>");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}




