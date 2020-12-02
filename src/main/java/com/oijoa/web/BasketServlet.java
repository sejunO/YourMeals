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
import com.oijoa.domain.Basket;
import com.oijoa.service.BasketService;

@WebServlet("/basket/list")
public class BasketServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    BasketService basketService = (BasketService) ctx.getAttribute("basketService");

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>BasketService</title></head>");
    out.println("<body><h1>장바구니</h1>");
    try {
      out.println("<p>[장바구니 목록]</p>");
      out.println("<a href='form'>장바구니 등록</a><br>");
      List<Basket> list = basketService.list();

      out.println("<table border='1'>");
      out.println("<thead><tr>"
          + "<th>상품정보 :</th>"
          + "<th>수량 :</th>"
          + "<th>가격 :</th>"
          + "<th>회원번호 :</th>"
          + "</tr></thead>");
      out.println("<tbody>");

      for (Basket basket : list) {
        out.printf("<tr>"
            +"<td>%s</td>"
            +"<td>%d</td>"
            +"<td>%s</td>"
            +"<td>%d</td>"
            +"</tr>\n",
            basket.getProducts().getContent(), basket.getAmount(), basket.getProducts().getPrice(), basket.getUserNo());
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
