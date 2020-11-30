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
import com.oijoa.domain.Qna;
import com.oijoa.service.QnaService;

@WebServlet("/qna")
public class QnaServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    QnaService qnaService = (QnaService) ctx.getAttribute("qnaService");

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>qnaList</title></head>");
    out.println("<body><h1>[QnA 목록]</h1>");
    try {
      out.println("[QnA 목록]");
      List<Qna> list = qnaService.list();

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>제목</th>"
          + "<th>등록일</th>"
          + "<th>진행상태</th></tr>");
      
      for (Qna qna : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", qna.getQnaNo());
        out.printf("<td>%s</td>", qna.getTitle());
        out.printf("<td>%s</td>", qna.getCreatedDate());
        out.printf("<td>%s</td>", qna.getAnswerStatus());
        out.println("</tr>");
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }
  }
}