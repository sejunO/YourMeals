package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.RecipeStepDao;
import com.oijoa.domain.RecipeStep;

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
	//
	// @Override
	// public Board get(int no) throws Exception {
	// Board board = boardDao.findByNo(no);
	// if (board != null) {
	// boardDao.updateViewCount(no);
	// }
	// return board;
	// }
	//
	// @Override
	// public int update(Board board) throws Exception {
	// return boardDao.update(board);
	// }

}
