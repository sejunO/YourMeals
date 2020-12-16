package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Basket;
import com.oijoa.domain.DeliveryCompany;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.BasketService;
import com.oijoa.service.DeliveryCompanyService;
import com.oijoa.service.OrderListService;
import com.oijoa.service.OrderService;

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
  public ModelAndView success(HttpSession session, HttpServletResponse response) throws Exception {

    response.setContentType("text/html;charset=UTF-8");
    User user = (User) session.getAttribute("loginUser");
    Order order = orderService.lately(user.getUserNo());
    ModelAndView mv = new ModelAndView();
    mv.addObject("order", order);
    mv.addObject("orderList", orderListService.getByOrderNo(order.getOrderNo()));
    mv.setViewName("/order/success.jsp");
    return mv;
  }
}
