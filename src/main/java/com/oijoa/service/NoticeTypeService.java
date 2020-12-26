package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.NoticeType;

public interface NoticeTypeService {

  List<NoticeType> list() throws Exception;

  NoticeType get(int noticeTypeNo) throws Exception;

}
