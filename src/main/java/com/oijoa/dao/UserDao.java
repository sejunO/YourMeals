package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.User;

public interface UserDao {
  List<User> findAll(String keyword) throws Exception;
  int update(User user) throws Exception;
  int delete(int no) throws Exception;
  User findByEmailPassword(String email, String password);


}
