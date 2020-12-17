package com.oijoa.web;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oijoa.domain.Category;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Level;
import com.oijoa.domain.Material;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.RecipeStep;
import com.oijoa.domain.User;
import com.oijoa.service.CategoryService;
import com.oijoa.service.CommentService;
import com.oijoa.service.LevelService;
import com.oijoa.service.MaterialService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.RecipeStepService;

import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired ServletContext servletContext;
	@Autowired RecipeService recipeService;
	@Autowired CategoryService categoryService;
	@Autowired MaterialService materialService;
	@Autowired RecipeStepService recipeStepService;
	@Autowired CommentService commentService;
	@Autowired LevelService levelService;

	
	
	@RequestMapping("form")
	public ModelAndView form() throws Exception {
			ModelAndView mv = new ModelAndView();
			mv.addObject("categoryList", categoryService.list());
			mv.addObject("materialList", materialService.list());
			mv.setViewName("/recipe/form.jsp");
			return mv;
		
	}
	
	@RequestMapping("add")
	  public String add(String title, String content, User loginUser, int level, int min, Category category, Part photoPart ) throws Exception {
	  
	    String filename = UUID.randomUUID().toString();
	    String saveFilePath = servletContext.getRealPath("/upload/" + filename);
	    photoPart.write(saveFilePath);
	    generatePhotoThumbnail(saveFilePath);
    
	    
	      Recipe recipe = new Recipe();
	      recipe.setTitle(title);
	      recipe.setContent(content);
	      recipe.setWriter(loginUser);
	      recipe.setLevelNo(level);
	      recipe.setMin(min);
	      recipe.setCategory(category);
	      recipe.setPhoto(filename);	      
	      //  재료 추가 코드 필요
	      // 조리 순서 코드 필요
	      
	      recipeService.add(recipe);   
	      return "redirect:list";         

	  }
	
	@RequestMapping("list")
	  public ModelAndView list(String keyword, String keywordTitle, String keywordWriter, String keywordCategory) throws Exception {
		
		ModelAndView mv = new ModelAndView();
	     
	      if (keyword != null) {

	        mv.addObject("list", recipeService.list(keyword));

	      } else if (keywordTitle != null) {
	        HashMap<String, Object> keywordMap = new HashMap<>();
	        keywordMap.put("title", keywordTitle);
	        keywordMap.put("writer", keywordWriter);
	        keywordMap.put("category", keywordCategory);

	        mv.addObject("list", recipeService.list(keywordMap));

	      } else {
	    	  mv.addObject("list", recipeService.list());
	      }
	      
	      mv.setViewName("/recipe/list.jsp");
	      return mv;
	  }

	@RequestMapping("detail")
	public ModelAndView detail(int no) throws Exception {
		
		ModelAndView mv = new ModelAndView();		
		Recipe recipe = recipeService.get(no);
		if (recipe == null) {
			System.out.println("레시피가 존재하지 않습니다.");
		}
		mv.addObject("list", categoryService.list());
		mv.addObject("list", levelService.list());
		mv.addObject("list", recipeStepService.list(no));
		mv.addObject("list", commentService.list(no));
		mv.setViewName("/recipe/detail.jsp");
		return mv;

	}
	
	 @RequestMapping("update") 
	  public String update(int no, String title, String content, int level, Date modifiedDate)  throws Exception {
		 
		 ModelAndView mv = new ModelAndView();	
		  Recipe recipe = recipeService.get(no);
		 
	      recipe.setRecipeNo(Integer.parseInt(request.getParameter("recipeNo")));
	      recipe.setTitle(request.getParameter("title"));
	      recipe.setContent(request.getParameter("recipe_content"));
	      recipe.setLevelNo(Integer.parseInt(request.getParameter("level")));
	      recipe.setModifiedDate(Date.valueOf(LocalDate.now()));
	      
	      // 카테고리 객체에 번호(categoryNo)만 저장, 이름(categoryName)은 따로 저장 안 함
	      Category category = new Category();
	      category.setCategoryNo(Integer.parseInt(request.getParameter("category")));
	      recipe.setCategory(category);   

	      if(recipeService.update(recipe) == 0) {
	    	  throw new Exception ("레시피가 존재하지 않습니다.");
	      }
	       recipeService.updateCategory(recipe);
	       return "redirect:list";

	  }
	
	 @RequestMapping("delete")
	  public String delete(int no) throws Exception {
		 
		 if(recipeService.deleteByNo(no) == 0) {
			 throw new Exception("레시피가 존재하지 않습니다.");
		 }
	     return "rediret:list";

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
