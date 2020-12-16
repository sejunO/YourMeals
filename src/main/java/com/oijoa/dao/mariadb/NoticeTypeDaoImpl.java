package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.oijoa.dao.NoticeTypeDao;
import com.oijoa.domain.NoticeType;

@Repository
public class NoticeTypeDaoImpl implements NoticeTypeDao {

  SqlSessionFactory sqlSessionFactory;

  public NoticeTypeDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<NoticeType> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("NoticeTypeDao.findAll", keyword);
    }
  }
}


