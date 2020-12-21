package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Product;
import com.oijoa.service.ProductService;

//@Controller
@RequestMapping("/product")
public class ProductController{

  @Autowired
  ProductService productService;

  @RequestMapping("list")
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    ModelAndView mv = new ModelAndView();
    List<Product> list = productService.list(null);
    mv.addObject("list", list);
    mv.setViewName("/product/list.jsp");
    return mv;
  }
  @RequestMapping("add")
  public String add() throws Exception {

    return null;
  }


}
