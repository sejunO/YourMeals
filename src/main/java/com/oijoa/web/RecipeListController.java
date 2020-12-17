package com.oijoa.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oijoa.domain.Recipe;
import com.oijoa.service.RecipeService;


@Controller
public class RecipeListController {

	RecipeService recipeService;
	
	public RecipeListController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

  @RequestMapping("/recipe/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    response.setContentType("text/html;charset=UTF-8");
      List<Recipe> list = null;
      String keyword = request.getParameter("keyword");
      String keywordTitle = request.getParameter("keywordTitle");
      String keywordWriter = request.getParameter("keywordWriter");
      String keywordCategory = request.getParameter("keywordCategory");;

      if (keyword != null) {

        list = recipeService.list(keyword);

      } else if (keywordTitle != null) {
        HashMap<String, Object> keywordMap = new HashMap<>();
        keywordMap.put("title", keywordTitle);
        keywordMap.put("writer", keywordWriter);
        keywordMap.put("category", keywordCategory);

        list = recipeService.list(keywordMap);

      } else {
        list = recipeService.list();
      }

      request.setAttribute("list", list);
      return "/recipe/list.jsp";
 

  }


}


