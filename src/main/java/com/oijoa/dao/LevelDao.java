package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Level;

public interface LevelDao {
  List<Level> findAll(String keyword) throws Exception;
}








