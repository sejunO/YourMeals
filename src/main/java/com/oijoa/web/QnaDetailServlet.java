package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Qna;
import com.oijoa.service.QnaService;

@WebServlet("/qna/detail")
public class QnaDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    QnaService qnaService = (QnaService) ctx.getAttribute("qnaService");

    int no = Integer.parseInt(request.getParameter("no"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>MyPage</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>[QnA 게시글 조회]</h1>");

      Qna qna = qnaService.get(no);

      if (qna == null) {
        out.println("해당 번호의 게시글이 없습니다.");
        return;
      }
      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n",
          qna.getQnaNo());
      out.printf("제목: <input type='text' name='title' value='%s'><br>\n",
          qna.getTitle());
      out.printf("내용: <textarea name='content'>%s</textarea><br>\n",
          qna.getContent());
      //      out.printf("작성자: %s<br>\n", board.getWriter().getName());
      out.printf("등록일: %s<br>\n", qna.getCreatedDate());
      out.println("<p>");
      out.println("<button>변경</button>");
      out.printf("<a href='delete?no=%d'>삭제</a>\n", qna.getQnaNo());
      out.println("</p>");
      out.println("</form>");

    } catch (Exception e) {
      out.println("<h2>작업 처리 중 오류 발생!</h2>");
      out.printf("<pre>%s</pre>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));
      out.println("<h3>상세 오류 내용</h3>");
      out.printf("<pre>%s</pre>\n", errOut.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}