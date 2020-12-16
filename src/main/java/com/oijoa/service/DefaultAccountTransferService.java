package com.oijoa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.AccountTransferDao;
import com.oijoa.domain.AccountTransfer;

@Service
public class DefaultAccountTransferService implements AccountTransferService {

  AccountTransferDao accountTransferDao;

  public DefaultAccountTransferService(AccountTransferDao accountTransferDao) {
    this.accountTransferDao = accountTransferDao;
  }
  // @Override
  // public int delete(int no) throws Exception {
  // return accountTransferDao.delete(no);
  // }
  //
  // @Override
  // public int add(AccountTransfer accountTransfer) throws Exception {
  // return accountTransferDao.insert(accountTransfer);
  // }

  @Override
  public List<AccountTransfer> list() throws Exception {
    return accountTransferDao.findAll(null);
  }
  // @Override
  // public List<AccountTransfer> list(String keyword) throws Exception {
  // return accountTransferDao.findAll(keyword);
  // }
  //
  // @Override
  // public AccountTransfer get(int no) throws Exception {
  // AccountTransfer accountTransfer = accountTransferDao.findByNo(no);
  // if (accountTransfer != null) {
  // accountTransferDao.updateViewCount(no);
  // }
  // return accountTransfer;
  // }
  //
  // @Override
  // public int update(AccountTransfer accountTransfer) throws Exception {
  // return accountTransferDao.update(accountTransfer);
  // }

}
