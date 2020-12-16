package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.OrderListService;

@Controller
@RequestMapping("/order/list")
public class OrderListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    HttpSession session = request.getSession();
    ServletContext ctx = request.getServletContext();
    OrderListService orderListService = (OrderListService) ctx.getAttribute("orderListService");

    try {
      User loginUser = (User) session.getAttribute("loginUser");
      List<OrderList> list = orderListService.myList(loginUser.getUserNo());
      
      int totalPrice;
      String orderStatus;
      totalPrice = 0;
      
      for (Order order : list) {
        for (OrderList orderlist : order.getOrderLists()) {
          totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
        }
      
      request.setAttribute("list", list);
      
      
      
      
      request.getRequestDispatcher("/order/list.jsp").include(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
    }

  }


}
