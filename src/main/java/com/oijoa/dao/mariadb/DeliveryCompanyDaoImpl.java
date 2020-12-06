package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.DeliveryCompanyDao;
import com.oijoa.domain.DeliveryCompany;

public class DeliveryCompanyDaoImpl implements DeliveryCompanyDao {

  SqlSessionFactory sqlSessionFactory;

  public DeliveryCompanyDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public DeliveryCompany findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("DeliveryCompanyDao.findByNo", no);
    }
  }



  @Override
  public List<DeliveryCompany> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("DeliveryCompanyDao.findAll", keyword);
    }
  }
}


