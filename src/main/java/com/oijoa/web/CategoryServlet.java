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
import com.oijoa.domain.Category;
import com.oijoa.service.CategoryService;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    CategoryService categoryService = (CategoryService) ctx.getAttribute("categoryService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>CategoryService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[좋아요 목록]");
      List<Category> list = categoryService.list();

      for (Category category : list) {
        out.println("<table><tr>");
        out.printf("<td>재료 번호 : ");
        out.printf("%d</td>", category.getCategoryNo());
        out.printf("<td>재료 이름 : ");
        out.printf("%s</td>", category.getCategoryName());
        out.println("</tr></table>");
        out.println();
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
