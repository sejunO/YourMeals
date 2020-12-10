package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.MyBuyListDao;
import com.oijoa.domain.MyBuyList;

public class MyBuyListDaoImpl implements MyBuyListDao {

  SqlSessionFactory sqlSessionFactory;

  public MyBuyListDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<MyBuyList> findByUnoOno(int userNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("MyBuyListDao.findByUnoOno", userNo);
    }
  }
}
