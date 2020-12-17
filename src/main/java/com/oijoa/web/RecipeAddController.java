package com.oijoa.web;

import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
public class RecipeAddController {

	RecipeService recipeService;
	CategoryService categoryService;
	
	public RecipeAddController(RecipeService recipeService,
			CategoryService categoryService) {
		this.recipeService = recipeService;
		this.categoryService = categoryService;
	}

  @RequestMapping("/recipe/add")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    response.setContentType("text/html;charset=UTF-8");
  
    User user = (User) request.getSession().getAttribute("loginUser");

    //사진
    Part photoPart = request.getPart("recipe_photo");
    String filename = UUID.randomUUID().toString();
    String saveFilePath = request.getServletContext().getRealPath("/upload/" + filename);
    photoPart.write(saveFilePath);
    generatePhotoThumbnail(saveFilePath);

    //카테고리
    Category category = categoryService.get(Integer.parseInt(request.getParameter("category")));
     
    
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
      return "redirect:list";   
      

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
