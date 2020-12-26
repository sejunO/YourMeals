package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.NoticeType;

public interface NoticeTypeDao {
  List<NoticeType> findAll(String keyword) throws Exception;

  NoticeType findByNo(int noticeTypeNo);
}


