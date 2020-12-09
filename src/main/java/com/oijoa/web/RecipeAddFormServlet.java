package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oijoa.domain.Category;
import com.oijoa.domain.Material;
import com.oijoa.domain.Recipe;
import com.oijoa.service.CategoryService;
import com.oijoa.service.MaterialService;


@WebServlet("/recipe/form")
public class RecipeAddFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    CategoryService categoryService =
        (CategoryService) ctx.getAttribute("categoryService");
    MaterialService materialService =
            (MaterialService) ctx.getAttribute("materialService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>레시피 등록</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>레시피 등록</h1>");
      out.println("<form action='add' method='post'enctype='multipart/form-data'>");
      out.println("사진: <input type='file' name='recipe_photo'><br>");
      out.println("제목: <input type='text' name='title'><br>");
      out.println("내용: <textarea name='recipe_content' rows='10' cols='60'></textarea><br>");
      //out.printf("작성자: <input type='text' name='writer' value=%s readonly><br>",loginUser);
      out.println("<h3>난이도</h3>");
      out.println("<input type='radio' name='level' value='1'>☆");
      out.println("<input type='radio' name='level' value='2'>☆☆");
      out.println("<input type='radio' name='level' value='3'>☆☆☆<br>");
      out.println("<h3>만드는 시간</h3>  <input type='number' name='min'<br>");

      out.println("<br><h3>카테고리 </h3><br>");
      out.println("<ul>");
      List<Category> list = categoryService.list();
      for (Category c : list) {
        out.printf("<li><input type='radio' name='category' value='%d'>%s</li><br>", c.getCategoryNo(),c.getCategoryName());
      }
      
      out.println("<br><h3>필요한 재료</h3><br>");
      List<Material> materialList = materialService.list();
      for (Material m : materialList) {
        out.printf("<li><input type='radio' name='materialList' value='%d'>%s</li><br>", m.getName());
      }
      
      out.println("</ul><br>");
      out.println("<h3>조리순서</h3>");
      out.println("사진: <input type='file' name='step_photo'><br>");
      out.println("내용: <textarea name='step_content' rows='10' cols='30'></textarea><br>");
      out.println("<p><button>등록</button></p>");
      out.println("</form>");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

    out.println("</body>");
    out.println("</html>");
  }
}
