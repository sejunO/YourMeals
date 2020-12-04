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
import com.oijoa.domain.User;
import com.oijoa.service.UserService;

@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    UserService userService =
        (UserService) ctx.getAttribute("userService");

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>정보수정</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>정보 수정</h1>");

      List<User> list = userService.list();

      out.println("<table border='1'>");
      out.println("<thead><tr>"
          + "<tr>이름</th>"
          + "<th>닉네임</th>"
          + "<th>이메일</th>"
          + "<th>비밀번호</th>"
          + "<th>나의배송지</th>"
          + "</tr></thead>");
      out.println("<tbody>");

      for(User user : list) {
        out.printf("<tr>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            user.getName(),
            user.getNick(),
            user.getEmail(),
            user.getPassword(),
            user.getAddress());
      }
      out.println("</tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.printf("<p>작업 처리 중 오류 발생! - %s</p>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));

      out.printf("<pre>%s</pre>\n", errOut.toString());
    }
    out.println("</body>");
    out.println("</html>");
  }
}
