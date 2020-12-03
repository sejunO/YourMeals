package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oijoa.service.RecipeService;

@WebServlet("/recipe/list")
public class RecipeDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		ServletContext ctx = request.getServletContext();
		RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Refresh' content='1;url=list'>");
		out.println("<title>레시피삭제</title></head>");
		out.println("<body>");

		try {
			out.println("<h1>레시피 삭제</h1>");

			int no = Integer.parseInt(request.getParameter("recipeNo"));

			if (recipeService.delete(no) == 0) {
				out.println("<p>해당 프로젝트가 없습니다.</p>");
			} else {
				out.println("<p>프로젝트를 삭제하였습니다.</p>");
			}

		} catch (Exception e) {
			out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
			e.printStackTrace();
		}

	}

}
