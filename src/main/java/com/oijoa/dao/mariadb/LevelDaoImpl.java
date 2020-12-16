package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.oijoa.dao.LevelDao;
import com.oijoa.domain.Level;

@Repository
public class LevelDaoImpl implements LevelDao {

  SqlSessionFactory sqlSessionFactory;

  public LevelDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Level> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("LevelDao.findAll", keyword);
    }
  }
}


