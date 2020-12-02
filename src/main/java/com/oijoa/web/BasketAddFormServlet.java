package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Product;
import com.oijoa.service.BasketService;
import com.oijoa.service.ProductService;

@WebServlet("/basket/form")
public class BasketAddFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    ProductService productService =
        (ProductService) ctx.getAttribute("productService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>장바구니 등록</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>장바구니 생성</h1>");

      out.println("<form action='add' method='post'>");
      out.println("수량 : <input type='int' name='amount'><br> ");
      out.println("<ul>");

      List<Product> products = productService.list(null);

      for (Product p : products) {
        out.printf("<li><input type='radio' name='products' value='%d'>%s</li>\n",
            p.getProductNo(),
            p.getContent());
      }
      out.println("</ul><br>");
      out.println("<button>생성</button>");
      out.println("</form>");

    } catch (Exception e) {
      out.println("<h2>작업 처리 중 오류 발생!</h2>");
      out.printf("<pre>%s</pre>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));
      out.println("<h3>상세 오류 내용</h3>");
      out.printf("<pre>%s</pre>\n", errOut.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}
