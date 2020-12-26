package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.NoticeDao;
import com.oijoa.domain.Notice;
import com.oijoa.service.NoticeService;

@Service
public class DefaultNoticeService implements NoticeService {

  NoticeDao noticeDao;

  public DefaultNoticeService(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
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
  public List<Notice> list() throws Exception {
    return noticeDao.findAll(null);
  }

  @Override
  public int add(Notice notice) throws Exception {
    return noticeDao.insert(notice);
  }
  
  // @Override
  // public List<Order> list(String keyword) throws Exception {
  // return orderDao.findAll(keyword);
  // }
  //
 @Override
	public Notice get(int noticeNo) throws Exception {
	 return noticeDao.findByNoticeNo(noticeNo);
	}
  //
  // @Override
  // public int update(Board board) throws Exception {
  // return boardDao.update(board);
  // }

}
