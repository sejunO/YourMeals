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
import com.oijoa.domain.Refund;
import com.oijoa.service.RefundService;

@WebServlet("/refund")
public class RefundServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    RefundService refundService = (RefundService) ctx.getAttribute("refundService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>RecipeStepService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[환불 목록]");
      List<Refund> list = refundService.list();

      out.println("<table border='1'><tr>"
          + "<th>주문번호</th>"
          + "<th>등록일</th>"
          + "<th>환불상태</th>"
          + "<th>환불요청날짜</th>"
          + "<th>내용</th></tr>");

      for (Refund refund : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", refund.getOrderNo());
        out.printf("<td>%s</td>", refund.getRegisteredDate());
        out.printf("<td>%d</td>", refund.getStat());
        out.printf("<td>%s</td>", refund.getProcessedDate());
        out.printf("<td>%s</td>", refund.getRsn());
        out.println("</tr>");
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
