package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Basket;
import com.oijoa.domain.User;
import com.oijoa.service.BasketService;
import com.oijoa.service.ProductService;

@Controller
@RequestMapping("/basket")
public class BasketController {

  @Autowired
  ProductService productService;

  @Autowired
  BasketService basketService;

  @RequestMapping("list")
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    HttpSession session = request.getSession();

    User loginUser = (User) session.getAttribute("loginUser");

    List<Basket> basketList = basketService.myList(loginUser.getUserNo());
    ModelAndView mv = new ModelAndView();
    mv.addObject("basketList", basketList);
    mv.setViewName("/basket/list.jsp");
    return mv;
  }

  @RequestMapping("form")
  public ModelAndView form(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("products", productService.list());
    mv.setViewName("/basket/newform.jsp");
    return mv;
  }

  @RequestMapping("add")
  public String add(HttpSession session, Basket basket) throws Exception {

    User loginUser = (User) session.getAttribute("loginUser");
    basket.setWriter(loginUser);
    basketService.add(basket);
    return "redirect:list";
  }

}

