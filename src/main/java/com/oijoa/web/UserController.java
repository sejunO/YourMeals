package com.oijoa.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired UserService userService;
  @Autowired RecipeService recipeService;
  @Autowired FollowService followService;

  @GetMapping("signup")
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
  public String delete(HttpSession session) throws Exception {
    User loginUser = userService.get(((User)session.getAttribute("loginUser")).getUserNo());

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

  @GetMapping("info")
  public void info(int userNo, Model model) throws Exception {
    User user = userService.get(userNo);

    model.addAttribute("userNick", user.getNick());
    model.addAttribute("recipeList", recipeService.userNoList(userNo));
    model.addAttribute("followerList", followService.FollowerList(userNo));
    model.addAttribute("followinglist", followService.FollowingList(userNo));
    model.addAttribute("/user/info.jsp");
  }
}
