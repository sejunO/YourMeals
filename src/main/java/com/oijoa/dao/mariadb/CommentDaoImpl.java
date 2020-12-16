package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.oijoa.dao.CommentDao;
import com.oijoa.domain.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

  SqlSessionFactory sqlSessionFactory;

  public CommentDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(Comment comment) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("CommentDao.insert", comment);
    }
  }

  @Override
  public List<Comment> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CommentDao.findAll", keyword);
    }
  }

  @Override
  public List<Comment> findByUserNo(int userNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CommentDao.findByUserNo", userNo);
    }
  }

  @Override
  public List<Comment> findByRecipeNo(int recipeNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CommentDao.findByRecipeNo", recipeNo);
    }
  }

  @Override
  public int deleteByRecipeNo(int recipeNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("CommentDao.deleteByRecipeNo", recipeNo);
    }
  }

}


