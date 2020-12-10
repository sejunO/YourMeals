package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.OrderListDao;
import com.oijoa.domain.OrderList;

public class OrderListDaoImpl implements OrderListDao {

  SqlSessionFactory sqlSessionFactory;

  public OrderListDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<OrderList> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderListDao.findAll", keyword);
    }
  }

  @Override
  public List<OrderList> findByUserNo(int loginUserNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderListDao.findByUserNo", loginUserNo);
    }
  }

  @Override
  public int insert(OrderList orderList) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("OrderListDao.insert", orderList);
    }
  }

  @Override
  public List<OrderList> makeList(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderListDao.makeList", no);
    }
  }

  @Override
  public List<OrderList> findByOrderNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("OrderListDao.findByOrderNo", no);
    }
  }
}


