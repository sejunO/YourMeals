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

  @Override
  public int update(Notice notice) throws Exception {
    return noticeDao.update(notice);
  }

  @Override
  public List<Notice> list() throws Exception {
    return noticeDao.findAll(null);
  }

  @Override
  public int add(Notice notice) throws Exception {
    return noticeDao.insert(notice);
  }

  @Override
  public Notice get(int no) throws Exception {
    return noticeDao.findByNo(no);
  }

}
