package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.AccountTransferDao;
import com.oijoa.domain.AccountTransfer;

// Mybatis 적용
// => SqlSessionFactory를 자체적으로 생성하지 않고
//    생성자를 통해 외부에서 주입 받는다.(Dependency Injection: DI)
//
public class AccountTransferDaoImpl implements AccountTransferDao{

  SqlSessionFactory sqlSessionFactory;

  public AccountTransferDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  //  @Override
  //  public int insert(AccountTransfer accountTransfer) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.insert("AccountTransferDao.insert", accountTransfer);
  //    }
  //  }
  //
  //  @Override
  //  public int delete(int no) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.delete("AccountTransferDao.delete", no);
  //    }
  //  }
  //
  //  @Override
  //  public AccountTransfer findByNo(int no) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.selectOne("AccountTransferDao.findByNo", no);
  //    }
  //  }
  @Override
  public List<AccountTransfer> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("AccountTransferDao.findAll", keyword);
    }
  }
  //
  //  @Override
  //  public int update(AccountTransfer accountTransfer) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.update("AccountTransfer.update", accountTransfer);
  //    }
  //  }
  //
  //  @Override
  //  public int updateViewCount(int no) throws Exception {
  //    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
  //      return sqlSession.update("AccountTransferDao.updateViewCount", no);
  //    }
  //  }
}








