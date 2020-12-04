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

@WebServlet("/user/list")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    UserService userService = (UserService) ctx.getAttribute("userService");

    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Recipe Test</title></head>");
      out.println("<body>");
      out.println("<h1>사용자 목록</h1>");

      List<User> list = userService.list();

      out.println("<table border='1'><tr>"
          + "<th>번호</th>"
          + "<th>이름</th>"
          + "<th>닉네임</th></tr>");

      for (User user : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", user.getUserNo());
        out.printf("<td><a href='recipe?userNo=%d&userName=%s'>%s</a></td>"
            ,user.getUserNo() 
            ,user.getName() 
            ,user.getName());
        out.printf("<td>%s</td>", user.getNick());
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("<hr>\n");
      out.println("<a href=../index.html>뒤로가기</a><br>\n");
      out.println("<a href=../index.html>홈으로</a><br>\n");
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
