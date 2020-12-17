package com.oijoa.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oijoa.domain.Category;
import com.oijoa.domain.Material;
import com.oijoa.service.CategoryService;
import com.oijoa.service.MaterialService;

@Controller
public class RecipeAddFormController {

	CategoryService categoryService;
	MaterialService materialService;
	
	public RecipeAddFormController(
			CategoryService categoryService,
			MaterialService materialService) {
		this.categoryService = categoryService;
		this.materialService = materialService;
	}

	@RequestMapping("/recipe/form")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		
			List<Category> categoryList = categoryService.list();
			List<Material> materialList = materialService.list();
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("materialList", materialList);
			request.getRequestDispatcher("/recipe/form.jsp").forward(request, response);
			return "/recipe/form.jsp";
		
	}

}
