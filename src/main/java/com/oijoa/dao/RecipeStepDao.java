package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.RecipeStep;

public interface RecipeStepDao {
  List<RecipeStep> findAll(String keyword) throws Exception;
}








