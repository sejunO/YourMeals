package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.RecipeStepDao;
import com.oijoa.domain.RecipeStep;

public class RecipeStepDaoImpl implements RecipeStepDao{

  SqlSessionFactory sqlSessionFactory;

  public RecipeStepDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<RecipeStep> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RecipeStepDao.findAll", keyword);
    }
  }
  
  @Override
	public List<RecipeStep> findByRecipeNo(int recipeNo) throws Exception {
	  try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
	      return sqlSession.selectList("RecipeStepDao.findByRecipeNo", recipeNo);
	}
  }
}








