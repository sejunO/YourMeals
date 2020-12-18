package com.oijoa.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oijoa.domain.Qna;
import com.oijoa.domain.User;
import com.oijoa.service.QnaService;

@Controller
@RequestMapping("/mypage/qna")
public class QnaController {

  @Autowired
  QnaService qnaService;

  @RequestMapping("add")
  public String add(HttpSession session, Qna qna) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    qna.setWriter(loginUser);

    qnaService.add(qna);
    return "redirect:list";
  }

  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    Qna qna = qnaService.get(no);
    if (qnaService.delete(no) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

  @RequestMapping("detail")
  public ModelAndView detail(int no) throws Exception {
    Qna qna = qnaService.get(no);
    if(qna == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    ModelAndView mv = new ModelAndView();
    mv.addObject("qna", qna);
    mv.setViewName("/mypage/qna/detail.jsp");
    return mv;
  }

  @RequestMapping("update")
  public String update(Qna qna) throws Exception {
    int count = qnaService.update(qna);
    if(count == 0) {
      throw new Exception("해당번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

  @RequestMapping("list")
  public ModelAndView list(HttpSession session) throws Exception {

    List<Qna> list = qnaService.list();

    ModelAndView mv = new ModelAndView();
    mv.addObject("list", list);
    mv.setViewName("/mypage/qna/list.jsp");
    return mv;
  }
}