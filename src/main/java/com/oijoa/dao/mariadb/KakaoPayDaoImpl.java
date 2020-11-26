package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.KakaoPayDao;
import com.oijoa.domain.KakaoPay;

public class KakaoPayDaoImpl implements KakaoPayDao{

  SqlSessionFactory sqlSessionFactory;

  public KakaoPayDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<KakaoPay> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("KakaoPayDao.findAll", keyword);
    }
  }
}








