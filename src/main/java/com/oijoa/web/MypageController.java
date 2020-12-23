package com.oijoa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mypage")
public class MypageController {

  @GetMapping("index")
  public void index() {
  }

  //  @RequestMapping("/index")
  //  public ModelAndView list(HttpSession session) throws Exception {
  //    User loginUser = (User) session.getAttribute("loginUser");
  //    ModelAndView mv = new ModelAndView();
  //
  //
  //    List<Follow> followerList = followService.FollowerList(loginUser.getUserNo());
  //    List<Follow> followingList = followService.FollowingList(loginUser.getUserNo());
  //    List<Qna> qnaList = qnaService.list();
  //
  //    mv.addObject("followerList", followerList);
  //    mv.addObject("followingList", followingList);
  //    mv.addObject("qnaList", qnaList);
  //
  //    if (session.getAttribute("thisqna") != null) {
  //      Qna qna = (Qna) session.getAttribute("thisqna");
  //      mv.addObject(qna);
  //    }
  //
  //    mv.setViewName("/mypage/test.jsp");
  //    return mv;
  //  }
}
