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
  protected void doPost(HttpServletRequest request, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");
    CategoryService categoryService = (CategoryService) ctx.getAttribute("categoryService");

    //사진
    Part photoPart = request.getPart("photo");
    String filename = UUID.randomUUID().toString();
    String saveFilePath = ctx.getRealPath("/upload/" + filename);
    photoPart.write(saveFilePath);

    generatePhotoThumbnail(saveFilePath);

    //카테고리
    Category category = null;
    try {
      category = categoryService.get(Integer.parseInt(request.getParameter("category")));
    } catch (Exception e) {
      System.out.println("카테고리 값 받아올 때 오류");
    }
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head><title>Recipe Test</title></head>");

      out.println("[게시물 추가]");

      Recipe recipe = new Recipe();
      recipe.setTitle(request.getParameter("title"));
      recipe.setContent(request.getParameter("content"));
      User user = new User();
      user.setUserNo(1);
      recipe.setWriter(user);
      recipe.setLevelNo(Integer.parseInt(request.getParameter("level")));
      recipe.setMin(Integer.parseInt(request.getParameter("min")));
      recipe.setCategory(category);
      recipe.setPhoto(filename);

      recipeService.add(recipe);

      out.println("</table></body></html>");

      out.println("</table></body></html>");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
      e.printStackTrace();
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
