package com.oijoa.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.User;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/mypage/user")
public class MyUserController {
  @Autowired
  UserService userService;

  @RequestMapping("detail")
  public ModelAndView detail(HttpSession session) throws Exception {
    ModelAndView mv = new ModelAndView();
    User user = userService.get(((User)session.getAttribute("loginUser")).getUserNo());

    if (user == null) {
      System.out.println("로그인 정보가 존재하지 않습니다.");
    } else {
      mv.addObject("user", user);
      mv.setViewName("/mypage/user/detail.jsp");
    }
    return mv;
  }

  @RequestMapping("detailPassword")
  public ModelAndView detailPassword(HttpSession session) throws Exception {
    ModelAndView mv = new ModelAndView();
    User user = userService.get(((User)session.getAttribute("loginUser")).getUserNo());

    if (user == null) {
      System.out.println("로그인 정보가 존재하지 않습니다.");
    } else {
      mv.addObject("user", user);
      mv.setViewName("/mypage/user/detailPassword.jsp");
    }
    return mv;
  }

  @RequestMapping("update")
  public String update(User user) throws Exception {
    int count = userService.update(user);
    if(count == 0) {
      throw new Exception("정보 수정에 실패하였습니다.");
    }
    return "redirect:detail";
  }

  @RequestMapping("updatePassword")
  public String updatePassword(User user) throws Exception {
    int count = userService.update(user);
    if(count == 0) {
      throw new Exception("비밀번호 변경이 실패하였습니다.");
    }
    return "redirect:detail";
  }
}
