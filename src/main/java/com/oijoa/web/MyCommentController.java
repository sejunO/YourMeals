package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Comment;
import com.oijoa.domain.User;
import com.oijoa.service.CommentService;

@Controller
@RequestMapping("/mypage/comment")
 
public class MyCommentController {
  @Autowired
  CommentService commentService;
  
  @RequestMapping("list")
  public ModelAndView list(HttpSession session) throws Exception {
    ModelAndView mv = new ModelAndView();
    User loginUser = (User) session.getAttribute("loginUser");
    List<Comment> commentList = commentService.userNoList(loginUser.getUserNo());
    
    mv.addObject("commentList", commentList);
    mv.setViewName("/mypage/comment/list.jsp");
    
    return mv;
  }
}
