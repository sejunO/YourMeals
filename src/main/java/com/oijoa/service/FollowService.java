package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Follow;

public interface FollowService {

  List<Follow> list() throws Exception;
  List<Follow> myFollowerList(int loginUserNo) throws Exception;
  List<Follow> myFollowingList(int loginUserNo) throws Exception;

}
