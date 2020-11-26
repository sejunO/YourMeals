package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.RefundDao;
import com.oijoa.domain.Refund;

public class RefundDaoImpl implements RefundDao{

  SqlSessionFactory sqlSessionFactory;

  public RefundDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Refund> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RefundDao.findAll", keyword);
    }
  }
}








