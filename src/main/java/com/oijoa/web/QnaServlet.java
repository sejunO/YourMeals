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

@WebServlet("/mypage/qna/list")
public class QnaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    QnaService qnaService = (QnaService) ctx.getAttribute("qnaService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>MyPage</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>[QnA 게시글 목록]</h1>");

      out.println("<a href='form.html'>글쓰기</a><br>");

      List<Qna> list = qnaService.list();

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>제목</th>"
          + "<th>등록일</th>"
          + "<th>진행상태</th></tr>");

      for (Qna qna : list) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td><a href='detail?no=%1$d'>%s</a></td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            qna.getQnaNo(),
            qna.getTitle(),
            qna.getCreatedDate(),
            qna.getAnswerStatus());
      }
      out.println("</table>");
      out.println("<hr>\n");
      out.println("<a href=../index.html>뒤로가기</a><br>\n");
      out.println("<a href=../../index.html>홈으로</a><br>\n");
      out.println("</body></html>");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    out.println("</body>");
    out.println("</html>");
  }
}