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
import com.oijoa.domain.Order;
import com.oijoa.service.OrderService;

@WebServlet("/order/add")
public class OrderAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");
    Order order = new Order();
    try {

      out.println("[게시물 목록]");
      List<Order> list = orderService.list();

      //      for (Order order : list) {
      //        out.println("<table><tr>");
      //        out.printf("<td>번호 : ");
      //        out.printf("%d</td>", order.getOrderNo());
      //        out.printf("<td>번호 : ");
      //        out.printf("%d</td>", order.getPaymentNo());
      //        out.printf("<td>번호 : ");
      //        out.printf("%s</td>", order.getAddress());
      //        out.printf("<td>번호 : ");
      //        out.printf("%s</td>", order.getDetailAddress());
      //        out.println("</tr></table>");
      //        out.println();
      //      }
      out.println("</body>");
      out.println("</html>");

      orderService.add(order);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
