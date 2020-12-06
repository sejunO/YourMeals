package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.MaterialDao;
import com.oijoa.domain.Material;

public class MaterialDaoImpl implements MaterialDao{

  SqlSessionFactory sqlSessionFactory;

  public MaterialDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Material> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("MaterialDao.findAll", keyword);
    }
  }
  
  @Override
	public int insert(int no) throws Exception {
	  try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
	      return sqlSession.insert("MaterialDao.insert", no);
	  }
	}
}








