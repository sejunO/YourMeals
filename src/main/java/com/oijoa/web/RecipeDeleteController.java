package com.oijoa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oijoa.service.RecipeService;

@Controller
public class RecipeDeleteController {

	RecipeService recipeService;

	public RecipeDeleteController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

  @RequestMapping("/recipe/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	  response.setContentType("text/html;charset=UTF-8");
      int no = Integer.parseInt(request.getParameter("recipeNo"));
      recipeService.deleteByNo(no); 
      return "rediret:list";

  }

}
