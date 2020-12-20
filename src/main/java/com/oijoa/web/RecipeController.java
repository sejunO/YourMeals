package com.oijoa.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.util.HashMap;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Category;
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

  public ModelAndView form() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("categoryList", categoryService.list());
    mv.addObject("materialList", materialService.list());
    mv.setViewName("/recipe/form.jsp");
    return mv;
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

  @RequestMapping("list")
  public ModelAndView list(String keyword, String keywordTitle, String keywordWriter,
      String keywordCategory) throws Exception {

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
  public ModelAndView detail(int recipeNo) throws Exception {
    ModelAndView mv = new ModelAndView();
    Recipe recipe = recipeService.get(recipeNo);
    if (recipe == null) {
      System.out.println("레시피가 존재하지 않습니다.");
    }
    mv.addObject("recipe", recipe);
    mv.addObject("categorys", categoryService.list());
    mv.addObject("levels", levelService.list());
    mv.addObject("recipeSteps", recipeStepService.list(recipeNo));
    mv.addObject("comments", commentService.list(recipeNo));
    mv.setViewName("/recipe/detail.jsp");
    return mv;

  }

  @ResponseBody
  @RequestMapping("updateRecommendCount")
  public String updateRecommendCount(int recipeNo) throws Exception {
    recipeService.updateRecommendCount(recipeNo);
    return "ok";
  }

  @RequestMapping("update")
  public String update(Recipe recipe, int categoryNo, int userNo, Date modifiedDate)
      throws Exception {
    Category category = categoryService.get(categoryNo);
    User writer = userService.get(userNo);

    recipe.setCategory(category);
    recipe.setWriter(writer);
    recipe.setModifiedDate(modifiedDate);

    recipeService.updateCategory(recipe);
    if (recipeService.update(recipe) == 0) {
      throw new Exception("레시피가 존재하지 않습니다.");
    }
    return "redirect:list";
  }


  @RequestMapping("updatePhoto")
  public String updatePhoto(int no, Part photoFile) throws Exception {

    Recipe recipe = new Recipe();
    recipe.setRecipeNo(no);

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String saveFilePath = servletContext.getRealPath("/upload/" + filename);
      photoFile.write(saveFilePath);
      recipe.setPhoto(filename);

      generatePhotoThumbnail(saveFilePath);
    }

    if (recipe.getPhoto() == null) {
      throw new Exception("사진을 선택하지 않았습니다.");
    }
    recipeService.update(recipe);
    return "redirect:detail?no=" + recipe.getRecipeNo();
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
    // String ===> Date 프로퍼티 에디터 준비
    DatePropertyEditor propEditor = new DatePropertyEditor();

    // WebDataBinder에 프로퍼티 에디터 등록하기
    binder.registerCustomEditor(java.util.Date.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다.
        propEditor // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
    );
  }

  class DatePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      try {
        // 클라이언트가 텍스트로 보낸 날짜 값을 java.sql.Date 객체로 만들어 보관한다.
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
