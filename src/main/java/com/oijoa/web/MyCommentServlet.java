package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Comment;
import com.oijoa.domain.User;
import com.oijoa.service.CommentService;

@WebServlet("/mypage/mycomment/list")
public class MyCommentServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    CommentService commentService = (CommentService) ctx.getAttribute("commentService");

    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    try {

      User loginUser = (User) session.getAttribute("loginUser");
      
      List<Comment> list = commentService.userNoList(loginUser.getUserNo());
      request.setAttribute("list", list);
      
      request.getRequestDispatcher("/mypage/mycomment/list.jsp").include(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
