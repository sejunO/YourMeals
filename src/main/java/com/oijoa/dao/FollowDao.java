package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Follow;
import com.oijoa.domain.User;

public interface FollowDao {
  List<Follow> findAll(String keyword) throws Exception;
  List<User> myFollowerList(int loginUserNo) throws Exception;
}








