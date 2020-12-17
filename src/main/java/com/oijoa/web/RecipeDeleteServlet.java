package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.service.RecipeService;

@WebServlet("/recipe/delete")
public class RecipeDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");  

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    try {

      int no = Integer.parseInt(request.getParameter("recipeNo"));
    	
      if (recipeService.deleteByNo(no) == 0) {
        out.println("<p>해당 레시피가 없습니다.</p>");
      } else {
        out.println("<p>레시피를 삭제하였습니다.</p>");
      }

      response.sendRedirect("list");
      
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    out.println("</body>");
    out.println("</html>");

  }

}
