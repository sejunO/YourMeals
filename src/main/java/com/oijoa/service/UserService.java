package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.User;

public interface UserService {

  List<User> list() throws Exception;
  
  List<User> list(String keyword) throws Exception;

  int update(User user) throws Exception;

  int delete(int no) throws Exception;

  User get(int no) throws Exception;

  User get(String email, String password) throws Exception;

  int add(User user) throws Exception;
}
