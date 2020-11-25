package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Follow;

public interface FollowDao {
  List<Follow> findAll(String keyword) throws Exception;
}








