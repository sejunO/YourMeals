package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;

public interface OrderService {

  List<Order> list() throws Exception;

  List<Order> myList(int UserNo) throws Exception;

  List<Order> myUpdateList(int UserNo) throws Exception;

  int add(Order order) throws Exception;

  int add(OrderList orderlist) throws Exception;

  Order lately(int no) throws Exception;
}
