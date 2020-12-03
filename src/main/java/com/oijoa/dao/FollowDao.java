package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Follow;

public interface FollowDao {
  List<Follow> findAll(String keyword) throws Exception;
  List<Follow> myFollowerList(int loginUserNo) throws Exception;
  List<Follow> myFollowingList(int loginUserNo) throws Exception;
}








