package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.ReportDao;
import com.oijoa.domain.Report;

public class ReportDaoImpl implements ReportDao {

  SqlSessionFactory sqlSessionFactory;

  public ReportDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Report> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("ReportDao.findAll", keyword);
    }
  }
}








