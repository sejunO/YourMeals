package com.oijoa.web;

import java.io.IOException;
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

    try {

      User loginUser = (User) session.getAttribute("loginUser");
      User user = userService.get(loginUser.getUserNo());


      request.setAttribute("user", user);
      request.getRequestDispatcher("/mypage/user/detail.jsp").include(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
