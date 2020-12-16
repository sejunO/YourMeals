package com.oijoa.dao.mariadb;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.oijoa.dao.MyBuyListDao;

@Repository
public class MyBuyListDaoImpl implements MyBuyListDao {

  SqlSessionFactory sqlSessionFactory;

  public MyBuyListDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  // @Override
  // public List<MyBuyList> findByUnoOno(int userNo) {
  // try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  // return sqlSession.selectList("MyBuyListDao.findByUnoOno", userNo);
  // }
  // }
}
