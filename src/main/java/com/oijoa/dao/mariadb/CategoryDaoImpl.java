package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.CategoryDao;
import com.oijoa.domain.Category;

public class CategoryDaoImpl implements CategoryDao{

  SqlSessionFactory sqlSessionFactory;

  public CategoryDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Category> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("CategoryDao.findAll", keyword);
    }
  }
}








