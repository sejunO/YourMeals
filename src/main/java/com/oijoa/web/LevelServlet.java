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
import com.oijoa.domain.Level;
import com.oijoa.service.LevelService;

@WebServlet("/level")
public class LevelServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    LevelService levelService = (LevelService) ctx.getAttribute("levelService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>levelService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[댓글 목록]");
      List<Level> list = levelService.list();

      for (Level level : list) {
        out.println("<table><tr>");
        out.printf("<td>등급번호: ");
        out.printf("%d</td>", level.getLevelNo());
        out.printf("<td>등급 : ");
        out.printf("%d</td>", level.getLevel());

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
