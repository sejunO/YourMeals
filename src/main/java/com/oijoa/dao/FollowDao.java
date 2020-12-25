package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Follow;

public interface FollowDao {
  List<Follow> findAll(String keyword) throws Exception;
  List<Follow> findByFollowerUserNo(int UserNo) throws Exception;
  List<Follow> findByFollowingUserNo(int UserNo) throws Exception;
  int insert(Follow users) throws Exception;
  int delete(Follow users) throws Exception;
}








