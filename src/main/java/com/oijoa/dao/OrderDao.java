package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;

public interface OrderDao {
  List<Order> findAll(String keyword) throws Exception;

  List<Order> findByUserNo(int UserNo) throws Exception;

  List<Order> findByUpdateListUserNo(int UserNo) throws Exception;

  List<Order> findByUno(int userNo) throws Exception;

  int insert(Order order) throws Exception;

  Order findLatelyOrder(int no) throws Exception;

  int insertList(OrderList orderList);
}


