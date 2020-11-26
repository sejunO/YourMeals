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
import com.oijoa.domain.OrderList;
import com.oijoa.service.OrderListService;

@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    OrderListService orderListService = (OrderListService) ctx.getAttribute("orderListService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>OrderList</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      List<OrderList> list = orderListService.list();

      for (OrderList orderList : list) {
        out.println("<table><tr>");
        out.printf("<td>주문번호 : ");
        out.printf("%d</td>", orderList.getOrderListNo());
        out.printf("<td>주문번호 : ");
        out.printf("%d</td>", orderList.getOrderNo());
        out.printf("<td>상품번호 : ");
        out.printf("%d</td>", orderList.getProductNo());
        out.printf("<td>수량 : ");
        out.printf("%d</td>", orderList.getAmount());
        out.printf("<td>할인율 : ");
        out.printf("%d</td>", orderList.getDiscount());
        out.printf("<td>가격 : ");
        out.printf("%d</td>", orderList.getPrice());
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
