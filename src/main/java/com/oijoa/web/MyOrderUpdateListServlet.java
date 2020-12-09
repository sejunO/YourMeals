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
          + "<th>주문금액</th>"
          + "<th>상태</th></tr>");

      int totalPrice;
      String orderStatus;

      for (Order order : list) {

        totalPrice = 0;
        for (OrderList orderlist : order.getOrderLists()) {
          totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
        }

        switch (order.getStatus()) {    // 조건
          case 11: orderStatus = "취소신청"; break;
          case 12: orderStatus = "취소진행중"; break;
          case 13: orderStatus = "취소(환불)완료"; break;
          case 21: orderStatus = "반품신청"; break;
          case 22: orderStatus = "반품진행중"; break;
          case 23: orderStatus = "반품(환불)완료"; break;
          case 31: orderStatus = "교환신청"; break;
          case 32: orderStatus = "교환진행중"; break;
          case 33: orderStatus = "교환완료"; break;
          default:
            orderStatus = "상태값오류";
        }


        out.printf("<tr>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s %s</td>"
            + "<td>%s 외 %d 건</td>"
            + "<td>%d원</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            order.getOrderDate(),
            order.getOrderNo(),
            order.getPostNo(),
            order.getAddress(),
            order.getDetailAddress(),
            order.getOrderLists().get(0).getOrderProduct().getContent(),
            order.getOrderLists().size() - 1,
            totalPrice,
            orderStatus);
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
