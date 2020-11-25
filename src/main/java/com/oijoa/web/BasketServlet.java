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

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    BasketService basketService = (BasketService) ctx.getAttribute("basketService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>BasketService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");
      List<Basket> list = basketService.list();

      for (Basket basket : list) {
        out.println("<table><tr>");
        out.printf("<td>은행번호 : ");
        out.printf("%d</td>", basket.getBankNo());
        out.printf("<td>상품번호 : ");
        out.printf("%d</td>", basket.getProductNo());
        out.printf("<td>수량 : ");
        out.printf("%d</td>", basket.getAmount());
        out.printf("<td>회원번호 : ");
        out.printf("%d</td>", basket.getUserNo());
        out.println("</tr></table>");
        out.println();
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
