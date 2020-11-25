package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Basket;

public interface BasketDao {
  List<Basket> findAll(String keyword) throws Exception;
}








