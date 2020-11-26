package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Notice;
import com.oijoa.service.NoticeService;

@WebServlet("/notice/add")
public class NoticeAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {


    ServletContext ctx = request.getServletContext();
    NoticeService noticeService = (NoticeService) ctx.getAttribute("noticeService");

    request.setCharacterEncoding("UTF-8");



    //    HttpSession session = request.getSession();

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta http-equiv='Refresh' content='1;list'>");
    out.println("<title>공지사항 등록</title></head>");
    out.println("<body>");
    try {

      Notice notice = new Notice();

      notice.setNoticeNo(1);
      notice.setTitle(request.getParameter("title"));
      notice.setContent(request.getParameter("content"));
      noticeService.add(notice);

      out.println("게시글을 등록하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }
    out.println("</body>");
    out.println("</html>");
  }
}
