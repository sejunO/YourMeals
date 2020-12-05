package com.oijoa.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class AppInitListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("밥상을 차리자! 신)오이조아용");

  }
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("밥상 엎어버림");
  }
}
