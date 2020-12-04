package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.OrderList;

public interface OrderListDao {
  List<OrderList> findAll(String keyword) throws Exception;
  List<OrderList> findByUserNo(int loginUserNo) throws Exception;
}








