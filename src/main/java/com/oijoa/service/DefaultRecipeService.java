package com.oijoa.service;

import java.util.List;
import java.util.Map;

import com.oijoa.dao.BoardLikeDao;
import com.oijoa.dao.CommentDao;
import com.oijoa.dao.RecipeDao;
import com.oijoa.dao.RecipeStepDao;
import com.oijoa.domain.Recipe;

public class DefaultRecipeService implements RecipeService {

  RecipeDao recipeDao;
  BoardLikeDao boardLikeDao;
  RecipeStepDao recipeStepDao; 
  CommentDao commentDao;

  public DefaultRecipeService(
		  RecipeDao recipeDao,
 		  BoardLikeDao boardLikeDao,
		  RecipeStepDao recipeStepDao,
		  CommentDao commentDao) {
	  
    this.recipeDao = recipeDao;
    this.boardLikeDao = boardLikeDao;
    this.recipeStepDao = recipeStepDao;
    this.commentDao = commentDao;
  }

  // @Override
  // public int delete(int no) throws Exception {
  // return boardDao.delete(no);
  // }
  //
  // @Override
  // public int add(Board board) throws Exception {
  // return boardDao.insert(board);
  // }
  //
  
  @Override
  public List<Recipe> list() throws Exception {	 
	  return  recipeDao.findAll();
  }
  
  @Override
  public List<Recipe> list(String keyword) throws Exception {
    return recipeDao.findByKeyword(keyword);
  }
  
  @Override
	public List<Recipe> list(Map<String, Object> map) throws Exception {
	  return recipeDao.findByDetailKeyword(map);
	}

  @Override
  public List<Recipe> userNoList(int UserNo) throws Exception {
    return recipeDao.findByUserNo(UserNo);
  }
  
  @Override
  public List<Recipe> myLikeList(int loginUserNo) throws Exception {
    return recipeDao.findByLike(loginUserNo);
  }


  @Override
  public int add(Recipe recipe) throws Exception {
    recipeDao.insert(recipe);
    recipeDao.insertCategory(recipe);
    return 1;
  }

  // @Override
  // public List<Order> list(String keyword) throws Exception {
  // return orderDao.findAll(keyword);
  // }
  //
  
  @Override
	public List<Recipe> getRecipeMaterial(int recipeNo) throws Exception {
		return recipeDao.findRecipeMaterial(recipeNo);
	}
  
  @Override
  public Recipe get(int no) throws Exception {
    Recipe recipe = recipeDao.findByRecipeNo(no);
    if (recipe != null) {
      // recipeDao.updateViewCount(no);
    }
    return recipe;
  }

	
	@Override
	public int deleteByNo(int recipeNo) throws Exception {
		recipeDao.deleteRecipeCategory(recipeNo);
		recipeDao.deleteRecipeMaterial(recipeNo);
		boardLikeDao.deleteByRecipeNo(recipeNo);
		recipeStepDao.deleteByRecipeNo(recipeNo);
		commentDao.deleteByRecipeNo(recipeNo);
		return recipeDao.delete(recipeNo);
	}

  @Override
  public int update(Recipe recipe) throws Exception {
    return recipeDao.update(recipe);
  }
  




}
