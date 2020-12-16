package com.oijoa.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.User;
import com.oijoa.service.UserService;

@WebListener
public class AutoLoginListener implements ServletRequestListener {
  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    try {
      HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();

      if (session.getAttribute("loginUser") == null) {
        UserService memberService =
            (UserService) session.getServletContext().getAttribute("userService");
        User loginUser = memberService.get("sj@test.com", "1111");
        session.setAttribute("loginUser", loginUser);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
