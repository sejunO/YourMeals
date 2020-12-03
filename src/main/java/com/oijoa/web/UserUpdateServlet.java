package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Qna;
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

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta http-equiv='Refresh' content='2;url=detail'>");
    out.println("<title>MyPage</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>[정보 수정]</h1>");
      
      out.println("<form action='update' method='post'>");
      User user = new User();
      user.setNick(request.getParameter("nick"));
      user.setPassword(request.getParameter("password"));
      user.setPostNo(request.getParameter("postno"));
      user.setAddress(request.getParameter("addr"));
      user.setDetailAddress(request.getParameter("det_addr"));
      userService.update(user);
      out.println("<p>수정이 완료되었습니다.</p>");
      out.println("</form>");
      
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
