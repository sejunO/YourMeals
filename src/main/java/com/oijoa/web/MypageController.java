package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Follow;
import com.oijoa.domain.Qna;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.QnaService;


@Controller
@RequestMapping("/mypage")
public class MypageController {
  @Autowired
  FollowService followService;
  @Autowired
  QnaService qnaService;


  @RequestMapping("/index")
  public ModelAndView list(HttpSession session) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    ModelAndView mv = new ModelAndView();


    List<Follow> followerList = followService.FollowerList(loginUser.getUserNo());
    List<Follow> followingList = followService.FollowingList(loginUser.getUserNo());
    List<Qna> qnaList = qnaService.list();

    mv.addObject("followerList", followerList);
    mv.addObject("followingList", followingList);
    mv.addObject("qnaList", qnaList);

    if (session.getAttribute("thisqna") != null) {
      Qna qna = (Qna) session.getAttribute("thisqna");
      mv.addObject(qna);
    }

    mv.setViewName("/mypage/test.jsp");
    return mv;
  }



}
