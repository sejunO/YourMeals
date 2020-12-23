package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.NoticeTypeDao;
import com.oijoa.domain.NoticeType;
import com.oijoa.service.NoticeTypeService;

@Service
public class DefaultNoticeTypeService implements NoticeTypeService {

  NoticeTypeDao noticeTypeDao;

  public DefaultNoticeTypeService(NoticeTypeDao noticeTypeDao) {
    this.noticeTypeDao = noticeTypeDao;
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
  public List<NoticeType> list() throws Exception {
    return noticeTypeDao.findAll(null);
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
