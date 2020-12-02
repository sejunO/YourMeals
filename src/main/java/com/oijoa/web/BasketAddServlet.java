package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Basket;
import com.oijoa.domain.Product;
import com.oijoa.service.BasketService;

@WebServlet("/basket/add")
public class BasketAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ServletContext ctx = request.getServletContext();
    BasketService basketService =
        (BasketService) ctx.getAttribute("basketService");

    // 클라이언트가 POST 요청할 때 보낸 데이터를 읽는다.
    //request.setCharacterEncoding("UTF-8");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    //    out.println("<meta http-equiv='Refresh' content='1;url=list'>");
    out.println("<title>장바구니 등록</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>장바구닝 등록</h1>");

      Basket basket = new Basket();
      basket.setAmount(Integer.parseInt(request.getParameter("amount")));

      HttpSession session = request.getSession();


      List<Product> products = new ArrayList<>();
      String[] materialList = request.getParameterValues("products");
      if(materialList != null) {
        for (String material : materialList) {
          Product product = new Product();
          product.setProductNo(Integer.parseInt(material));
          products.add(product);
        }
        basket.setProduct(products);
        basketService.add(basket);
      }

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
