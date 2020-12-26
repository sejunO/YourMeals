package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Notice;

public interface NoticeDao {
  List<Notice> findAll(String keyword) throws Exception;

  int insert(Notice notice) throws Exception;

  Notice findByNo(int no) throws Exception;

  int update(Notice notice) throws Exception;
}


