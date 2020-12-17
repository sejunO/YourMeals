package com.oijoa.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oijoa.domain.Category;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Level;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.RecipeStep;
import com.oijoa.service.CategoryService;
import com.oijoa.service.CommentService;
import com.oijoa.service.LevelService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.RecipeStepService;

@WebServlet("/recipe/detail")
public class RecipeDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)

      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");
    RecipeStepService recipeStepService = (RecipeStepService) ctx.getAttribute("recipeStepService");
    CategoryService categoryService = (CategoryService) ctx.getAttribute("categoryService");
    CommentService commentService = (CommentService) ctx.getAttribute("commentService");
    LevelService levelService = (LevelService) ctx.getAttribute("levelService");
    //FoodService foodService = (FoodService) ctx.getAttribute("foodService");
    
    int no = Integer.parseInt(request.getParameter("recipeNo"));    

    response.setContentType("text/html;charset=UTF-8");

    try {

      Recipe recipe = recipeService.get(no);
      List<Category> categorys = categoryService.list();
      List<Level> levels = levelService.list();
      List<RecipeStep> recipeSteps = recipeStepService.list(no);
      List<Comment> comments = commentService.list(no);
      
      request.setAttribute("recipe", recipe);
      request.setAttribute("categorys", categorys);
      request.setAttribute("levels", levels);
      request.setAttribute("recipeSteps", recipeSteps);
      request.setAttribute("comments", comments);
      request.getRequestDispatcher("/recipe/detail.jsp").include(request, response);
        


    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }

}
