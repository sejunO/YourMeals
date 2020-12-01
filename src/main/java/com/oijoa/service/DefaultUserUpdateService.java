package com.oijoa.service;

import java.util.List;

import com.oijoa.dao.UserDao;
import com.oijoa.domain.User;

public class DefaultUserUpdateService implements UserService {

  UserDao userDao;

  public DefaultUserUpdateService(UserDao userDao) {
    this.userDao = userDao;
  }

   @Override
   public int delete(int no) throws Exception {
     return userDao.delete(no);
   }
  
  @Override
  public List<User> list() throws Exception {
    return userDao.findAll(null);
  }

    @Override
    public int update(User user) throws Exception {
      return userDao.update(user);
    }

}
