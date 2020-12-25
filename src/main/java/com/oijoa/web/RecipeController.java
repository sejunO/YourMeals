package com.oijoa.web;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.oijoa.domain.Category;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.CategoryService;
import com.oijoa.service.CommentService;
import com.oijoa.service.LevelService;
import com.oijoa.service.MaterialService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.RecipeStepService;
import com.oijoa.service.UserService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

  @Autowired
  ServletContext servletContext;
  @Autowired
  RecipeService recipeService;
  @Autowired
  CategoryService categoryService;
  @Autowired
  MaterialService materialService;
  @Autowired
  RecipeStepService recipeStepService;
  @Autowired
  CommentService commentService;
  @Autowired
  LevelService levelService;
  @Autowired
  UserService userService;



  @RequestMapping("form")
  public void form(Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.list());
    model.addAttribute("materialList", materialService.list());
  }

  @RequestMapping("add")
  public String add(HttpSession session, String title, String content, String min, String levelNo,
      Part photoPart, int categoryNo) throws Exception {

    String filename = UUID.randomUUID().toString();
    String saveFilePath = servletContext.getRealPath("/upload/" + filename);
    photoPart.write(saveFilePath);
    generatePhotoThumbnail(saveFilePath);
    Recipe recipe = new Recipe();
    recipe.setTitle(title);
    recipe.setContent(content);
    recipe.setLevelNo(Integer.parseInt(levelNo));
    recipe.setMin(Integer.parseInt(min));
    recipe.setWriter((User) session.getAttribute("loginUser"));
    recipe.setCategory(categoryService.get(categoryNo));
    recipe.setPhoto(filename);
    // 재료 추가 코드 필요
    // 조리 순서 코드 필요

    recipeService.add(recipe);

    return "redirect:list";

  }

  @RequestMapping("addComment")
  public String add(int crecipeNo, int userNo, String comment_content) throws Exception {
    Recipe recipe = recipeService.get(crecipeNo);
    User user = userService.get(userNo);
    Comment comment = new Comment();
    comment.setRecipeNo(recipe.getRecipeNo());
    comment.setWriter(user);
    comment.setContent(comment_content);
    commentService.add(comment);
    return "redirect:detail";
  }

  @RequestMapping("list")
  public void list(Model model, String keyword, String keywordTitle, String keywordWriter,
      String keywordCategory) throws Exception {
    if (keyword != null) {
      model.addAttribute("list", recipeService.list(keyword));
    } else if (keywordTitle != null) {
      HashMap<String, Object> keywordMap = new HashMap<>();
      keywordMap.put("title", keywordTitle);
      keywordMap.put("writer", keywordWriter);
      keywordMap.put("category", keywordCategory);

      model.addAttribute("list", recipeService.list(keywordMap));

    } else {
      model.addAttribute("list", recipeService.list());
    }

  }


  @RequestMapping("detail")
  public void detail(Model model, int recipeNo) throws Exception {
    Recipe recipe = recipeService.get(recipeNo);
    if (recipe == null) {
      System.out.println("레시피가 존재하지 않습니다.");
    }
    model.addAttribute("recipe", recipe);
    model.addAttribute("categorys", categoryService.list());
    model.addAttribute("levels", levelService.list());
    model.addAttribute("recipeSteps", recipeStepService.list(recipeNo));
    model.addAttribute("comments", commentService.list(recipeNo));
  }


  @ResponseBody
  @RequestMapping("updateRecommendCount")
  public String updateRecommendCount(int recipeNo) throws Exception {
    recipeService.updateRecommendCount(recipeNo);
    return "ok";
  }

  @RequestMapping("update")
  public String update(Recipe recipe, int categoryNo, int userNo) throws Exception {

    Category category = categoryService.get(categoryNo);
    User writer = userService.get(userNo);

    recipe.setCategory(category);
    recipe.setWriter(writer);
    recipeService.updateCategory(recipe);

    if (recipeService.update(recipe) == 0) {
      throw new Exception("레시피가 존재하지 않습니다.");
    }
    return "redirect:list";
  }


  @RequestMapping("updatePhoto")
  public String updatePhoto(int no, MultipartFile photoFile) throws Exception {

    Recipe recipe = new Recipe();
    recipe.setRecipeNo(no);

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String saveFilePath = servletContext.getRealPath("/upload/" + filename);
      photoFile.transferTo(new File(saveFilePath));
      recipe.setPhoto(filename);

      generatePhotoThumbnail(saveFilePath);
    }

    if (recipe.getPhoto() == null) {
      throw new Exception("사진을 선택하지 않았습니다.");
    }
    recipeService.update(recipe);
    return "redirect:detail?recipeNo=" + recipe.getRecipeNo();
  }

  @RequestMapping("delete")
  public String delete(int no) throws Exception {

    if (recipeService.deleteByNo(no) == 0) {
      throw new Exception("레시피가 존재하지 않습니다.");
    }
    return "rediret:list";

  }



  @InitBinder
  public void initBinder(WebDataBinder binder) {
    DatePropertyEditor propEditor = new DatePropertyEditor();

    binder.registerCustomEditor(java.util.Date.class,
        propEditor
        );
  }

  class DatePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      try {
        setValue(java.sql.Date.valueOf(text));
      } catch (Exception e) {
        throw new IllegalArgumentException(e);
      }
    }
  }



  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath).size(30, 30).outputFormat("jpg").crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(saveFilePath).size(120, 120).outputFormat("jpg").crop(Positions.CENTER)
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
