package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.User;

public interface UserService {

  List<User> list() throws Exception;
  int update(User user) throws Exception;
  int delete(int no) throws Exception;

}
