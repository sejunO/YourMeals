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
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.OrderListService;

@WebServlet("/order/list")
public class OrderListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    HttpSession session = request.getSession();
    ServletContext ctx = request.getServletContext();
    OrderListService orderListService = (OrderListService) ctx.getAttribute("orderListService");

    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>OrderList</title></head>");
      out.println("<body><h1> 주문항목</h1>");

      out.println("[주문항목 목록]");
      User loginUser = (User) session.getAttribute("loginUser");
      System.out.println(loginUser.getUserNo());

      List<OrderList> list = orderListService.myList(loginUser.getUserNo());

      out.println("<table border='1'>");
      out.println("<thead><tr>"
          + "<th>주문항목</th>"
          + "<th>상품명</th>"
          + "<th>가격</th>"
          + "<th>할인율</th>"
          + "<th>사용자</th>"
          + "</tr></thead>");
      out.println("<tbody>");

      for (OrderList orderList : list) {
        out.printf("<tr>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"<td>%d</td>"
            +"<td>%s</td>"
            +"<td>%s</td>"
            +"</tr>\n",
            orderList.getOrderListNo(),
            orderList.getProductNo().getContent(),
            orderList.getPrice(),
            orderList.getDiscount(),
            orderList.getOrderNo().getUserNo()
            );
      }

      out.println("</tbody>");
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
