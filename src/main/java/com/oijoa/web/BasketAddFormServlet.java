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
    BasketService basketService =
        (BasketService) ctx.getAttribute("basketService");

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

      List<Product> products = productService.list();
      for (Product p : products) {
        out.printf("<li><input type='radio' name='product' value='%d'>%s</li>\n",
            p.getProductNo(),
            p.getContent());
      }

      out.println("</ul><br>");
      out.println("<button>생성</button>");
      out.println("</form>");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

    out.println("</body>");
    out.println("</html>");
  }
}
