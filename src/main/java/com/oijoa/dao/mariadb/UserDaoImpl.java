package com.oijoa.dao.mariadb;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.UserDao;
import com.oijoa.domain.User;

public class UserDaoImpl implements UserDao {

  SqlSessionFactory sqlSessionFactory;

  public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public User findByEmailPassword(String email, String password) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      HashMap<String,Object> map = new HashMap<>();
      map.put("email", email);
      map.put("password", password);
      return sqlSession.selectOne("UserDao.findByEmailPassword", map);
    }
  }


  @Override
  public List<User> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("UserDao.findAll");
    }
  }


  @Override
  public int update(User user) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("UserDao.update", user);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("MemberDao.delete", no);
    }
  }

  @Override
  public User findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("UserDao.findByNo");
    }
  }
}


