package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Basket;
import com.oijoa.domain.Order;
import com.oijoa.domain.User;
import com.oijoa.service.OrderService;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    HttpSession session = request.getSession();
    ServletContext ctx = request.getServletContext();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");

    try {

      User loginUser = (User) session.getAttribute("loginUser");
      List<Order> list = orderService.myList(loginUser.getUserNo());

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>OrderList</title></head>");
      out.println("<body><h1>주문목록</h1>");
      out.println("<a href='address/form'>배송지 설정</a><br>");

      out.println("<table border='1'>");
      out.println("<thead><tr>"
          + "<th>주문항목</th>"
          + "<th>결제정보</th>"
          + "<th>주문일</th>"
          + "<th>주소</th>"
          + "<th>상세주소</th>"
          + "<th>메모</th>"
          + "<th>배송</th>"
          + "<th>운송장번호</th>"
          + "<th>장바구니 정보</th>"
          + "</tr></thead>");
      out.println("<tbody>");

      for (Order order : list) {
        StringBuilder baskets = new StringBuilder();

        for (Basket basket : order.getBaskets()) {
          if (baskets.length() > 0) {
            baskets.append(",");
          }
          baskets.append(basket.getProduct().getContent());
        }
        out.printf("<tr>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"</tr>\n",
            order.getOrderNo(),
            order.getPaymentNo(),
            order.getOrderDate(),
            order.getAddress(),
            order.getDetailAddress(),
            order.getMemo(),
            order.getDeleveryCompanyNo(),
            order.getTransportNo(),
            baskets.toString()
            );
      }

      out.println("</tbody>");
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
