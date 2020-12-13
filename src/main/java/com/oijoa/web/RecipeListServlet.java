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


@WebServlet("/recipe/list")
public class RecipeListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");

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
      
      request.setAttribute("list", list);
      request.getRequestDispatcher("/recipe/list.jsp").forward(request, response);


    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}




