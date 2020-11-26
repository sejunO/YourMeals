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
import com.oijoa.domain.KakaoPay;
import com.oijoa.service.KakaoPayService;

@WebServlet("/kakaoPay")
public class KakaoPayServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    KakaoPayService kakaoPayService = (KakaoPayService) ctx.getAttribute("kakaoPayService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>kakaoPayService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[주문정보]");
      List<KakaoPay> list = kakaoPayService.list();

      for (KakaoPay kakaoPay : list) {
        out.println("<table><tr>");
        out.printf("<td>주문번호: ");
        out.printf("%d</td>", kakaoPay.getOrderNo());
        out.printf("<td>주문이름: ");
        out.printf("%s</td>", kakaoPay.getName());
        out.printf("<td>총금액: ");
        out.printf("%s</td>", kakaoPay.getAccount());
        out.printf("<td>송금일: ");
        out.printf("%s</td>", kakaoPay.getTransferedDate());


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
