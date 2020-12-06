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
import com.oijoa.domain.DeliveryCompany;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.DeliveryCompanyService;
import com.oijoa.service.OrderListService;
import com.oijoa.service.OrderService;

@WebServlet("/order/add")
public class OrderAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @SuppressWarnings("null")
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    HttpSession session = request.getSession();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");
    DeliveryCompanyService deliveryCompanyService =
        (DeliveryCompanyService) ctx.getAttribute("deliveryCompanyService");
    OrderListService orderListService = (OrderListService) ctx.getAttribute("orderListService");
    User loginUser = (User) session.getAttribute("loginUser");
    try {
      DeliveryCompany dc = deliveryCompanyService.get(1);

      Order order = new Order();

      order.setUserNo(loginUser);
      order.setPaymentNo(Integer.parseInt(request.getParameter("payment")));
      order.setDeliveryCompanyNo(dc.getDeliveryNo());
      order.setTransportNo(Integer.parseInt(request.getParameter("postno")));
      order.setAddress(request.getParameter("addr"));
      order.setDetailAddress(request.getParameter("det_addr"));
      order.setMemo(request.getParameter("memo"));
      List<OrderList> orderLists = orderListService.makeList(loginUser.getUserNo());
      orderService.add(order);

      for (OrderList ol : orderLists) {
        orderService.add(ol);
      }
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }
  }
}
