package com.oijoa.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.User;

//@WebListener
public class AutoLoginListener implements ServletRequestListener {


  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    try {
      HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();

      if (session.getAttribute("loginUser") == null) {
        User loginUser = new User();
        loginUser.setUserNo(1);
        loginUser.setEmail("sj@test.com");
        loginUser.setName("sejun0854");
        loginUser.setUserTypeNo(5);
        session.setAttribute("loginUser", loginUser);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
