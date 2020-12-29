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
@RequestMapping("/mypage")
@SessionAttributes("loginUser")
public class MypageController {

  @Autowired OrderService orderService;
  @Autowired UserService userService;
  @Autowired RecipeService recipeService;
  @Autowired FollowService followService;
  @Autowired QnaService qnaService;
  @Autowired ProductService productService;
  
  @GetMapping("index")
  public void index(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    
    List<Order> descOrderList = orderService.myDescList(user.getUserNo());
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
    
    int totalPrice2 = 0;
    for (Order order : descOrderList) {
      for (OrderList orderlist : order.getOrderLists()) {
        totalPrice2 += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
      }
      order.setTotalPrice(totalPrice2);
      totalPrice2 = 0;
    }
    
    model.addAttribute("descOrderList", descOrderList);
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

  //  @RequestMapping("/index")
  //  public ModelAndView list(HttpSession session) throws Exception {
  //    User loginUser = (User) session.getAttribute("loginUser");
  //    ModelAndView mv = new ModelAndView();
  //
  //
  //    List<Follow> followerList = followService.FollowerList(loginUser.getUserNo());
  //    List<Follow> followingList = followService.FollowingList(loginUser.getUserNo());
  //    List<Qna> qnaList = qnaService.list();
  //
  //    mv.addObject("followerList", followerList);
  //    mv.addObject("followingList", followingList);
  //    mv.addObject("qnaList", qnaList);
  //
  //    if (session.getAttribute("thisqna") != null) {
  //      Qna qna = (Qna) session.getAttribute("thisqna");
  //      mv.addObject(qna);
  //    }
  //
  //    mv.setViewName("/mypage/test.jsp");
  //    return mv;
  //  }
}
