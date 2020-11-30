package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Category;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.CategoryService;
import com.oijoa.service.RecipeService;

@WebServlet("/recipe/add")
public class RecipeAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");
    CategoryService categoryService = (CategoryService) ctx.getAttribute("categoryService");
    Category category = null;
    try {
      category = categoryService.get(Integer.parseInt(request.getParameter("category")));
      System.out.println(category.getCategoryNo());
      System.out.println(category.getCategoryName());
    } catch (Exception e) {
      System.out.println("카테고리 값 받아올 때 오류");
    }
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Recipe Test</title></head>");

      out.println("[게시물 추가]");

      Recipe recipe = new Recipe();
      recipe.setTitle(request.getParameter("title"));
      recipe.setContent(request.getParameter("content"));
      User user = new User();
      user.setUserNo(1);
      recipe.setWriter(user);
      recipe.setLevelNo(Integer.parseInt(request.getParameter("level")));
      recipe.setMin(Integer.parseInt(request.getParameter("min")));

      //      Category category = categoryService.get(Integer.parseInt(request.getParameter("category")));
      recipe.setCategory(category);

      recipeService.add(recipe);

      out.println("</table></body></html>");



      out.println("</table></body></html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
