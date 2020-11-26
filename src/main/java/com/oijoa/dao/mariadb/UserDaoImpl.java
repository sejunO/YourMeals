package com.oijoa.dao.mariadb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oijoa.dao.UserDao;
import com.oijoa.domain.User;

public class UserDaoImpl implements UserDao{

  SqlSessionFactory sqlSessionFactory;

  public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<User> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("UserDao.findAll", keyword);
    }
  }
}








