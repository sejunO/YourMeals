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
      out.println("<head><title>User Test</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      
      List<User> list = userService.list();

      for (User user : list) {
    	out.println("<table border='1'>");
        out.println("<tr>");
        out.printf("<td>회원번호: %d</td>", user.getUserNo());
        out.printf("<td>회원유형: %d</td>", user.getUserTypeNo());
        out.printf("<td>포인트: %d</td>", user.getPoint());
        out.printf("<td>이름: %s</td>", user.getName());
        out.printf("<td>닉네임: %s</td>", user.getNick());
        out.printf("<td>이메일: %s</td>", user.getEmail());
        out.printf("<td>암호: %s</td>", user.getPassword());
        out.printf("<td>우편번호: %s</td>", user.getPostNo());
        out.printf("<td>기본주소: %s</td>", user.getAddress());
        out.printf("<td>상세주소: %s</td>", user.getDetailAddress());
        out.printf("<td>사진: %s</td>", user.getPhoto());
        out.println("</tr>");
      }
      out.println("</table>"
    		  	+ "</body>"
      			+ "</html>");
      	
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
