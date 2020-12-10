package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.OrderListDao;
import com.oijoa.domain.OrderList;

public class DefaultOrderListService implements OrderListService {

  OrderListDao orderListDao;

  public DefaultOrderListService(OrderListDao orderListDao) {
    this.orderListDao = orderListDao;
  }

  @Override
  public List<OrderList> getByOrderNo(int no) throws Exception {
    return orderListDao.findByOrderNo(no);
  }

  @Override
  public List<OrderList> list() throws Exception {
    return orderListDao.findAll(null);
  }

  @Override
  public List<OrderList> myList(int loginUserNo) throws Exception {
    return orderListDao.findByUserNo(loginUserNo);
  }

  @Override
  public int add(OrderList orderList) throws Exception {
    return orderListDao.insert(orderList);
  }

  @Override
  public List<OrderList> makeList(int no) throws Exception {
    return orderListDao.makeList(no);
  }

}
