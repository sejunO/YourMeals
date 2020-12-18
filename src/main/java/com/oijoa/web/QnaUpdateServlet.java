package com.oijoa.web;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Qna;
import com.oijoa.service.QnaService;

//@WebServlet("/mypage/qna/update")
public class QnaUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    QnaService qnaService = (QnaService) ctx.getAttribute("qnaService");

    try {
      Qna qna = new Qna();
      qna.setQnaNo(Integer.parseInt(request.getParameter("no")));
      qna.setTitle(request.getParameter("title"));
      qna.setContent(request.getParameter("content"));
      int count = qnaService.update(qna);

      if (count == 0) {
        throw new Exception("<p>해당 번호의 게시글이 없습니다.</p>");
      }

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
