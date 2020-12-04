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
import com.oijoa.service.OrderService;

@WebServlet("/address/form")
public class AddressAddFormServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");
    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>장바구니 등록</title></head>");
    out.println("<body>");

    try {
      //      User loginUser = (User) session.getAttribute("loginUser");
      //      List<Order> list = orderService.myList(loginUser.getUserNo());

      out.println("<h1>주소 등록 </h1>");

      out.println("<form action='add' method='post'>");
      out.println("주소: <input type='text' name='address'><br>");
      out.println("상세주소: <textarea name='detailAddress' rows='10' cols='60'></textarea><br>");

      out.println("<button>생성</button>");
      out.println("</form>");

      out.println("<p>배송주소를 등록하였습니다.</p>");

    } catch (Exception e) {
      out.printf("<p>작업 처리 중 오류 발생! - %s</p>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));
      out.printf("<pre>%s</pre>\n",errOut.toString());
    }
    out.println("</body>");
    out.println("</html>");
  }
}
