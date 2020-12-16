package com.oijoa.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oijoa.domain.Category;
import com.oijoa.domain.Material;
import com.oijoa.service.CategoryService;
import com.oijoa.service.MaterialService;

@WebServlet("/recipe/form")
public class RecipeAddFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext ctx = request.getServletContext();
		CategoryService categoryService = (CategoryService) ctx.getAttribute("categoryService");
		MaterialService materialService = (MaterialService) ctx.getAttribute("materialService");

		response.setContentType("text/html;charset=UTF-8");
		
		try {
			List<Category> categoryList = categoryService.list();
			List<Material> materialList = materialService.list();
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("materialList", materialList);
			request.getRequestDispatcher("/recipe/form.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
