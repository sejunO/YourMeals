package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oijoa.domain.Recipe;
import com.oijoa.service.RecipeService;

@WebServlet("/recipe/update")
public class RecipeUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      //out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("<title>Recipe Test</title>");
      out.println("</head>");
      out.println("<body>");

      try {
          out.println("<h1>레시피 변경</h1>");	
          Recipe recipe = new Recipe();
          recipe.setRecipeNo(Integer.parseInt(request.getParameter("recipeNo")));
          recipe.setTitle(request.getParameter("title"));
          recipe.setContent(request.getParameter("recipe_content"));
         
                   
          int count = recipeService.update(recipe);

          if (count == 0) {
            out.println("<p>해당 번호의 레시피 게시글이 없습니다.</p>");

          } else {
             out.println("<p>레시피를 변경하였습니다.</p>");
          }

        } catch (Exception e) {
          out.println("<h2>작업 처리 중 오류 발생!</h2>");
          out.printf("<pre>%s</pre>\n", e.getMessage());

          StringWriter errOut = new StringWriter();
          e.printStackTrace(new PrintWriter(errOut));
          out.println("<h3>상세 오류 내용</h3>");
          out.printf("<pre>%s</pre>\n", errOut.toString());
        }

        out.println("</body>");
        out.println("</html>");
      }

}




