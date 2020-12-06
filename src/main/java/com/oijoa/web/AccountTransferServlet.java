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
import com.oijoa.domain.AccountTransfer;
import com.oijoa.service.AccountTransferService;

@WebServlet("/accountTransfer")
public class AccountTransferServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    AccountTransferService accountTransferService = (AccountTransferService) ctx.getAttribute("accountTransferService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>servlet03</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[게시물 목록]");

      List<AccountTransfer> list = accountTransferService.list();

      for (AccountTransfer accountTransfer : list) {
        out.println("<table><tr>");
        out.printf("<td>주문번호 : ");
        out.printf("%d</td>", accountTransfer.getOrderNo());
        out.printf("<td>회원정보 : ");
        out.printf("%s</td>", accountTransfer.getUserName());
        out.printf("<td>가격 : ");
        out.printf("%s</td>", accountTransfer.getAccount());
        out.printf("<td>배송일: ");
        out.printf("%s</td>", accountTransfer.getTransferedDate());
        out.printf("<td> 은행명: ");
        out.printf("%s</td>", accountTransfer.getBankName());

        out.println("</tr></table>");
        out.println();
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
