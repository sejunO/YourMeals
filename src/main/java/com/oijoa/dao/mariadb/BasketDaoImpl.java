package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.BasketDao;
import com.oijoa.domain.Basket;

public class BasketDaoImpl implements BasketDao{

  SqlSessionFactory sqlSessionFactory;

  public BasketDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Basket> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BasketDao.findAll", keyword);
    }
  }
  @Override
  public int insert(Basket basket) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("BasketDao.insert", basket);
    }
  }
}








