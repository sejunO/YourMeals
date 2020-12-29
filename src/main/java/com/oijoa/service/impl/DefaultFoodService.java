package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.FoodDao;
import com.oijoa.domain.Food;
import com.oijoa.service.FoodService;

@Service
public class DefaultFoodService implements FoodService {

  FoodDao foodDao;

  public DefaultFoodService(FoodDao foodDao) {
    this.foodDao = foodDao;
  }

  @Override
  public List<Food> list() throws Exception {
    return foodDao.findAll(null);
  }

  @Override
  public List<Food> list(String keyword) throws Exception {
    return foodDao.findAll(keyword);
  }

  @Override
  public List<Food> list(int recipeNo) throws Exception {
    return foodDao.findByRecipeNo(recipeNo);
  }

  @Override
  public int add(Food food) throws Exception {
    return foodDao.insert(food);
  }
  
  @Override
	public int update(Food food) throws Exception {
	  return foodDao.update(food);
	}
  
  @Override
	public int delete(int recipeNo) throws Exception {
	  return foodDao.delete(recipeNo);
	}

}
