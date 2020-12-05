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
import com.oijoa.domain.Material;
import com.oijoa.service.MaterialService;

@WebServlet("/material")
public class MaterialServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    MaterialService materialService = (MaterialService) ctx.getAttribute("materialService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Recipe Test</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      List<Material> list = materialService.list();

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>이름</th>"
          );

      for (Material material : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", material.getMaterialNo());
        out.printf("<td>%s</td>", material.getName());
        out.println("</tr>");
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
