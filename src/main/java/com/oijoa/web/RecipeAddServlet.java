package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.oijoa.domain.Category;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.CategoryService;
import com.oijoa.service.RecipeService;

import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/recipe/add")
public class RecipeAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");
    CategoryService categoryService = (CategoryService) ctx.getAttribute("categoryService");
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("loginUser");

    //사진
    Part photoPart = request.getPart("recipe_photo");
    String filename = UUID.randomUUID().toString();
    String saveFilePath = ctx.getRealPath("/upload/" + filename);
    photoPart.write(saveFilePath);

    generatePhotoThumbnail(saveFilePath);

    //카테고리
    Category category = null;
    try {
      category = categoryService.get(Integer.parseInt(request.getParameter("category")));
    } catch (Exception e) {
      out.println("카테고리 값 받아올 때 오류");
    }
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("<title>Recipe Test</title></head>");

      out.println("<h1>레시피 생성<h1>");

      Recipe recipe = new Recipe();
      recipe.setTitle(request.getParameter("title"));
      recipe.setContent(request.getParameter("recipe_content"));
      recipe.setWriter(user);
      recipe.setLevelNo(Integer.parseInt(request.getParameter("level")));
      recipe.setMin(Integer.parseInt(request.getParameter("min")));
      recipe.setCategory(category);
      recipe.setPhoto(filename);
      
      //  재료 추가 코드 필요

      recipeService.add(recipe);
      
      out.println("<p>레시피가 등록되었습니다.</p>");
      out.println("</table></body></html>");
      
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }

  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath)
      .size(30, 30)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(saveFilePath)
      .size(120, 120)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_120x120";
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
