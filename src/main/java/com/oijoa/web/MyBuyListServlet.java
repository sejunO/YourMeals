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

      User loginUser = (User) session.getAttribute("loginUser");
      List<Order> list = orderService.myBuyList(loginUser.getUserNo());
      request.setAttribute("list", list);
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
