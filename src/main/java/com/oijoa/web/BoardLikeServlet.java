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
import com.oijoa.domain.BoardLike;
import com.oijoa.service.BoardLikeService;

@WebServlet("/boardLike")
public class BoardLikeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    BoardLikeService boardLikeService = (BoardLikeService) ctx.getAttribute("boardLikeService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>BoardLikeService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[좋아요 목록]");
      List<BoardLike> list = boardLikeService.list();

      for (BoardLike boardLike : list) {
        out.println("<table><tr>");
        out.printf("<td>회원번호 : ");
        out.printf("%d</td>", boardLike.getUserNo());
        out.printf("<td>레시피 번호 : ");
        out.printf("%d</td>", boardLike.getRecipeNo());
        out.printf("<td>등록일 : ");
        out.printf("%s</td>", boardLike.getRegisteredDate());
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
