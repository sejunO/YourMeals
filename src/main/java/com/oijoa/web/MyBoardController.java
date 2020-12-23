package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Qna;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.CommentService;
import com.oijoa.service.QnaService;
import com.oijoa.service.RecipeService;

@Controller
@RequestMapping("/mypage")
@SessionAttributes("loginUser")
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
  public void recipeCommentList(HttpSession session, Model model) throws Exception {
    User loginUser = (User) session.getAttribute("loginUser");
    List<Comment> commentList = commentService.userNoList(loginUser.getUserNo());
    model.addAttribute("commentList", commentList);
  }

  @GetMapping("/qna/list")
  public void qnaList(Model model) throws Exception {
    model.addAttribute("qnaList", qnaService.list());
  }

  @GetMapping("/qna/form")
  public void qnaform() {
  }

  @PostMapping("/qna/add")
  public String qnaAdd(Qna qna, @ModelAttribute("loginUser") User loginUser) throws Exception {
    qna.setWriter(loginUser);
    qnaService.add(qna);
    return "redirect:list";
  }

  @GetMapping("/qna/delete")
  public String qnaDelete(int qnaNo) throws Exception {
    if (qnaService.delete(qnaNo) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }

  @GetMapping("/qna/detail")
  public void qnaDetail(int qnaNo, Model model) throws Exception {
    Qna qna = qnaService.get(qnaNo);
    if (qna == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    model.addAttribute("qna", qna);
  }

  @PostMapping("/qna/update")
  public String qnaUpdate(Qna qna) throws Exception {
    int count = qnaService.update(qna);
    if (count == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }
}
