package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Order;

public interface OrderDao {
  List<Order> findAll(String keyword) throws Exception;
  List<Order> findByUserNo(int loginUserNo) throws Exception;
  int insert(Order order) throws Exception;
}








