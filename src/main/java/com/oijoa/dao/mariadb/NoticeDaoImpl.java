package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.oijoa.dao.NoticeDao;
import com.oijoa.domain.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {

  SqlSessionFactory sqlSessionFactory;

  public NoticeDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Notice> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("NoticeDao.findAll", keyword);
    }
  }

  @Override
  public int add(Notice notice) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("NoticeDao.insert", notice);
    }
  }
}


