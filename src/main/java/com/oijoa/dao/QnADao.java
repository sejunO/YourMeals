package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Qna;

public interface QnADao {
  List<Qna> findAll(String keyword) throws Exception;
  Qna findByNo(int no) throws Exception;
}
