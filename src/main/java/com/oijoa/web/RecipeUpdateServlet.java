package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oijoa.domain.Category;
import com.oijoa.domain.Recipe;
import com.oijoa.service.RecipeService;

@WebServlet("/recipe/update")
public class RecipeUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");
   

    try {	
      
      int no = Integer.parseInt(request.getParameter("recipeNo"));
      Recipe recipe = recipeService.get(no);
      recipe.setRecipeNo(Integer.parseInt(request.getParameter("recipeNo")));
      recipe.setTitle(request.getParameter("title"));
      recipe.setContent(request.getParameter("recipe_content"));
      recipe.setLevelNo(Integer.parseInt(request.getParameter("level")));
      recipe.setModifiedDate(Date.valueOf(LocalDate.now()));
      
      // 카테고리 객체에 번호(categoryNo)만 저장, 이름(categoryName)은 따로 저장 안 함
      Category category = new Category();
      category.setCategoryNo(Integer.parseInt(request.getParameter("category")));
      recipe.setCategory(category);
     
   

      if (recipeService.update(recipe) == 0) {
        out.println("<p>해당 번호의 레시피 게시글이 없습니다.</p>");

      } 
       recipeService.updateCategory(recipe);
       response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    out.println("</body>");
    out.println("</html>");

  }

}




