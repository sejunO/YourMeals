package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.UserDao;
import com.oijoa.domain.User;

public class DefaultUserService implements UserService {

  UserDao userDao;

  public DefaultUserService(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return userDao.delete(no);
  }

  @Override
  public List<User> list() throws Exception {
    return userDao.findAll();
  }

  @Override
  public int update(User user) throws Exception {
    return userDao.update(user);
  }

  @Override
  public User get(int no) throws Exception {
    return userDao.findByNo(no);
  }

  @Override
  public User get(String email, String password) throws Exception {
    return userDao.findByEmailPassword(email, password);
  }
}
