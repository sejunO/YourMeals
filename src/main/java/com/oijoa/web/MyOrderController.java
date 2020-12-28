package com.oijoa.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.oijoa.domain.Follow;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.domain.Product;
import com.oijoa.domain.Qna;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.OrderService;
import com.oijoa.service.ProductService;
import com.oijoa.service.QnaService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/mypage/order")
@SessionAttributes("loginUser")
public class MyOrderController {

  @Autowired OrderService orderService;
  @Autowired UserService userService;
  @Autowired RecipeService recipeService;
  @Autowired FollowService followService;
  @Autowired QnaService qnaService;
  @Autowired ProductService productService;
  
  @GetMapping("orderList")
  public void orderList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    List<Order> orderList = orderService.myOrderList(user.getUserNo());
    List<Recipe> recipeList = recipeService.userNoList(user.getUserNo());
    List<Follow> followList = followService.FollowerList(user.getUserNo());
    List<Order> shippingList = orderService.myOrderShippingList(user.getUserNo());
    List<Qna> qnaList = qnaService.userNoList(user.getUserNo());
    List<Product> productList = productService.list();
    
    int totalPrice = 0;
    for (Order order : orderList) {
      for (OrderList orderlist : order.getOrderLists()) {
        totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
      }
      order.setTotalPrice(totalPrice);
      totalPrice = 0;
    }
    
    model.addAttribute("orderList", orderList);
    
    int recipeSize = recipeList.size();
    int followerSize = followList.size();
    int qnaSize = qnaList.size();
    int shippingSize = shippingList.size();
    
    model.addAttribute("productList", productList);
    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("qnaSize", qnaSize);
    model.addAttribute("shippingSize", shippingSize);
    model.addAttribute("user", user);
  }

  @GetMapping("updateList")
  public void updateList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    List<Order> updateList = orderService.myUpdateList(loginUser.getUserNo());
    List<Recipe> recipeList = recipeService.userNoList(user.getUserNo());
    List<Follow> followList = followService.FollowerList(user.getUserNo());
    List<Order> shippingList = orderService.myOrderShippingList(user.getUserNo());
    List<Qna> qnaList = qnaService.userNoList(user.getUserNo());
    List<Product> productList = productService.list();
    
    int totalPrice = 0;
    for (Order order : updateList) {
      for (OrderList orderlist : order.getOrderLists()) {
        totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
      }
      order.setTotalPrice(totalPrice);
      totalPrice = 0;
    }
    
    model.addAttribute("updateList", updateList);

    int recipeSize = recipeList.size();
    int followerSize = followList.size();
    int qnaSize = qnaList.size();
    int shippingSize = shippingList.size();
    
    model.addAttribute("productList", productList);
    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("qnaSize", qnaSize);
    model.addAttribute("shippingSize", shippingSize);
    model.addAttribute("user", user);
  }
}
