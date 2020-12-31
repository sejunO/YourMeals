package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.BoardLikeDao;
import com.oijoa.domain.BoardLike;
import com.oijoa.service.BoardLikeService;

@Service
public class DefaultBoardLikeService implements BoardLikeService {

  BoardLikeDao boardLikeDao;

  public DefaultBoardLikeService(BoardLikeDao boardLikeDao) {
    this.boardLikeDao = boardLikeDao;
  }

  @Override
  public int deleteByRecipeNo(int recipeNo) throws Exception {
    return boardLikeDao.deleteByRecipeNo(recipeNo);
  }

  // @Override
  // public int add(Board board) throws Exception {
  // return boardDao.insert(board);
  // }
  //
  @Override
  public List<BoardLike> list() throws Exception {
    return boardLikeDao.findAll(null);
  }
  
  @Override
  public int insert(BoardLike boardLike) throws Exception {
    return boardLikeDao.insert(boardLike);
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
