package com.oijoa.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Product;
import com.oijoa.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController{

  @Autowired
  ProductService productService;

  @RequestMapping("list")
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ModelAndView mv = new ModelAndView();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>servlet03</title></head>");
    out.println("<body><h1>안녕하세요</h1>");

    out.println("[게시물 목록]");

    List<Product> list = productService.list(null);

    for (Product product : list) {
      out.println("<table><tr>");
      out.printf("<td>번호 : ");
      out.printf("%s</td>", product.getProductNo());

      out.println("</tr></table>");
      out.println();
    }
    out.println("</body>");
    out.println("</html>");
  } catch (Exception e) {
    request.setAttribute("exception", e);
    request.getRequestDispatcher("/error.jsp").forward(request, response);
  }
  return mv;
}


}
