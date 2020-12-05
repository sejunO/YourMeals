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
import com.oijoa.domain.RecipeStep;
import com.oijoa.service.RecipeStepService;

@WebServlet("/recipestep")
public class RecipeStepServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeStepService recipeStepService = (
        RecipeStepService) ctx.getAttribute("recipeStepService");

    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>RecipeStepService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      List<RecipeStep> list = recipeStepService.list();

      out.println("<table border='1'><tr>"
          + "<th>단계번호</th>"
          + "<th>레시피번호</th>"
          + "<th>단계</th>"
          + "<th>사진</th>"
          + "<th>내용</th></tr>");

      for (RecipeStep recipeStep : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", recipeStep.getStepNo());
        out.printf("<td>%d</td>", recipeStep.getRecipeNo());
        out.printf("<td>%d</td>", recipeStep.getStep());
        out.printf("<td>%s</td>", recipeStep.getPhoto());
        out.printf("<td>%s</td>", recipeStep.getContent());
        out.println("</tr>");
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
