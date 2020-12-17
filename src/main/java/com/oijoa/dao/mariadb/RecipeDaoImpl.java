package com.oijoa.dao.mariadb;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.RecipeDao;
import com.oijoa.domain.Recipe;


public class RecipeDaoImpl implements RecipeDao {

  SqlSessionFactory sqlSessionFactory;

  public RecipeDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Recipe> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RecipeDao.findAll");
    }	
  }
	
	@Override
	public List<Recipe> findRecipeMaterial(int recipeNo) throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("RecipeDao.findRecipeMaterial", recipeNo);
        }
	}
	
	
  @Override
  public List<Recipe> findByKeyword(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RecipeDao.findByKeyword", keyword);
    }
  }

  @Override
  public List<Recipe> findByUserNo(int userNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RecipeDao.findByUserNo", userNo);
    }
  }

  @Override
  public List<Recipe> findByLike(int userNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RecipeDao.findByLike", userNo);
    }
  }

  @Override
  public List<Recipe> findByDetailKeyword(Map<String, Object> map) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RecipeDao.findByDetailKeyword", map);
    }
  }

  @Override
  public Recipe findByRecipeNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("RecipeDao.findByRecipeNo", no);
    }
  }

	@Override
	public int insert(Recipe recipe) throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.insert("RecipeDao.insert", recipe);
		}
	}


  @Override
  public int insertCategory(Recipe recipe) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("RecipeDao.insertCategory", recipe);
    }
  }

  @Override
  public int update(Recipe recipe) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("RecipeDao.update", recipe);
    }
  }
  
  @Override
	public int updateCategory(Recipe recipe) throws Exception {
	  try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
	      return sqlSession.update("RecipeDao.updateCategory", recipe);
	  }
	}


  @Override
  public int updateViewCount(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("RecipeDao.updateViewCount", no);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("RecipeDao.delete", no);
    }
  }

  @Override
  public int deleteRecipeCategory(int recipeNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("RecipeDao.deleteRecipeCategory", recipeNo);
    }
  }

  @Override
  public int deleteRecipeMaterial(int recipeNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("RecipeDao.deleteRecipeMaterial", recipeNo);
    }
  }

}
