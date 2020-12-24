package com.oijoa.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.oijoa.domain.Follow;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("loginUser")
public class UserController {

  @Autowired UserService userService;
  @Autowired RecipeService recipeService;
  @Autowired FollowService followService;

  @GetMapping("form")
  public void form() {
  }

  @PostMapping("add")
  public String add(String name, String nick, String email, String password) throws Exception {

    User user = new User();
    user.setName(name);
    user.setNick(nick);
    user.setEmail(email);
    user.setPassword(password);

    userService.add(user);
    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(@ModelAttribute("loginUser") User loginUser) throws Exception {
    if (loginUser == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    if (userService.delete(loginUser.getUserNo()) == 0) {
      throw new Exception("회원 탈퇴를 실패하였습니다.");
    }
    return "redirect:.";
  }

  @GetMapping("list")
  public void list(String keyword, Model model) throws Exception {
    model.addAttribute("list", userService.list(keyword));
  }

  @GetMapping("recipeList")
  public void recipeList(int userNo, Model model) throws Exception {
    User user = userService.get(userNo);
    List<Recipe> recipeList = recipeService.userNoList(userNo);
    List<Follow> followerList = followService.FollowerList(userNo);
    List<Follow> followinglist = followService.FollowingList(userNo);

    model.addAttribute("user", user);
    model.addAttribute("recipeList", recipeList);

    int recipeSize = recipeList.size();
    int followerSize = followerList.size();
    int followingSize = followinglist.size();

    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);

  }

  @GetMapping("followerList")
  public void followerList(int userNo, Model model) throws Exception {
    User user = userService.get(userNo);
    List<Recipe> recipeList = recipeService.userNoList(userNo);
    List<Follow> followerList = followService.FollowerList(userNo);
    List<Follow> followinglist = followService.FollowingList(userNo);

    model.addAttribute("user", user);
    model.addAttribute("followerList", followerList);

    int recipeSize = recipeList.size();
    int followerSize = followerList.size();
    int followingSize = followinglist.size();

    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
  }

  @GetMapping("followingList")
  public void followingList(int userNo, Model model) throws Exception {
    User user = userService.get(userNo);
    List<Recipe> recipeList = recipeService.userNoList(userNo);
    List<Follow> followerList = followService.FollowerList(userNo);
    List<Follow> followinglist = followService.FollowingList(userNo);

    model.addAttribute("user", user);
    model.addAttribute("followinglist", followinglist);

    int recipeSize = recipeList.size();
    int followerSize = followerList.size();
    int followingSize = followinglist.size();

    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
  }

  @GetMapping("follow")
  public String follow(@ModelAttribute("loginUser") User loginUser, int userNo) throws Exception {
    Follow followUsers = null;

    followUsers.setFollower(loginUser.getUserNo());
    followUsers.setFollowing(userNo);

    followService.follow(followUsers);
    return "redirect:.";
  }

  @GetMapping("unfollow")
  public void unfollow(@ModelAttribute("loginUser") User loginUser, int userNo) throws Exception {
  }
}
