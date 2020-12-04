package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Follow;

public interface FollowDao {
  List<Follow> findAll(String keyword) throws Exception;
  List<Follow> FollowerList(int UserNo) throws Exception;
  List<Follow> FollowingList(int UserNo) throws Exception;
}








