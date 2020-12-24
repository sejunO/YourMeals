package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Follow;

public interface FollowService {

  List<Follow> list() throws Exception;
  List<Follow> FollowerList(int UserNo) throws Exception;
  List<Follow> FollowingList(int UserNo) throws Exception;
  int follow(Follow Users);

}
