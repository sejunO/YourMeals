package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.FollowDao;
import com.oijoa.domain.Follow;

public class FollowDaoImpl implements FollowDao{

  SqlSessionFactory sqlSessionFactory;

  public FollowDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Follow> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("FollowDao.findAll", keyword);
    }
  }

  @Override
  public List<Follow> FollowerList(int UserNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("FollowDao.findByFollowerUserNo", UserNo);
    }
  }

  @Override
  public List<Follow> FollowingList(int UserNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("FollowDao.findByFollowingUserNo", UserNo);
    }
  }
}








