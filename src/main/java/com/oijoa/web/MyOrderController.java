package com.oijoa.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.OrderService;

@Controller
@RequestMapping("/mypage/order")
@SessionAttributes("loginUser")
public class MyOrderController {

  @Autowired OrderService orderService;

  @GetMapping("orderList")
  public void orderList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    List<Order> orderList = orderService.myOrderList(loginUser.getUserNo());
    int totalPrice = 0;
    for (Order order : orderList) {
      for (OrderList orderlist : order.getOrderLists()) {
        totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
      }
      order.setTotalPrice(totalPrice);
      totalPrice = 0;
    }

    model.addAttribute("orderList", orderList);
  }

  @GetMapping("updateList")
  public void updateList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    List<Order> updateList = orderService.myUpdateList(loginUser.getUserNo());
    int totalPrice = 0;
    for (Order order : updateList) {
      for (OrderList orderlist : order.getOrderLists()) {
        totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
      }
      order.setTotalPrice(totalPrice);
      totalPrice = 0;
    }

    model.addAttribute("updateList", updateList);
  }
}
