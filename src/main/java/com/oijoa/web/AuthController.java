package com.oijoa.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/auth")
public class AuthController {

  @Autowired UserService userService;

  @GetMapping("login")
  public void loginForm() throws Exception {
  }

  @PostMapping("login")
  public String login(
      String email,
      String password,
      String saveEmail,
      HttpServletResponse response,
      HttpSession session) throws Exception {

    Cookie emailCookie = new Cookie("email", email);

    if (saveEmail != null) {
      emailCookie.setMaxAge(60 * 60 * 24 * 7);
    } else {
      emailCookie.setMaxAge(0); // 유효기간이 0이면 삭제하라는 의미다.
    }
    response.addCookie(emailCookie);

    User user = userService.get(email, password);
    if (user == null) {
      return "redirect:loginError";
    }
    session.setAttribute("loginUser", user);
    return "redirect:../../app/index";
  }

  @GetMapping("loginError")
  public void loginError() throws Exception {
  }

  @GetMapping("logout")
  public void logout(HttpSession session, Model model) throws Exception {

    User loginUser = (User) session.getAttribute("loginUser");
    if (loginUser != null) {
      session.invalidate();
    }
    model.addAttribute("loginUser", loginUser);
  }
}
