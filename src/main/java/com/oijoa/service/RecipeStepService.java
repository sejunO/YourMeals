package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.RecipeStep;

public interface RecipeStepService {

  List<RecipeStep> list() throws Exception;
  List<RecipeStep> list(String keyword) throws Exception;
  List<RecipeStep> findByRecipeNo(int recipeNo) throws Exception;
}
