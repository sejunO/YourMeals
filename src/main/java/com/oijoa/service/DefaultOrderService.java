package com.oijoa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.OrderDao;
import com.oijoa.dao.OrderListDao;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;

@Service
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
    return orderDao.insertList(orderList);
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

  @Override
  public List<Order> myBuyList(int UserNo) throws Exception {
    return orderDao.findByUno(UserNo);
  }

  @Override
  public Order lately(int no) throws Exception {
    return orderDao.findLatelyOrder(no);
  }


}
