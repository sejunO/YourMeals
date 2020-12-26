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


  @Override
  public List<NoticeType> list() throws Exception {
    return noticeTypeDao.findAll(null);
  }

  @Override
  public NoticeType get(int noticeTypeNo) throws Exception {
    return noticeTypeDao.findByNo(noticeTypeNo);
  }

}
