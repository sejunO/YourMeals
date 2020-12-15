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
      //
      //      switch (order.getStatus()) {    // 조건
      //        case 11: orderStatus = "취소신청"; break;
      //        case 12: orderStatus = "취소진행중"; break;
      //        case 13: orderStatus = "취소(환불)완료"; break;
      //        case 21: orderStatus = "반품신청"; break;
      //        case 22: orderStatus = "반품진행중"; break;
      //        case 23: orderStatus = "반품(환불)완료"; break;
      //        case 31: orderStatus = "교환신청"; break;
      //        case 32: orderStatus = "교환진행중"; break;
      //        case 33: orderStatus = "교환완료"; break;
      //        default:
      //          orderStatus = "상태값오류";
      //      }
      //          order.getOrderDate(),
      //          order.getOrderNo(),
      //          order.getPostNo(),
      //          order.getAddress(),
      //          order.getDetailAddress(),
      //          order.getOrderLists().get(0).getOrderProduct().getContent(),
      //          order.getOrderLists().size() - 1,
      //          totalPrice,
      //          orderStatus);
      //    }
      request.getRequestDispatcher("/mypage/order/updateList.jsp").include(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
