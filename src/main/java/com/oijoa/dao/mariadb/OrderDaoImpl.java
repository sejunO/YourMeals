package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.OrderDao;
import com.oijoa.domain.Order;
import com.oijoa.domain.OrderList;

public class OrderDaoImpl implements OrderDao {

  SqlSessionFactory sqlSessionFactory;

  public OrderDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }



  @Override
  public List<Order> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderDao.findAll", keyword);
    }
  }

  @Override
  public List<Order> findByUserNo(int UserNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderDao.findByUserNo", UserNo);
    }
  }

  @Override
  public List<Order> findByUpdateListUserNo(int UserNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderDao.findByUpdateListUserNo", UserNo);
    }
  }

  @Override
  public int insert(OrderList orderList) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("OrderDao.insertList", orderList);
    }
  }

  @Override
  public int insert(Order order) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("OrderDao.insert", order);
    }
  }
}


