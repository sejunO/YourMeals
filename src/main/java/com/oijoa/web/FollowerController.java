package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Follow;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;


@Controller
@RequestMapping("/mypage")
public class FollowerController {
  @Autowired
  FollowService followService;


  @RequestMapping("/follower/list")
  public ModelAndView followerList(HttpSession session) throws Exception {

    User loginUser = (User) session.getAttribute("loginUser");
    ModelAndView mv = new ModelAndView();
    List<Follow> list = followService.FollowerList(loginUser.getUserNo());
    mv.addObject("list", list);
    mv.setViewName("/mypage/follow/follower/list.jsp");
    return mv;
  }

  @RequestMapping("/following/list")
  public ModelAndView followingList(HttpSession session) throws Exception {

    User loginUser = (User) session.getAttribute("loginUser");
    List<Follow> list = followService.FollowingList(loginUser.getUserNo());
    ModelAndView mv = new ModelAndView();
    mv.addObject("list", list);
    mv.setViewName("/mypage/follow/following/list.jsp");
    return mv;

  }
}
