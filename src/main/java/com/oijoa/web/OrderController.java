package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Basket;
import com.oijoa.domain.DeliveryCompany;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.Payment;
import com.oijoa.domain.User;
import com.oijoa.service.BasketService;
import com.oijoa.service.DeliveryCompanyService;
import com.oijoa.service.OrderListService;
import com.oijoa.service.OrderService;
import com.oijoa.service.PaymentService;

@Controller
@RequestMapping("/order")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  DeliveryCompanyService deliveryCompanyService;
  @Autowired
  OrderListService orderListService;
  @Autowired
  BasketService basketService;
  @Autowired
  PaymentService paymentService;

  @RequestMapping("add")
  public String add(HttpSession session, Order order) throws Exception {

    User user = (User) session.getAttribute("loginUser");
    DeliveryCompany dc = deliveryCompanyService.get(1);
    List<Basket> baskets = basketService.myList(user.getUserNo());

    order.setUserNo(user);
    order.setDeliveryCompanyNo(dc.getDeliveryNo());

    List<OrderList> orderLists = orderListService.makeList(user.getUserNo());
    orderService.add(order);
    Order latelyOrder = orderService.lately(user.getUserNo());
    for (OrderList ol : orderLists) {
      ol.setOrderNo(latelyOrder);
      orderService.add(ol);
    }
    for (Basket b : baskets) {
      basketService.delete(b.getBasketNo());
    }
    return "redirect:success";
  }


  @RequestMapping("success")
  public void success(HttpSession session, Model model) throws Exception {

    User user = (User) session.getAttribute("loginUser");
    Order order = orderService.lately(user.getUserNo());
    List<OrderList> orderList = orderListService.getByOrderNo(order.getOrderNo());
    int totalPrice = 0;
    for (int i = 0; i < orderList.size(); i++) {
      totalPrice += orderList.get(i).getPrice() * orderList.get(i).getAmount();
    }
    order.setTotalPrice(totalPrice);
    model.addAttribute("order", order);
    model.addAttribute("orderList", orderList);
  }

  @RequestMapping("form")
  public void form(HttpSession session, Model model) throws Exception {

    User user = (User) session.getAttribute("loginUser");
    List<Basket> baskets = basketService.myList(user.getUserNo());
    List<Payment> payments = paymentService.list(null);

    ModelAndView mv = new ModelAndView();
    model.addAttribute("baskets", baskets);
    model.addAttribute("payments", payments);
    model.addAttribute("user", user);

  }

  @RequestMapping("list")
  public void list(HttpSession session, Model model) throws Exception {

    User loginUser = (User) session.getAttribute("loginUser");
    List<OrderList> list = orderListService.myList(loginUser.getUserNo());
    model.addAttribute("list", list);
  }
}
