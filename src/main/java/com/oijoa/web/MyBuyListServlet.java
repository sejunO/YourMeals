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

@WebServlet("/mypage/buy/list")
public class MyBuyListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html; charset = UTF-8");
    PrintWriter out = response.getWriter();
    
    HttpSession session = request.getSession();
    ServletContext ctx = request.getServletContext();
    OrderService orderService = (OrderService) ctx.getAttribute("orderService");
    
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>나의주문내역</title></head>");
      out.println("<body>");
      out.println("<h1>주문내역 조회</h1>");
      
      User loginUser = (User) session.getAttribute("loginUser");
      List<Order> list = orderService.myBuyList(loginUser.getUserNo());
      
      out.println("<table border = '1'><tr>"
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

        switch (order.getStatus()) {    
          case 0: orderStatus = "입금확인중"; break;
          case 1: orderStatus = "결제완료"; break;
          case 2: orderStatus = "배송준비"; break;
          case 3: orderStatus = "배송중"; break;
          case 4: orderStatus = "배송완료"; break;
          
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
    out.println("</body>");
    out.println("</html>");
  }
}
