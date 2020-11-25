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
import com.oijoa.domain.Payment;
import com.oijoa.service.PaymentService;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    PaymentService paymentService = (PaymentService) ctx.getAttribute("paymentService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>servlet03</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[지불방법 목록]");

      List<Payment> list = paymentService.list(null);

      for (Payment payment : list) {
        out.println("<table><tr>");
        out.printf("<td>지불방법 번호 : ");
        out.printf("%d</td>", payment.getPaymentNo());
        out.printf("<td>지불방법 : ");
        out.printf("%s</td>", payment.getName());

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
