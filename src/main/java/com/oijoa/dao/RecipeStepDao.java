package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.RecipeStep;

public interface RecipeStepDao {
  List<RecipeStep> findAll(String keyword) throws Exception;

  List<RecipeStep> findByRecipeNo(int recipeNo) throws Exception;

  int deleteByRecipeNo(int recipeNo) throws Exception;

  int insert(RecipeStep step) throws Exception;
}


