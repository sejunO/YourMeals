package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.QnADao;
import com.oijoa.domain.Qna;

public class QnADaoImpl implements QnADao{

  SqlSessionFactory sqlSessionFactory;

  public QnADaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Qna> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("QnADao.findAll", keyword);
    }
  }
}








