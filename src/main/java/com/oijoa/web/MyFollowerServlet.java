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
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.RecipeService;

@WebServlet("/mypage/follower/list")
public class MyFollowerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    FollowService followService = (FollowService) ctx.getAttribute("followService");

    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>MyPage</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>[My Follower 목록]</h1>");

      User loginUser = (User) session.getAttribute("loginUser");

      List<User> list = followService.myFollowerList(loginUser.getUserNo());

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>이름</th>"
          + "<th>닉네임</th></tr>");

      for (User user : list) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            user.getUserNo(),
            user.getName(),
            user.getNick());
      }
      out.println("</table>");
      out.println("<hr>\n");
      out.println("<a href=../index.html>뒤로가기</a><br>\n");
      out.println("<a href=../../index.html>홈으로</a><br>\n");
      out.println("</body></html>");
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