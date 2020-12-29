package com.oijoa.web;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.sql.Date;
import java.util.HashMap;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.oijoa.domain.Comment;
import com.oijoa.domain.Food;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.RecipeStep;
import com.oijoa.domain.User;
import com.oijoa.service.CategoryService;
import com.oijoa.service.CommentService;
import com.oijoa.service.FoodService;
import com.oijoa.service.LevelService;
import com.oijoa.service.MaterialService;
import com.oijoa.service.NoticeService;
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
  @Autowired
  FoodService foodService;
  @Autowired
  NoticeService noticeService;



  @RequestMapping("form")
  public void form(Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.list());
    model.addAttribute("materialList", materialService.list());
  }

  @RequestMapping("add")
  public String add(HttpSession session, String title, String content, String min, String levelNo,
      MultipartFile recipe_photo, int categoryNo, int serving, String[] step,
      MultipartFile[] step_photo, String[] metaname, String[] metaamount) throws Exception {


    User user = (User) session.getAttribute("loginUser");
    String filename = UUID.randomUUID().toString();
    String saveFilePath = servletContext.getRealPath("/upload/" + filename);
    recipe_photo.transferTo(new File(saveFilePath));
    generatePhotoThumbnail(saveFilePath);


    Recipe recipe = new Recipe();
    recipe.setTitle(title);
    recipe.setContent(content);
    recipe.setLevelNo(Integer.parseInt(levelNo));
    recipe.setMin(Integer.parseInt(min));
    recipe.setWriter(user);
    recipe.setCategory(categoryService.get(categoryNo));
    recipe.setPhoto(filename);
    recipe.setServing(serving);


    recipeService.add(recipe);
    // 로그인 유저의 최근 레시피 번호를 찾아서 레시피 스텝에 추가
    Recipe latelyRecipe = recipeService.lately(user.getUserNo());
    for (int i = 0; i < metaname.length; i++) {
      Food food = new Food();
      food.setRecipeNo(latelyRecipe.getRecipeNo());
      food.setName(metaname[i]);
      food.setAmount(metaamount[i]);
      foodService.add(food);
    }


    for (int i = 0; i < step.length; i++) {
      RecipeStep recipestep = new RecipeStep();
      recipestep.setRecipeNo(latelyRecipe.getRecipeNo());
      recipestep.setStep(i + 1);
      recipestep.setContent(step[i]);
      filename = UUID.randomUUID().toString();
      saveFilePath = servletContext.getRealPath("/upload/" + filename);
      step_photo[i].transferTo(new File(saveFilePath));
      generatePhotoThumbnail(saveFilePath);
      recipestep.setPhoto(filename);
      recipeStepService.add(recipestep);
    }

    return "redirect:list";

  }

  @RequestMapping("addComment")
  public String addComment(int recipeNo, int userNo, String comment_content) throws Exception {
    Recipe recipe = recipeService.get(recipeNo);
    User user = userService.get(userNo);
    Comment comment = new Comment();
    comment.setRecipeNo(recipe.getRecipeNo());
    comment.setWriter(user);
    comment.setContent(comment_content);
    commentService.add(comment);
    return "redirect:detail?recipeNo=" + recipeNo;
  }

  @GetMapping("list")
  public void getList(Model model, String option, String keyword) throws Exception {
    if (option == null) {
      model.addAttribute("list", recipeService.list());
    } else if (option.equalsIgnoreCase("all")) {
      model.addAttribute("list", recipeService.list(keyword));
    } else if (option.equalsIgnoreCase("title")) {
      HashMap<String, Object> keywordMap = new HashMap<>();
      keywordMap.put("title", keyword);
      model.addAttribute("list", recipeService.list(keywordMap));
    } else if (option.equalsIgnoreCase("writer")) {
      HashMap<String, Object> keywordMap = new HashMap<>();
      keywordMap.put("writer", keyword);
      model.addAttribute("list", recipeService.list(keywordMap));
    } else if (option.equalsIgnoreCase("category")) {
      HashMap<String, Object> keywordMap = new HashMap<>();
      keywordMap.put("category", keyword);
      model.addAttribute("list", recipeService.list(keywordMap));
    } else {
      model.addAttribute("list", recipeService.list());
    }
    model.addAttribute("notices", noticeService.list());
  }

  @PostMapping("list")
  public void postList(Model model, String option, String keyword) throws Exception {
    if (option == null) {
      model.addAttribute("list", recipeService.list());
    } else if (option.equalsIgnoreCase("all")) {
      model.addAttribute("list", recipeService.list(keyword));
    } else if (option.equalsIgnoreCase("title")) {
      HashMap<String, Object> keywordMap = new HashMap<>();
      keywordMap.put("title", keyword);
      model.addAttribute("list", recipeService.list(keywordMap));
    } else if (option.equalsIgnoreCase("writer")) {
      HashMap<String, Object> keywordMap = new HashMap<>();
      keywordMap.put("writer", keyword);
      model.addAttribute("list", recipeService.list(keywordMap));
    } else if (option.equalsIgnoreCase("category")) {
      HashMap<String, Object> keywordMap = new HashMap<>();
      keywordMap.put("category", keyword);
      model.addAttribute("list", recipeService.list(keywordMap));
    } else {
      model.addAttribute("list", recipeService.list());
    }
    model.addAttribute("notices", noticeService.list());
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
    model.addAttribute("foods", foodService.list(recipeNo));
  }

  @GetMapping("beforeUpdate")
  public void beforeUpdate(Model model, int recipeNo) throws Exception {
    Recipe recipe = recipeService.get(recipeNo);
    if (recipe == null) {
      System.out.println("레시피가 존재하지 않습니다.");
    }
    model.addAttribute("recipe", recipe);
    model.addAttribute("categorys", categoryService.list());
    model.addAttribute("levels", levelService.list());
    model.addAttribute("recipeSteps", recipeStepService.list(recipeNo));
    model.addAttribute("comments", commentService.list(recipeNo));
    model.addAttribute("foods", foodService.list(recipeNo));
  }


  @RequestMapping("update")
  public String update(int recipeNo, Food food, RecipeStep recipeStep) throws Exception {
    Recipe recipe = recipeService.get(recipeNo);
    foodService.delete(recipeNo);
    foodService.add(food);
    recipeStepService.delete(recipeNo);
    recipeStepService.add(recipeStep);
    recipeService.updateCategory(recipe);
    recipeService.update(recipe);

    return "redirect:detail?recipeNo=" + recipeNo;
  }

  @ResponseBody
  @RequestMapping("updateRecommendCount")
  public String updateRecommendCount(int recipeNo) throws Exception {
    recipeService.updateRecommendCount(recipeNo);
    return "ok";
  }

  @RequestMapping("updateComment")
  public String updateComment(int recipeNo, Comment comment, String content, Date modifiedDate,
      Model model, HttpSession session) throws Exception {
    Recipe recipe = recipeService.get(recipeNo);
    User user = (User) session.getAttribute("loginUser");
    if (user != recipe.getWriter()) {
      System.out.println("수정할 수 있는 권한이 없습니다.");
    }
    comment.setContent(content);
    comment.setModifiedDate(modifiedDate);
    model.addAttribute("comment", comment);
    return "redirect:detail?recipeNo=" + recipeNo;
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
  public String delete(int recipeNo) throws Exception {

    recipeService.deleteByNo(recipeNo);
    return "redirect:list";

  }

  @RequestMapping("deleteComment")
  public String deleteComment(HttpSession session, int recipeNo) throws Exception {
    Recipe recipe = recipeService.get(recipeNo);
    User user = (User) session.getAttribute("loginUser");
    if (user != recipe.getWriter()) {
      System.out.println("삭제할 수 있는 권한이 없습니다.");
    }
    commentService.deleteByRecipeNo(recipeNo);
    return "redirect:detail?recipeNo=" + recipeNo;
  }



  @InitBinder
  public void initBinder(WebDataBinder binder) {
    DatePropertyEditor propEditor = new DatePropertyEditor();

    binder.registerCustomEditor(java.util.Date.class, propEditor);
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
      Thumbnails.of(saveFilePath).size(500, 500).outputFormat("jpg").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_500x500";
            }
          });

      Thumbnails.of(saveFilePath).size(120, 120).outputFormat("jpg").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_120x120";
            }
          });

      Thumbnails.of(saveFilePath).size(1280, 720).outputFormat("jpg").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_1280x720";
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
