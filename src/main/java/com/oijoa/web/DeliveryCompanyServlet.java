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
import com.oijoa.domain.DeliveryCompany;
import com.oijoa.service.DeliveryCompanyService;

@WebServlet("/deliveryCompany")
public class DeliveryCompanyServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    DeliveryCompanyService deliveryCompanyService = (DeliveryCompanyService) ctx.getAttribute("deliveryCompanyService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>DeliveryCompanyService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[댓글 목록]");
      List<DeliveryCompany> list = deliveryCompanyService.list();

      for (DeliveryCompany deliveryCompany : list) {
        out.println("<table><tr>");
        out.printf("<td>배송번호: ");
        out.printf("%d</td>", deliveryCompany.getDeliveryNo());
        out.printf("<td>배송사이름 : ");
        out.printf("%d</td>", deliveryCompany.getDeliveryName());

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
