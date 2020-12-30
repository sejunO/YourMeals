package com.oijoa.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.oijoa.domain.Recipe;
import com.oijoa.service.CategoryService;
import com.oijoa.service.RecipeService;

@Controller
public class IndexControllor {
  @Autowired
  RecipeService recipeService;
  @Autowired
  CategoryService categoryService;

  @GetMapping("index")
  public void index(Model model) throws Exception {
    List<Recipe> list = recipeService.hitsList();

    // List<Recipe> hits = new ArrayList<>();
    // for (int i = 0; i < 1; i++) {
    // hits.add(list.get(i));
    // }

    model.addAttribute("recipeList", recipeService.list());
    model.addAttribute("categoryList", categoryService.list());
    //    model.addAttribute("recipe", recipeService.list().get(1));
    // model.addAttribute("hits", hits);
  }
}
