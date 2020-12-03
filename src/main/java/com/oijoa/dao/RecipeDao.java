package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Recipe;

public interface RecipeDao {
	List<Recipe> findAll(String keyword) throws Exception;
	List<Recipe> findByUserNo(int loginUserNo) throws Exception;
	List<Recipe> findByLike(int loginUserNo) throws Exception;
	int insert(Recipe recipe) throws Exception;
	int insertCategory(Recipe recipe) throws Exception;
	int update(Recipe recipe) throws Exception;
	Recipe findByRecipeNo(int no) throws Exception;
	int updateViewCount(int no) throws Exception;
	int delete(int no) throws Exception;
}
