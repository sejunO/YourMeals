package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.CommentDao;
import com.oijoa.domain.Comment;

public class CommentDaoImpl implements CommentDao{

  SqlSessionFactory sqlSessionFactory;

  public CommentDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Comment> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CommentDao.findAll", keyword);
    }
  }
}








