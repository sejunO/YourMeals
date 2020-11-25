package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Category;

public interface CategoryDao {
  List<Category> findAll(String keyword) throws Exception;
}








