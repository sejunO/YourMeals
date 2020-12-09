package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.OrderDao;
import com.oijoa.dao.OrderListDao;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;

public class DefaultOrderService implements OrderService {

  OrderDao orderDao;
  OrderListDao orderListDao;

  public DefaultOrderService(OrderDao orderDao, OrderListDao orderListDao) {
    this.orderDao = orderDao;
    this.orderListDao = orderListDao;
  }

  @Override
  public int add(Order order) throws Exception {
    return orderDao.insert(order);
  }

  @Override
  public int add(OrderList orderList) throws Exception {
    return orderDao.insert(orderList);
  }

  @Override
  public List<Order> list() throws Exception {
    return orderDao.findAll(null);
  }

  @Override
  public List<Order> myList(int UserNo) throws Exception {
    return orderDao.findByUserNo(UserNo);
  }

  @Override
  public List<Order> myUpdateList(int UserNo) throws Exception {
    return orderDao.findByUpdateListUserNo(UserNo);
  }

  // @Override
  // public List<Order> list(String keyword) throws Exception {
  // return orderDao.findAll(keyword);
  // }
  //
  // @Override
  // public Board get(int no) throws Exception {
  // Board board = boardDao.findByNo(no);
  // if (board != null) {
  // boardDao.updateViewCount(no);
  // }
  // return board;
  // }
  //
  // @Override
  // public int update(Board board) throws Exception {
  // return boardDao.update(board);
  // }

}
