package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Board;

public interface BoardDao {
  int insert(Board board) throws Exception;
  int delete(int no) throws Exception;
  Board findByNo(int no) throws Exception;
  List<Board> findAll(String keyword) throws Exception;
  int update(Board board) throws Exception;
  int updateViewCount(int no) throws Exception;
}








