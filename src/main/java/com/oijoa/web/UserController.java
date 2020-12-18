package com.oijoa.web;

import java.util.List;
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


}
