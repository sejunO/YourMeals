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
import com.oijoa.domain.NoticeType;
import com.oijoa.service.NoticeTypeService;

@WebServlet("/noticeType")
public class NoticeTypeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    NoticeTypeService noticeTypeService = (NoticeTypeService) ctx.getAttribute("noticeTypeService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>NoticeTypeService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[공지사항 타입 목록]");
      List<NoticeType> list = noticeTypeService.list();

      for (NoticeType noticeType : list) {
        out.println("<table><tr>");
        out.printf("<td>공지사항 타입 번호 : ");
        out.printf("%d</td>", noticeType.getNoticeTypeNo());
        out.printf("<td>공지사항 타입 이름 : ");
        out.printf("%s</td>", noticeType.getName());
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
