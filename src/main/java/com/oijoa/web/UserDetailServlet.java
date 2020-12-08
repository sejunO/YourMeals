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
import com.oijoa.domain.User;
import com.oijoa.service.UserService;

@WebServlet("/mypage/user/detail")
public class UserDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    UserService userService =
        (UserService) ctx.getAttribute("userService");

    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>정보수정</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>[정보 수정]</h1>");

      User loginUser = (User) session.getAttribute("loginUser");
      User user = userService.get(loginUser.getUserNo());

      out.println("<form action = 'update' method = 'post'>");
      out.printf("이름: <input type='text' name='name' value='%s' readonly><br>\n",
          user.getName());
      out.printf("닉네임: <input type='text' name='nick' value='%s'><br>\n",
          user.getNick());
      out.printf("이메일: <input type='text' name='email' value= '%s' readonly><br>\n",
          user.getEmail());
      out.printf("비밀번호: <input type='text' name='password' value= '%s'><br>\n",
          user.getPassword());
      out.printf("우편번호: <input type='text' name='postno' value= '%s'><br>\n",
          user.getPostNo());
      out.printf("기본주소: <input type='textarea' name='addr' value= '%s'><br>\n",
          user.getAddress());
      out.printf("세부주소: <input type='det_addr' name='det_addr' value= '%s'><br>\n",
          user.getDetailAddress());
      out.print("<p>");
      out.print("<button>변경</button>");
      out.print("</form>");
      out.println("<a href='../index.html'><button>취소</button></a>");
      out.print("</p>");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    out.println("</body>");
    out.println("</html>");
  }
}
