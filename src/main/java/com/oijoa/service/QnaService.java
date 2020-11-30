package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Qna;

public interface QnaService {
  int add(Qna qna) throws Exception;
  List<Qna> list() throws Exception;
  Qna get(int no) throws Exception;
}
