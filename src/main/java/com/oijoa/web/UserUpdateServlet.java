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
    out.println("<title>MyPage</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>[정보 수정]</h1>");

<<<<<<< HEAD
      List<User> list = userService.list();
=======
>>>>>>> d919114c4056cbbbab23d8e1e90c740f431b330a
      User loginUser = (User) session.getAttribute("loginUser");
      User user = userService.get(loginUser.getUserNo());
      
      user.setName(request.getParameter("name"));
      user.setNick(request.getParameter("nick"));
      user.setPassword(request.getParameter("password"));
      user.setPostNo(request.getParameter("postno"));
      user.setAddress(request.getParameter("addr"));
      user.setDetailAddress(request.getParameter("det_addr"));
      int no = userService.update(user);
<<<<<<< HEAD

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
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setNick(request.getParameter("nick"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setPostNo(request.getParameter("postno"));
        user.setAddress(request.getParameter("addr"));
        user.setDetailAddress(request.getParameter("det_addr"));
        int no = userService.update(user);
=======
>>>>>>> d919114c4056cbbbab23d8e1e90c740f431b330a

        if(no != 0) {
          out.println("<p>수정이 완료되었습니다.</p>");
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

