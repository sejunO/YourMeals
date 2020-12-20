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
public class MyOrderUpdateListController {

  @Autowired
  OrderService orderService;
  
  @RequestMapping("updateList")
  public ModelAndView list(HttpSession session) throws Exception {
    ModelAndView mv = new ModelAndView();
    
    User loginUser = (User) session.getAttribute("loginUser");
    List<Order> updateList = orderService.myUpdateList(loginUser.getUserNo());
  
      int totalPrice = 0;
      for (Order order : updateList) {
        for (OrderList orderList : order.getOrderLists()) {
          totalPrice += (orderList.getPrice() - orderList.getDiscount()) * orderList.getAmount();
        }
        order.setTotalPrice(totalPrice);
        totalPrice = 0;
      }
      
      mv.addObject("updateList", updateList);
      mv.setViewName("/mypage/order/updateList.jsp");
      
      return mv;
  }
}
