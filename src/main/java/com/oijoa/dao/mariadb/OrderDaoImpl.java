package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.OrderDao;
import com.oijoa.domain.Order;

public class OrderDaoImpl implements OrderDao{

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
  public List<Order> findByUserNo(int loginUserNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderDao.findByUserNo", loginUserNo);
    }
  }
  @Override
  public int insert(Order order) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("OrderDao.insert", order);
    }
  }
}








