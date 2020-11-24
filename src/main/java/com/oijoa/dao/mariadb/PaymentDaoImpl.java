package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.PaymentDao;
import com.oijoa.domain.Payment;

public class PaymentDaoImpl implements PaymentDao{

  SqlSessionFactory sqlSessionFactory;

  public PaymentDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Payment> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("PaymentDao.findAll", keyword);
    }
  }
}








