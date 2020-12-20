package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.User;
import com.oijoa.service.OrderService;

@Controller
@RequestMapping("/mypage/order")

public class MyBuyListController {

  @Autowired
  OrderService orderService;
  
  @RequestMapping("buyList")
  public ModelAndView list(HttpSession session) throws Exception {
    ModelAndView mv = new ModelAndView();
    
    User loginUser = (User) session.getAttribute("loginUser");
    List<Order> buyList = orderService.myBuyList(loginUser.getUserNo());
      
      int totalPrice = 0;
      for (Order order : buyList) {
        for (OrderList orderlist : order.getOrderLists()) {
          totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
        }
        order.setTotalPrice(totalPrice);
        totalPrice = 0;
      }
      
      mv.addObject("buyList", buyList);
      mv.setViewName("/mypage/order/buyList.jsp");
      
      return mv;
  }
}
