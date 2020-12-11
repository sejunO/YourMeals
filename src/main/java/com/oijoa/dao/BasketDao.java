package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Basket;

public interface BasketDao {
  List<Basket> findAll(String keyword) throws Exception;
  int insert(Basket basket) throws Exception;
  List<Basket> findByUserNo(int loginUserNo) throws Exception;
  Basket findByNo(int no) throws Exception;
  int delete(int no) throws Exception;
}








