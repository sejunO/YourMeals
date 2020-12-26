package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Food;

public interface FoodService {

  List<Food> list() throws Exception;

  List<Food> list(String keyword) throws Exception;

  List<Food> list(int recipeNo) throws Exception;

  int add(Food food) throws Exception;

}
