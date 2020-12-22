package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.OrderService;

@Controller
@RequestMapping("/mypage/order")

public class MyOrderController {

  @Autowired OrderService orderService;

  @GetMapping("orderList")
  public void orderList(HttpSession session, Model model) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");

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
  public void updateList(HttpSession session, Model model) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");

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
