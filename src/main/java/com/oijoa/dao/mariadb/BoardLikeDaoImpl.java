package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.BoardLikeDao;
import com.oijoa.domain.BoardLike;

public class BoardLikeDaoImpl implements BoardLikeDao{

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
}








