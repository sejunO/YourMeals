package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Qna;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.CommentService;
import com.oijoa.service.QnaService;
import com.oijoa.service.RecipeService;

@Controller
@RequestMapping("/mypage")
public class MyBoardController {
  @Autowired RecipeService recipeService;
  @Autowired CommentService commentService;
  @Autowired QnaService qnaService;

  @GetMapping("/recipe/likeList")
  public void recipeLikeList(HttpSession session, Model model) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    List<Recipe> likeList = recipeService.myLikeList(loginUser.getUserNo());
    model.addAttribute("likeList", likeList);
  }

  @GetMapping("/recipe/list")
  public void recipeList(HttpSession session, Model model) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    List<Recipe> recipeList = recipeService.userNoList(loginUser.getUserNo());
    model.addAttribute("recipeList", recipeList);
  }

  @GetMapping("/recipe/commentList")
  public void commentList(HttpSession session, Model model) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    List<Comment> commentList = commentService.userNoList(loginUser.getUserNo());
    model.addAttribute("commentList", commentList);
  }

  @RequestMapping("/qna/add")
  public String add(HttpSession session, Qna qna) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    qna.setWriter(loginUser);

    qnaService.add(qna);
    return "redirect:list";
  }

  @RequestMapping("/qna/delete")
  public String delete(int no) throws Exception {
    Qna qna = qnaService.get(no);
    if (qnaService.delete(no) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

  @RequestMapping("/qna/detail")
  public String detail(int no, HttpSession session) throws Exception {
    Qna qna = qnaService.get(no);
    if (qna == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    // ModelAndView mv = new ModelAndView();
    // mv.addObject("qna", qna);
    // mv.setViewName("/mypage/qna/detail.jsp");
    // return mv;
    session.setAttribute("thisqna", qna);
    return "redirect:../index";
  }

  @RequestMapping("/qna/update")
  public String update(Qna qna) throws Exception {
    int count = qnaService.update(qna);
    if (count == 0) {
      throw new Exception("해당번호의 게시글이 없습니다.");
    }
    return "redirect:../list";
  }

  @RequestMapping("/qna/list")
  public ModelAndView list(HttpSession session) throws Exception {

    List<Qna> list = qnaService.list();

    ModelAndView mv = new ModelAndView();
    mv.addObject("list", list);
    mv.setViewName("/mypage/qna/list.jsp");
    return mv;
  }
}
