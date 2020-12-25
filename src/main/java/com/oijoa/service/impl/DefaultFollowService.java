package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.FollowDao;
import com.oijoa.domain.Follow;
import com.oijoa.service.FollowService;

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
    return followDao.findByFollowerUserNo(UserNo);
  }

  @Override
  public List<Follow> FollowingList(int UserNo) throws Exception {
    return followDao.findByFollowingUserNo(UserNo);
  }

  @Override
  public int follow(Follow Users) throws Exception {
    return followDao.insert(Users);
  }

  @Override
  public int unfollow(Follow Users) throws Exception {
    return followDao.delete(Users);
  }
}
