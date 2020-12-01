package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Recipe;

public interface RecipeDao {
  List<Recipe> findAll(String keyword) throws Exception;
  List<Recipe> findMy(String keyword) throws Exception;
  int insert(Recipe recipe) throws Exception;
  int insertCategory(Recipe recipe) throws Exception;
}








