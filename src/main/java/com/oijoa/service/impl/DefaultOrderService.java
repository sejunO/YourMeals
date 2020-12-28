package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.OrderDao;
import com.oijoa.dao.OrderListDao;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;
import com.oijoa.service.OrderService;

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
  public List<Order> myList(int userNo) throws Exception {
    return orderDao.findByUserNo(userNo);
  }

  @Override
  public List<Order> myUpdateList(int userNo) throws Exception {
    return orderDao.findByUpdateListUserNo(userNo);
  }

  @Override
  public List<Order> myOrderList(int userNo) throws Exception {
    return orderDao.findByOrderListUserNo(userNo);
  }

  @Override
  public Order lately(int no) throws Exception {
    return orderDao.findLatelyOrder(no);
  }

  @Override
  public Order get(int no) throws Exception {
    return orderDao.findByNo(no);
  }

  @Override
  public int update(Order order) throws Exception {
    return orderDao.update(order);
  }

  @Override
  public List<Order> myOrderShippingList(int userNo) throws Exception {
    return orderDao.findByOrderShippingListUserNo(userNo);
  }


}
