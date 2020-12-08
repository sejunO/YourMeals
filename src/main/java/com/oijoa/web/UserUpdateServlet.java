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

@WebServlet("/mypage/user/update")
public class UserUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
    out.println("<meta http-equiv='Refresh' content='2;url=detail'>");
    out.println("<title>정보수정</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>[정보 수정]</h1>");

      User loginUser = (User) session.getAttribute("loginUser");
      User user = userService.get(loginUser.getUserNo());

      user.setName(request.getParameter("name"));
      user.setNick(request.getParameter("nick"));
      user.setEmail(request.getParameter("email"));
      user.setPassword(request.getParameter("password"));
      user.setPostNo(request.getParameter("postno"));
      user.setAddress(request.getParameter("addr"));
      user.setDetailAddress(request.getParameter("det_addr"));
      int no = userService.update(user);

      if(no != 0) {
        out.println("<p>수정이 완료되었습니다.</p>");
      }

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    out.println("</body>");
    out.println("</html>");
  }
}

