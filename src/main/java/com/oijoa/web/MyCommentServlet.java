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
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Comment;
import com.oijoa.domain.User;
import com.oijoa.service.CommentService;

@WebServlet("/mypage/mycomment/list")
public class MyCommentServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    CommentService commentService = (CommentService) ctx.getAttribute("commentService");

    HttpSession session = request.getSession();
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>내가 작성한 댓글</title></head>");
      out.println("<body>");
      out.println("<h1>[내가 작성한 댓글]</h1>");
       
      User loginUser = (User) session.getAttribute("loginUser");
      Comment comment = commentService.list(loginUser.getUserNo());

      out.println("<table border = '1'><tr>"
          + "<th>댓글</th>"
          + "<th>작성일</th></tr>");
      
        out.printf("<tr>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            comment.getContent(),
            comment.getCreatedDate());
      
        out.println("</table>");
        out.println("<hr>\n");
        
        out.println("<a href=../index.html><button>뒤로가기<button></a><br>\n");
        out.println("<a href=../../index.html><button>홈으로<button></a><br>\n");
        
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
