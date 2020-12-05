package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.OrderList;

public interface OrderListService {

  List<OrderList> list() throws Exception;
  List<OrderList> myList(int loginUserNo) throws Exception;

}
