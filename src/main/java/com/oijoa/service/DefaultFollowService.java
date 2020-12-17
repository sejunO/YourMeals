package com.oijoa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.FollowDao;
import com.oijoa.domain.Follow;

@Service
public class DefaultFollowService implements FollowService {

  FollowDao followDao;

  public DefaultFollowService(FollowDao followDao) {
    this.followDao = followDao;
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
  public List<Follow> list() throws Exception {
    return followDao.findAll(null);
  }

  @Override
  public List<Follow> FollowerList(int UserNo) throws Exception {
    return followDao.FollowerList(UserNo);
  }

  @Override
  public List<Follow> FollowingList(int UserNo) throws Exception {
    // TODO Auto-generated method stub
    return followDao.FollowingList(UserNo);
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
