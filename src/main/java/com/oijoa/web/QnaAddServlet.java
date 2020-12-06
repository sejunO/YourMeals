package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Qna;
import com.oijoa.domain.User;
import com.oijoa.service.QnaService;

@WebServlet("/mypage/qna/add")
public class QnaAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    QnaService qnaService = (QnaService) ctx.getAttribute("qnaService");

    Qna qna = new Qna();
    qna.setTitle(request.getParameter("title"));
    qna.setContent(request.getParameter("content"));

    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<meta http-equiv='Refresh' content='1;url=list'>");
    out.println("<title>MyPage</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>[QnA 게시글 등록]</h1>");

      User loginUser = (User) session.getAttribute("loginUser");
      qna.setWriter(loginUser);

      qnaService.add(qna);

      out.println("<p>게시글을 등록하였습니다.</p>");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

    out.println("</body>");
    out.println("</html>");
  }
}