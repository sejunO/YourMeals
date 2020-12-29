package com.oijoa.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.oijoa.domain.Recipe;
import com.oijoa.service.RecipeService;

@Controller
public class IndexControllor {
  @Autowired
  RecipeService recipeService;

  @GetMapping("index")
  public void index(Model model) throws Exception {
    model.addAttribute("recipeList", recipeService.list());
    List<Recipe> hits = recipeService.hitsList();
    model.addAttribute("first", hits.get(0));
  }
}
