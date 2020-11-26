package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.ReportType;

public interface ReportTypeDao {
  List<ReportType> findAll(String keyword) throws Exception;
}








