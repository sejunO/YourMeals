package com.oijoa.web.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  UserService userService;

  @GetMapping("index")
  public void index(Model model) throws Exception {
    model.addAttribute("userList", userService.list());
  }

  @GetMapping("detail")
  public String list(int no, HttpSession session) throws Exception {
    session.setAttribute("thisUser", userService.get(no));
    return "redirect:index";
  }

}
