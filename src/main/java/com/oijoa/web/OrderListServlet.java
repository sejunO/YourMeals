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

@WebServlet("/order/list")
public class OrderListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>OrderList</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      System.out.println("osadfasd");
      List<Order> list = orderService.list();

      for (Order order : list) {
        out.println("<table><tr>");
        out.printf("<td>번호 : ");
        out.printf("%d</td>", order.getOrderNo());
        out.printf("<td>번호 : ");
        out.printf("%d</td>", order.getPaymentNo());
        out.printf("<td>번호 : ");
        out.printf("%s</td>", order.getAddress());
        out.printf("<td>번호 : ");
        out.printf("%s</td>", order.getDetailAddress());
        out.println("</tr></table>");
        out.println();
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
