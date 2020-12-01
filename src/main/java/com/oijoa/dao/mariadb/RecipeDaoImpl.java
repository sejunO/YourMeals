package com.oijoa.dao.mariadb;

import java.util.List;
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
	public List<Recipe> findAll(String keyword) throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("RecipeDao.findAll", keyword);
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
	public Recipe findByNo(int no) throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("RecipeDao.findByNo", no);
		}
	}

	@Override
	public int updateViewCount(int no) throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.update("RecipeDao.updateViewCount", no);
		}
	}
}
