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

@WebServlet("/QnA")
public class QnaServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    QnaService qnaService = (QnaService) ctx.getAttribute("qnaService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>qnaList</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[Q/A 목록]");
      List<Qna> list = qnaService.list();

      for (Qna qna : list) {
        out.println("<table><tr>");
        out.printf("<td>질문번호 : ");
        out.printf("%d</td>", qna.getQnaNo());
        out.printf("<td>회원번호 : ");
        out.printf("%d</td>", qna.getUserNo());
        out.printf("<td>질문 : ");
        out.printf("%s</td>", qna.getContent());
        out.printf("<td>등록일 : ");
        out.printf("%s</td>", qna.getCreatedDate());
        out.printf("<td>답변 : ");
        out.printf("%s</td>", qna.getAnswer());
        out.printf("<td>답변일 : ");
        out.printf("%s</td>", qna.getAnswerDate());
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
