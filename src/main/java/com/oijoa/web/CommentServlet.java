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
import com.oijoa.domain.Comment;
import com.oijoa.service.CommentService;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    CommentService commentService = (CommentService) ctx.getAttribute("commentService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>CommentService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[댓글 목록]");
      List<Comment> list = commentService.list();

      for (Comment comment : list) {
        out.println("<table><tr>");
        out.printf("<td>댓글번호: ");
        out.printf("%d</td>", comment.getCommentNo());
        out.printf("<td>회원 번호 : ");
        out.printf("%d</td>", comment.getUserNo());
        out.printf("<td>레시피 번호 : ");
        out.printf("%d</td>", comment.getRecipeNo());
        out.printf("<td>댓글내용 : ");
        out.printf("%d</td>", comment.getContent());
        out.printf("<td>등록일 : ");
        out.printf("%d</td>", comment.getCreadtedDate());
        out.printf("<td>수정일 : ");
        out.printf("%d</td>", comment.getModifiedDate());

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
