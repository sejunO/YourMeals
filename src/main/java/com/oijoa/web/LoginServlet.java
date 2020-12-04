package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.User;
import com.oijoa.service.UserService;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;



  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {



    // 클라이언트 전용 보관소(세션)를 준비한다.
    HttpSession session = request.getSession();

    // 클라이언트로 데이터를 출력할 때 사용할 스트림 준비
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {

      String email = request.getParameter("email");
      String password = request.getParameter("password");

      // 클라이언트에게 보낼 email 쿠키를 준비한다.
      Cookie emailCookie = new Cookie("email", email);

      if (request.getParameter("saveEmail") != null) {
        emailCookie.setMaxAge(60 * 60 * 24 * 7);
      } else {
        emailCookie.setMaxAge(0); // 유효기간이 0이면 삭제하라는 의미다.
      }

      response.addCookie(emailCookie);
      if (session.getAttribute("loginUser") != null) {
        out.println("<p>로그인 된 상태입니다.</p>");
      } else {

        // 서블릿이 로그인 작업에 사용할 도구를 준비한다.
        ServletContext ctx = request.getServletContext();
        UserService userService = (UserService) ctx.getAttribute("userService");

        User user = userService.get(email, password);
        if (user == null) {
          out.println("<p>사용자 정보가 맞지 않습니다.</p>");

        } else {
          // 로그인이 성공했으면 회원 정보를
          // 각 클라이언트의 전용 보관소인 session에 저장한다.
          session.setAttribute("loginUser", user);
          response.sendRedirect("../index.jsp");
        }
      }

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
