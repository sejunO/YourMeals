package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Follow;
import com.oijoa.domain.User;

public interface FollowService {

  List<Follow> list() throws Exception;
  List<User> myFollowerList(int loginUserNo) throws Exception;

}
