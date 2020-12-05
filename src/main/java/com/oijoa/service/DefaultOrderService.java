package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.OrderDao;
import com.oijoa.domain.Order;

public class DefaultOrderService implements OrderService {

  OrderDao orderDao;

  public DefaultOrderService(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  //  @Override
  //  public int delete(int no) throws Exception {
  //    return boardDao.delete(no);
  //  }
  @Override
  public int add(Order order) throws Exception {
    return orderDao.insert(order);
  }
  @Override
  public List<Order> list() throws Exception {
    return orderDao.findAll(null);
  }
  @Override
  public List<Order> myList(int loginUserNo) throws Exception {
    return orderDao.findByUserNo(loginUserNo);
  }

  //  @Override
  //  public List<Order> list(String keyword) throws Exception {
  //    return orderDao.findAll(keyword);
  //  }
  //
  //  @Override
  //  public Board get(int no) throws Exception {
  //    Board board = boardDao.findByNo(no);
  //    if (board != null) {
  //      boardDao.updateViewCount(no);
  //    }
  //    return board;
  //  }
  //
  //  @Override
  //  public int update(Board board) throws Exception {
  //    return boardDao.update(board);
  //  }

}
