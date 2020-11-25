package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.AccountTransfer;

public interface AccountTransferDao {
  //  int insert(AccountTransfer accountTransfer) throws Exception;
  //  int delete(int no) throws Exception;
  //  AccountTransfer findByNo(int no) throws Exception;
  List<AccountTransfer> findAll(String keyword) throws Exception;
  //  int update(AccountTransfer accountTransfer) throws Exception;
  //  int updateViewCount(int no) throws Exception;
}








