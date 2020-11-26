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
import com.oijoa.domain.Follow;
import com.oijoa.service.FollowService;

@WebServlet("/follow")
public class FollowServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    FollowService followService = (FollowService) ctx.getAttribute("followService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>CommentService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[댓글 목록]");
      List<Follow> list = followService.list();

      for (Follow follow : list) {
        out.println("<table><tr>");
        out.printf("<td>팔로워: ");
        out.printf("%d</td>", follow.getFollower());
        out.printf("<td>팔로잉 : ");
        out.printf("%d</td>", follow.getFollowing());


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
