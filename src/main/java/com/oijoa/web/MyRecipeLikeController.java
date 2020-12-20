package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.RecipeService;

@Controller
@RequestMapping("/mypage/recipe")
public class MyRecipeLikeController {

  @Autowired
  RecipeService recipeService;
  
  @RequestMapping("likeList")
  public ModelAndView list(HttpSession session) throws Exception {
    ModelAndView mv = new ModelAndView();
    
    User loginUser = (User) session.getAttribute("loginUser");
    List<Recipe> likeList = recipeService.myLikeList(loginUser.getUserNo());
    
    mv.addObject("likeList", likeList);
    mv.setViewName("/mypage/recipe/likeList.jsp");
    
    return mv;
  }
}