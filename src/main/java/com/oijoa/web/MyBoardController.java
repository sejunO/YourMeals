package com.oijoa.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Follow;
import com.oijoa.domain.Qna;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.CommentService;
import com.oijoa.service.FollowService;
import com.oijoa.service.QnaService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/mypage")
@SessionAttributes("loginUser")
public class MyBoardController {
  @Autowired RecipeService recipeService;
  @Autowired CommentService commentService;
  @Autowired QnaService qnaService;
  @Autowired UserService userService;
  @Autowired FollowService followService;

  @GetMapping("/recipe/likeList")
  public void recipeLikeList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    List<Recipe> recipeList = recipeService.userNoList(loginUser.getUserNo());
    List<Follow> followList = followService.FollowerList(user.getUserNo());
    List<Follow> followingList = followService.FollowingList(user.getUserNo());

    model.addAttribute("likeList", recipeService.myLikeList(loginUser.getUserNo()));
    
    int recipeSize = recipeList.size();
    int followerSize = followList.size();
    int followingSize =  followingList.size();
    
    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
    model.addAttribute("user", user);
  }

  @GetMapping("/recipe/list")
  public void recipeList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    List<Recipe> recipeList = recipeService.userNoList(loginUser.getUserNo());
    List<Follow> followList = followService.FollowerList(user.getUserNo());
    List<Follow> followingList = followService.FollowingList(user.getUserNo());

    model.addAttribute("recipeList", recipeList);
    
    int recipeSize = recipeList.size();
    int followerSize = followList.size();
    int followingSize =  followingList.size();
    
    
    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
    model.addAttribute("user", user);
  }

  @GetMapping("/recipe/commentList")
  public void recipeCommentList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    List<Recipe> recipeList = recipeService.userNoList(loginUser.getUserNo());
    List<Follow> followList = followService.FollowerList(user.getUserNo());
    List<Follow> followingList = followService.FollowingList(user.getUserNo());

    model.addAttribute("commentList", commentService.userNoList(loginUser.getUserNo()));
    
    int recipeSize = recipeList.size();
    int followerSize = followList.size();
    int followingSize =  followingList.size();
    
    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
    model.addAttribute("user", user);
  }

  @GetMapping("/qna/list")
  public void qnaList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    List<Recipe> recipeList = recipeService.userNoList(loginUser.getUserNo());
    List<Follow> followList = followService.FollowerList(user.getUserNo());
    List<Follow> followingList = followService.FollowingList(user.getUserNo());
    
    model.addAttribute("qnaList", qnaService.list());
    
    int recipeSize = recipeList.size();
    int followerSize = followList.size();
    int followingSize =  followingList.size();
    
    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
    model.addAttribute("user", user);
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
