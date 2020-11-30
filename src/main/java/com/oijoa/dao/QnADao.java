package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Qna;

public interface QnADao {
  int insert(Qna qna) throws Exception;
  List<Qna> findAll(String keyword) throws Exception;
  Qna findByNo(int no) throws Exception;
}
