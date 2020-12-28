package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;

public interface OrderService {

  List<Order> list() throws Exception;

  List<Order> myList(int userNo) throws Exception;
  
  List<Order> myDescList(int userNo) throws Exception;

  List<Order> myUpdateList(int userNo) throws Exception;

  List<Order> myOrderList(int userNo) throws Exception;

  List<Order> myOrderShippingList(int userNo) throws Exception;
  
  int add(Order order) throws Exception;

  int add(OrderList orderlist) throws Exception;

  Order lately(int no) throws Exception;

  Order get(int no) throws Exception;

  int update(Order order) throws Exception;
}
