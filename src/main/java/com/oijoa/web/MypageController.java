package com.oijoa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.oijoa.domain.User;
import com.oijoa.service.UserService;


@Controller
@RequestMapping("/mypage")
@SessionAttributes("loginUser")
public class MypageController {

  @Autowired UserService userService;

  @GetMapping("index")
  public void index(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    model.addAttribute("user", user);
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
