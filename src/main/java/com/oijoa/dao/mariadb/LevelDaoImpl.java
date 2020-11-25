package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.LevelDao;
import com.oijoa.domain.Level;

// Mybatis 적용
// => SqlSessionFactory를 자체적으로 생성하지 않고
//    생성자를 통해 외부에서 주입 받는다.(Dependency Injection: DI)
//
public class LevelDaoImpl implements LevelDao{

  SqlSessionFactory sqlSessionFactory;

  public LevelDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  //  @Override
  //  public int insert(Level level) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.insert("LevelDao.insert", level);
  //    }
  //  }
  //
  //  @Override
  //  public int delete(int no) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.delete("LevelDao.delete", no);
  //    }
  //  }
  //
  //  @Override
  //  public Level findByNo(int no) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.selectOne("LevelDao.findByNo", no);
  //    }
  //  }

  @Override
  public List<Level> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("LevelDao.findAll", keyword);
    }
  }
  //
  //  @Override
  //  public int update(Level level) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.update("LevelDao.update", level);
  //    }
  //  }
  //
  //  @Override
  //  public int updateViewCount(int no) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.update("LevelDao.updateViewCount", no);
  //    }
  //  }
}








