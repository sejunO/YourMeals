package com.oijoa.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oijoa.domain.User;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/mypage/user")
public class MyUserController {
  @Autowired
  UserService userService;

  @GetMapping("detail")
  public void detail(HttpSession session, Model model) throws Exception {
    User user = userService.get(((User)session.getAttribute("loginUser")).getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    model.addAttribute("user", user);
  }

  @GetMapping("detailPassword")
  public void detailPassword(HttpSession session, Model model) throws Exception {
    User user = userService.get(((User)session.getAttribute("loginUser")).getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    } 
    model.addAttribute("user", user);
  }

  @PostMapping("update")
  public String update(User user) throws Exception {
    int count = userService.update(user);
    if(count == 0) {
      throw new Exception("정보 수정에 실패하였습니다.");
    }
    return "redirect:detail";
  }

  @PostMapping("updatePassword")
  public String updatePassword(User user) throws Exception {
    int count = userService.update(user);
    if(count == 0) {
      throw new Exception("비밀번호 변경이 실패하였습니다.");
    }
    return "redirect:detail";
  }
}
