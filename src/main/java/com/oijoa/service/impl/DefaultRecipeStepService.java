package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.RecipeStepDao;
import com.oijoa.domain.RecipeStep;
import com.oijoa.service.RecipeStepService;

@Service
public class DefaultRecipeStepService implements RecipeStepService {

  RecipeStepDao recipeStepDao;

  public DefaultRecipeStepService(RecipeStepDao recipeStepDao) {
    this.recipeStepDao = recipeStepDao;
  }

  @Override
  public int deleteByRecipeNo(int recipeNo) throws Exception {
    return recipeStepDao.deleteByRecipeNo(recipeNo);
  }

  // @Override
  // public int add(Board board) throws Exception {
  // return boardDao.insert(board);
  // }
  //
  @Override
  public List<RecipeStep> list() throws Exception {
    return recipeStepDao.findAll(null);
  }

  @Override
  public List<RecipeStep> list(String keyword) throws Exception {
    return recipeStepDao.findAll(keyword);
  }

  @Override
  public List<RecipeStep> list(int recipeNo) throws Exception {
    return recipeStepDao.findByRecipeNo(recipeNo);
  }

  @Override
  public int add(RecipeStep step) throws Exception {
    return recipeStepDao.insert(step);
  }
  
  @Override
	public int delete(int recipeNo) throws Exception {
	   return recipeStepDao.delete(recipeNo);
	}
  
  @Override
	public int update(RecipeStep recipeStep) throws Exception {
	   return recipeStepDao.update(recipeStep);
	}

}
