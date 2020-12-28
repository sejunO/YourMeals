package com.oijoa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.oijoa.domain.User;

public interface UserDao {
  User findByEmailPassword(HashMap<String, Object> map);

  List<User> findAll(Map<String,Object> params) throws Exception;

  int count(String keyword) throws Exception;

  User findByNo(int no) throws Exception;

  int update(User user) throws Exception;

  int delete(int no) throws Exception;

  int insert(User user) throws Exception;
}
