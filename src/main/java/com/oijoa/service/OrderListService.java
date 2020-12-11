package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.OrderList;

public interface OrderListService {

  List<OrderList> list() throws Exception;

  List<OrderList> myList(int loginUserNo) throws Exception;

  int add(OrderList orderList) throws Exception;

  List<OrderList> makeList(int no) throws Exception;

  List<OrderList> getByOrderNo(int no) throws Exception;
}
