package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Refund;

public interface RefundDao {
  List<Refund> findAll(String keyword) throws Exception;
}








