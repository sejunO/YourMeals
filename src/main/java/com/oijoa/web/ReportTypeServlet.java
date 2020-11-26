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
import com.oijoa.domain.ReportType;
import com.oijoa.service.ReportTypeService;

@WebServlet("/reportType")
public class ReportTypeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    ReportTypeService reportTypeService = (ReportTypeService) ctx.getAttribute("reportTypeService");

    try {

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>reportTypeService</title></head>");
      out.println("<body><h1>안녕하세요</h1>");

      out.println("[신고 목록]");
      List<ReportType> list = reportTypeService.list();

      out.println("<table border='1'><tr>"
          + "<th>신고 번호</th>"
          + "<th>신고내용</th></tr>");

      for (ReportType reportType : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", reportType.getReportTypeNo());
        out.printf("<td>%s</td>", reportType.getReportTypename());
        out.println("</tr>");
      }
      out.println("</table></body></html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
    }

  }


}
