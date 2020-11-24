package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Recipe;

public interface RecipeDao {
  List<Recipe> findAll(String keyword) throws Exception;
}








