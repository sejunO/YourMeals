package com.oijoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.oijoa.dao.RecipeDao;
import com.oijoa.domain.Recipe;

public class DefaultRecipeService implements RecipeService {

  RecipeDao recipeDao;

  public DefaultRecipeService(RecipeDao recipeDao) {
    this.recipeDao = recipeDao;
  }

  //  @Override
  //  public int delete(int no) throws Exception {
  //    return boardDao.delete(no);
  //  }
  //
  //  @Override
  //  public int add(Board board) throws Exception {
  //    return boardDao.insert(board);
  //  }
  //
  @Override
  public List<Recipe> list() throws Exception {
    return recipeDao.findAll(null);
  }
  @Override
  public int add(Recipe recipe) throws Exception {
    Map<String,Object> map = new HashMap<>();
    map.put("recipeNo", recipe.getRecipeNo());
    map.put("categoryNo", recipe.getCategory().getCategoryNo());

    recipeDao.insertCategory(map);
    return recipeDao.insert(recipe);
  }
  //  @Override
  //  public List<Order> list(String keyword) throws Exception {
  //    return orderDao.findAll(keyword);
  //  }
  //
  //  @Override
  //  public Board get(int no) throws Exception {
  //    Board board = boardDao.findByNo(no);
  //    if (board != null) {
  //      boardDao.updateViewCount(no);
  //    }
  //    return board;
  //  }
  //
  //  @Override
  //  public int update(Board board) throws Exception {
  //    return boardDao.update(board);
  //  }

}
