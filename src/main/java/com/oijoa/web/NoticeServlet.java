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
import com.oijoa.domain.Notice;
import com.oijoa.service.NoticeService;

@WebServlet("/notice")
public class NoticeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    NoticeService noticeService = (NoticeService) ctx.getAttribute("noticeService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>NoticeService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[공지사항 목록]");
      List<Notice> list = noticeService.list();

      for (Notice notice : list) {
        out.println("<table><tr>");
        out.printf("<td>공지사항 번호 : ");
        out.printf("%d</td>", notice.getNoticeNo());
        out.printf("<td>공지사항 타입 번호 : ");
        out.printf("%d</td>", notice.getNoticeTypeNo());
        out.printf("<td>제목 : ");
        out.printf("%s</td>", notice.getTitle());
        out.printf("<td>내용 : ");
        out.printf("%s</td>", notice.getContent());
        out.printf("<td>등록일 : ");
        out.printf("%s</td>", notice.getRegisteredDate());
        out.println("</tr></table>");
        out.println();
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
