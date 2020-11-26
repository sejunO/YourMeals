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

import com.oijoa.domain.User;
import com.oijoa.service.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    UserService userService = (UserService) ctx.getAttribute("UserService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Recipe Test</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      List<User> list = userService.list();

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>회원유형</th>"
          + "<th>포인트</th>"
          + "<th>이름</th>"
          + "<th>닉네임</th>"
          + "<th>이메일</th>"
          + "<th>암호</th>"
          + "<th>우편번호</th>"
          + "<th>기본주소</th>"
          + "<th>상세주소</th>"
          + "<th>사진</th></tr>");

      for (User user : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", user.getUserNo());
        out.printf("<td>%d</td>", user.getUserTypeNo());
        out.printf("<td>%d</td>", user.getPoint());
        out.printf("<td>%s</td>", user.getName());
        out.printf("<td>%s</td>", user.getNick());
        out.printf("<td>%s</td>", user.getEmail());
        out.printf("<td>%s</td>", user.getPassword());
        out.printf("<td>%s</td>", user.getPostNo());
        out.printf("<td>%s</td>", user.getAddress());
        out.printf("<td>%s</td>", user.getDetailAddress());
        out.printf("<td>%s</td>", user.getPhoto());
        out.println("</tr>");
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
