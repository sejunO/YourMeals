package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.oijoa.dao.BoardLikeDao;
import com.oijoa.domain.BoardLike;

@Repository
public class BoardLikeDaoImpl implements BoardLikeDao {

  SqlSessionFactory sqlSessionFactory;

  public BoardLikeDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<BoardLike> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardLikeDao.findAll", keyword);
    }
  }

  @Override
  public BoardLike findByRecipeNo(int recipeNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("BoardLikeDao.findByRecipeNo", recipeNo);
    }
  }

  @Override
  public int countBoardLike(BoardLike boardLike) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("BoardLikeDao.countBoardLike", boardLike);
    }
  }

  @Override
  public int deleteByRecipeNo(int recipeNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("BoardLikeDao.deleteByRecipeNo", recipeNo);
    }
  }
}


