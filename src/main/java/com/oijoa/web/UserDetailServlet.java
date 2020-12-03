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

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>MyPage</title></head>");
      out.println("<body>");
      try {
        out.println("<h1>[정보 수정]</h1>");
        
        User user = userService.get();
        
        out.printf("이름: <input type='text' name='name' value='%s' readonly><br>\n",
            user.getName());
        out.printf("닉네임: <input type='text' name='nick' value='%s'><br>\n",
            user.getNick());
        out.printf("이메일: <input type='text' name='email' value= '%s' readonly><br>\n",
            user.getEmail());
        out.println("비밀번호: <button>비밀번호 변경</button>");
        out.println("배송지: <button>내 주소</button>");
        out.println("<p>");
        out.println("<button>변경</button>");
        out.println("<button>취소</button>");
        out.println("</p>");
        
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
