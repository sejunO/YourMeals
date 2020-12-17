package com.oijoa.web;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oijoa.domain.Category;
import com.oijoa.domain.Recipe;
import com.oijoa.service.RecipeService;

@Controller
public class RecipeUpdateController {

	RecipeService recipeService;

	public RecipeUpdateController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
  
  @RequestMapping("/recipe/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)   throws Exception {

    response.setContentType("text/html;charset=UTF-8");

      int no = Integer.parseInt(request.getParameter("recipeNo"));
      Recipe recipe = recipeService.get(no);
      recipe.setRecipeNo(Integer.parseInt(request.getParameter("recipeNo")));
      recipe.setTitle(request.getParameter("title"));
      recipe.setContent(request.getParameter("recipe_content"));
      recipe.setLevelNo(Integer.parseInt(request.getParameter("level")));
      recipe.setModifiedDate(Date.valueOf(LocalDate.now()));
      
      // 카테고리 객체에 번호(categoryNo)만 저장, 이름(categoryName)은 따로 저장 안 함
      Category category = new Category();
      category.setCategoryNo(Integer.parseInt(request.getParameter("category")));
      recipe.setCategory(category);   

      if(recipeService.update(recipe) == 0) {
    	  throw new Exception ("레시피가 존재하지 않습니다.");
      }
       recipeService.updateCategory(recipe);
       return "redirect:list";

  }

}




