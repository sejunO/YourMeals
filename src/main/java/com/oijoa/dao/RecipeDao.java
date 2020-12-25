package com.oijoa.dao;

import java.util.List;
import java.util.Map;
import com.oijoa.domain.Recipe;

public interface RecipeDao {
  List<Recipe> findAll() throws Exception;

  List<Recipe> findByKeyword(String keyword) throws Exception;

  List<Recipe> findByUserNo(int userNo) throws Exception;

  List<Recipe> findByLike(int userNo) throws Exception;

  List<Recipe> findByDetailKeyword(Map<String, Object> map) throws Exception;

  List<Recipe> findRecipeMaterial(int recipeNo) throws Exception;

  Recipe findByRecipeNo(int no) throws Exception;

  int insert(Recipe recipe) throws Exception;

  int insertCategory(Recipe recipe) throws Exception;

  int update(Recipe recipe) throws Exception;

  int updateCategory(Recipe recipe) throws Exception;

  int updateHits(int no) throws Exception;

  int updateRecommendCount(int no) throws Exception;

  int delete(int no) throws Exception;

  int deleteRecipeCategory(int recipeNo) throws Exception;

  int deleteRecipeMaterial(int recipeNo) throws Exception;

  Recipe findLatelyRecipe(int userNo) throws Exception;

}
