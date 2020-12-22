package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public void list(HttpServletRequest request, Model model) throws Exception {

    HttpSession session = request.getSession();
    User loginUser = (User) session.getAttribute("loginUser");

    List<Basket> basketList = basketService.myList(loginUser.getUserNo());

    model.addAttribute("basketList", basketList);
  }

  @RequestMapping("form")
  public void form(HttpServletRequest request, Model model) throws Exception {
    model.addAttribute("products", productService.list());
  }

  @RequestMapping("add")
  public String add(HttpSession session, Basket basket) throws Exception {

    User loginUser = (User) session.getAttribute("loginUser");
    basket.setWriter(loginUser);
    basketService.add(basket);
    return "redirect:list";
  }
}

