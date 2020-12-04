package com.oijoa.service;

import java.util.List;
import java.util.Map;

import com.oijoa.domain.Recipe;

public interface RecipeService {

  List<Recipe> list() throws Exception;
  List<Recipe> list(String keyword) throws Exception;
  List<Recipe> list(Map<String,Object> map) throws Exception;
  List<Recipe> myList(int loginUserNo) throws Exception;
  List<Recipe> myLikeList(int loginUserNo) throws Exception;
  int add (Recipe recipe) throws Exception;
  int update(Recipe recipe) throws Exception;
  Recipe get(int no) throws Exception;
  int deleteByNo(int recipeNo) throws Exception;
}
