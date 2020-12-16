package com.oijoa.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.OrderService;

@WebServlet("/mypage/order/updatelist")
public class MyOrderUpdateListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");

    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");

    try {
      User loginUser = (User) session.getAttribute("loginUser");

      List<Order> list = orderService.myUpdateList(loginUser.getUserNo());
      int totalPrice = 0;
      for (Order order : list) {
        for (OrderList orderList : order.getOrderLists()) {
          totalPrice += (orderList.getPrice() - orderList.getDiscount()) * orderList.getAmount();
        }
        order.setTotalPrice(totalPrice);
        totalPrice = 0;
      }
      request.setAttribute("list", list);
      request.getRequestDispatcher("/mypage/order/updateList.jsp").include(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
