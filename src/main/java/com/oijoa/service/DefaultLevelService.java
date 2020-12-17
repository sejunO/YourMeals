package com.oijoa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.LevelDao;
import com.oijoa.domain.Level;

@Service
public class DefaultLevelService implements LevelService {

  LevelDao levelDao;

  public DefaultLevelService(LevelDao levelDao) {
    this.levelDao = levelDao;
  }

  // @Override
  // public int delete(int no) throws Exception {
  // return boardDao.delete(no);
  // }
  //
  // @Override
  // public int add(Board board) throws Exception {
  // return boardDao.insert(board);
  // }
  //
  @Override
  public List<Level> list() throws Exception {
    return levelDao.findAll(null);
  }

  // @Override
  // public List<Order> list(String keyword) throws Exception {
  // return orderDao.findAll(keyword);
  // }
  //
  // @Override
  // public Board get(int no) throws Exception {
  // Board board = boardDao.findByNo(no);
  // if (board != null) {
  // boardDao.updateViewCount(no);
  // }
  // return board;
  // }
  //
  // @Override
  // public int update(Board board) throws Exception {
  // return boardDao.update(board);
  // }

}
