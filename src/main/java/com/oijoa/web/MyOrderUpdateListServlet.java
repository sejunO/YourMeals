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

      List<Order> list = orderService.myUpdateList(loginUser.getUserNo());

      out.println("<table border='1'><tr>"
          + "<th>주문일자</th>"
          + "<th>주문번호</th>"
          + "<th>우편번호</th>"
          + "<th>배송지주소</th>"
          + "<th>주문항목</th>"
          + "<th>상태</th></tr>");

      for (Order order : list) {
        out.printf("<tr>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s %s</td>"
            + "<td>%s</td>"
            + "<td>%s 외 %d건</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            order.getOrderDate(),
            order.getOrderNo(),
            order.getPostNo(),
            order.getAddress(), order.getDetailAddress(),
            order.getProducts().get(0).getContent(), order.getProducts().size(),
            order.getStatus());
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
