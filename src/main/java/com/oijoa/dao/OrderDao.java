package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;

public interface OrderDao {
  List<Order> findAll(String keyword) throws Exception;

  List<Order> findByUserNo(int UserNo) throws Exception;
  
  List<Order> descfindByUserNo(int UserNo) throws Exception;
  
  List<Order> findByUpdateListUserNo(int UserNo) throws Exception;

  List<Order> findByOrderListUserNo(int userNo) throws Exception;

  int insert(Order order) throws Exception;

  Order findLatelyOrder(int no) throws Exception;

  int insertList(OrderList orderList) throws Exception;

  Order findByNo(int no) throws Exception;

  int update(Order order) throws Exception;

  List<Order> findByOrderShippingListUserNo(int userNo) throws Exception;
}


