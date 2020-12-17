package com.oijoa.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oijoa.domain.Category;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Level;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.RecipeStep;
import com.oijoa.service.CategoryService;
import com.oijoa.service.CommentService;
import com.oijoa.service.LevelService;
import com.oijoa.service.MaterialService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.RecipeStepService;

@Controller
public class RecipeDetailController {

	RecipeService recipeService;
	CategoryService categoryService;
	MaterialService materialService;
	RecipeStepService recipeStepService;
	CommentService commentService;
	LevelService levelService;

	public RecipeDetailController(RecipeService recipeService, CategoryService categoryService,
			MaterialService materialService, RecipeStepService recipeStepService, CommentService commentService,
			LevelService levelService) {
		this.recipeService = recipeService;
		this.categoryService = categoryService;
		this.materialService = materialService;
		this.recipeStepService = recipeStepService;
		this.commentService = commentService;
		this.levelService = levelService;
	}

	@RequestMapping("/recipe/detail")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		int no = Integer.parseInt(request.getParameter("recipeNo"));

		Recipe recipe = recipeService.get(no);
		if (recipe == null) {
			System.out.println("레시피가 존재하지 않습니다.");
		}
		List<Category> categorys = categoryService.list();
		List<Level> levels = levelService.list();
		List<RecipeStep> recipeSteps = recipeStepService.list(no);
		List<Comment> comments = commentService.list(no);

		request.setAttribute("recipe", recipe);
		request.setAttribute("categorys", categorys);
		request.setAttribute("levels", levels);
		request.setAttribute("recipeSteps", recipeSteps);
		request.setAttribute("comments", comments);
		return "/recipe/detail.jsp";

	}

}
