package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.ReportTypeDao;
import com.oijoa.domain.ReportType;

public class ReportTypeDaoImpl implements ReportTypeDao{

  SqlSessionFactory sqlSessionFactory;

  public ReportTypeDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<ReportType> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("ReportTypeDao.findAll", keyword);
    }
  }
}








