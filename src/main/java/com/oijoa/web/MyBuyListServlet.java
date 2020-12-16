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

@WebServlet("/mypage/buy/list")
public class MyBuyListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html; charset = UTF-8");

    HttpSession session = request.getSession();
    ServletContext ctx = request.getServletContext();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");

    try {
      User loginUser = (User) session.getAttribute("loginUser");
      List<Order> list = orderService.myBuyList(loginUser.getUserNo());
      
      int totalPrice = 0;
      
      for (Order order : list) {
        for (OrderList orderlist : order.getOrderLists()) {
          totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
        }
        order.setTotalPrice(totalPrice);
        totalPrice = 0;
      }
      request.setAttribute("list", list);

      request.getRequestDispatcher("/mypage/order/buyList.jsp").include(request, response);
    
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
