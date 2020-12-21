package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Follow;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  RecipeService recipeService;
  @Autowired
  FollowService followService;

  @RequestMapping("form")
  public ModelAndView joinForm() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/user/form.jsp");
    return mv;
  }
  
  @RequestMapping("join")
  public String join(
      String name,
      String nick,
      String email,
      String password) throws Exception {

    User user = new User();
    user.setName(name);
    user.setNick(nick);
    user.setEmail(email);
    user.setPassword(password);

    userService.add(user);
    
    return "redirect:list";
  }
  
  @RequestMapping("list")
  public ModelAndView list() throws Exception {

    List<User> list = userService.list();

    ModelAndView mv = new ModelAndView();
    mv.addObject("list", list);
    mv.setViewName("/user/list.jsp");
    return mv;
  }

  @RequestMapping("info")
  public ModelAndView info(int userNo) throws Exception {

    User user = userService.get(userNo);

    List<Recipe> recipeList = recipeService.userNoList(userNo);
    List<Follow> followerList = followService.FollowerList(userNo);
    List<Follow> followinglist = followService.FollowingList(userNo);

    ModelAndView mv = new ModelAndView();

    mv.addObject("userNick", user.getNick());
    mv.addObject("recipeList", recipeList);
    mv.addObject("followerList", followerList);
    mv.addObject("followinglist", followinglist);
    mv.setViewName("/user/info.jsp");
    return mv;
  }
  
  @RequestMapping("delete")
  public String delete(HttpSession session) throws Exception {
    User user = userService.get(((User)session.getAttribute("loginUser")).getUserNo());

    if (user == null) {
      System.out.println("로그인 정보가 존재하지 않습니다.");
    } else {
      if (userService.delete(user.getUserNo()) == 0) {
        throw new Exception("회원 탈퇴를 실패하였습니다.");
      }
    }
    
    return "redirect:list";
  }
}
