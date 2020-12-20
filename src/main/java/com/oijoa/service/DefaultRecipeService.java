package com.oijoa.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.oijoa.dao.BoardLikeDao;
import com.oijoa.dao.CommentDao;
import com.oijoa.dao.RecipeDao;
import com.oijoa.dao.RecipeStepDao;
import com.oijoa.domain.Recipe;

@Service
public class DefaultRecipeService implements RecipeService {

  RecipeDao recipeDao;
  BoardLikeDao boardLikeDao;
  RecipeStepDao recipeStepDao;
  CommentDao commentDao;

  public DefaultRecipeService(RecipeDao recipeDao, BoardLikeDao boardLikeDao,
      RecipeStepDao recipeStepDao, CommentDao commentDao) {

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
    return recipeDao.findAll();
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
  public List<Recipe> userNoList(int userNo) throws Exception {
    return recipeDao.findByUserNo(userNo);
  }

  @Override
  public List<Recipe> myLikeList(int userNo) throws Exception {
    return recipeDao.findByLike(userNo);
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
    	recipeDao.updateHits(no);
    }
    return recipeDao.findByRecipeNo(no);
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

  @Override
	public int updateCategory(Recipe recipe) throws Exception {
	  return recipeDao.updateCategory(recipe);
	}
  
  @Override
	public int updateRecommendCount(int no) throws Exception {
	  return recipeDao.updateRecommendCount(no);
	}

}
