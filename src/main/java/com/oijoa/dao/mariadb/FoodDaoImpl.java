package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.oijoa.dao.FoodDao;
import com.oijoa.domain.Food;

@Repository
public class FoodDaoImpl implements FoodDao {

  SqlSessionFactory sqlSessionFactory;

  public FoodDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Food> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("FoodDao.findAll", keyword);
    }

  }

  @Override
  public List<Food> findByRecipeNo(int recipeNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("FoodDao.findByRecipeNo", recipeNo);
    }
  }
}
