package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.QnA;

public interface QnADao {
  List<QnA> findAll(String keyword) throws Exception;
}








