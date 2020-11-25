package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.AccountTransfer;

public interface AccountTransferService {
  //  int delete(int no) throws Exception;
  //  int add(AccountTransfer accountTransfer) throws Exception;
  List<AccountTransfer> list() throws Exception;
  //  List<AccountTransfer> list(String keyword) throws Exception;
  //  AccountTransfer get(int no) throws Exception;
  //  int update(AccountTransfer accountTransfer) throws Exception;
}
