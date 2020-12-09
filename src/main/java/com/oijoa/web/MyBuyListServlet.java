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
      List<Order> list = orderService.myList(loginUser.getUserNo());
      
      out.println("<table border = '1'><tr>"
          + "<th>주문정보</th>"
          + "<th>구매내역</th>"
          + "<th>배송상태</th>");
      out.println("</tr>");

      for(Order order : list) {
        out.println("<tr>");
        out.printf("<td><h4>%tY년 %tm월 %td일</h4>",
            order.getOrderDate(),
            order.getOrderDate(),
            order.getOrderDate());
        out.printf("주문번호<br> %d</td>", order.getOrderNo());
      }
      
      out.println("</table>");
      out.println("<hr>\n");
      
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
    out.println("</body>");
    out.println("</html>");
  }
}
