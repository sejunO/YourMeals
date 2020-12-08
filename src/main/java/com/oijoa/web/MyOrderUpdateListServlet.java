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
import com.oijoa.domain.Order;
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
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>MyPage</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>[나의 주문 취소/교환/환불내역]</h1>");

      User loginUser = (User) session.getAttribute("loginUser");

      List<Order> list = orderService.myList(loginUser.getUserNo());

      out.println("<table border='1'><tr>"
          + "<th>주문항목</th>"
          + "<th>결제정보</th>"
          + "<th>주소</th>"
          + "<th>상세주소</th>"
          + "<th>메모</th>"
          + "<th>배송</th>"
          + "<th>운송장번호</th></tr>");

      for (Order order : list) {
        out.printf("<tr>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            order.getOrderNo(),
            order.getOrderNo(),
            order.getOrderDate(),
            order.getAddress(),
            order.getDetailAddress(),
            order.getMemo(),
            order.getTransportNo());
      }

      out.println("</table>");
      out.println("<hr>\n");
      out.println("<a href=../index.html>뒤로가기</a><br>\n");
      out.println("<a href=../../index.html>홈으로</a><br>\n");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
