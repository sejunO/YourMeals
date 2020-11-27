package com.oijoa.dao;

import java.util.List;
import java.util.Map;
import com.oijoa.domain.Recipe;

public interface RecipeDao {
  List<Recipe> findAll(String keyword) throws Exception;
  int insert(Recipe recipe) throws Exception;
  int insertCategory(Map<String,Object> map) throws Exception;
}








