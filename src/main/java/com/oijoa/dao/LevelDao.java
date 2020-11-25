package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Level;

public interface LevelDao {
  //  int insert(Level level) throws Exception;
  //  int delete(int no) throws Exception;
  //  Level findByNo(int no) throws Exception;
  List<Level> findAll(String keyword) throws Exception;
  //  int update(Level level) throws Exception;
  //  int updateViewCount(int no) throws Exception;
}








