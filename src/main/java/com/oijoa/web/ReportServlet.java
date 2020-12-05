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
import com.oijoa.domain.Report;
import com.oijoa.service.ReportService;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    ReportService reportService = (ReportService) ctx.getAttribute("reportService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>reportService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[신고 목록]");
      List<Report> list = reportService.list();

      out.println("<table border='1'><tr>"
          + "<th>신고번호</th>"
          + "<th>신고받은사람</th>"
          + "<th>신고한사람</th>"
          + "<th>신고종류</th>"
          + "<th>신고내용</th>"
          + "<th>신고일</th>"
          + "<th>신고상태</th></tr>");

      for (Report report : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", report.getReportNo());
        out.printf("<td>%d</td>", report.getReporter());
        out.printf("<td>%d</td>", report.getAttacker());
        out.printf("<td>%d</td>", report.getReprotTypeNo());
        out.printf("<td>%s</td>", report.getContent());
        out.printf("<td>%s</td>", report.getRegisteredDate());
        out.printf("<td>%d</td>", report.getStat());
        out.println("</tr>");
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
