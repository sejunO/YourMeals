package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Order;

public interface OrderService {

  List<Order> list() throws Exception;
  List<Order> myList(int loginUserNo) throws Exception;
  int add(Order order) throws Exception;
}
