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
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/mypage/order")
@SessionAttributes("loginUser")
public class MyOrderController {

  @Autowired OrderService orderService;
  @Autowired UserService userService;

  @GetMapping("orderList")
  public void orderList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    List<Order> orderList = orderService.myOrderList(user.getUserNo());
    int totalPrice = 0;
    for (Order order : orderList) {
      for (OrderList orderlist : order.getOrderLists()) {
        totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
      }
      order.setTotalPrice(totalPrice);
      totalPrice = 0;
    }

    model.addAttribute("orderList", orderList);
    model.addAttribute("user", user);
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
