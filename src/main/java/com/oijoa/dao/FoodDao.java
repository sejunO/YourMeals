package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Food;

public interface FoodDao {
  List<Food> findAll(String keyword) throws Exception;

  List<Food> findByRecipeNo(int recipeNo) throws Exception;
  
  int delete(int recipeNo) throws Exception;

  int insert(Food food);
  
  int update(Food food) throws Exception;
}
