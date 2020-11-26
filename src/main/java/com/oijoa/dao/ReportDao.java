package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Report;

public interface ReportDao {
  List<Report> findAll(String keyword) throws Exception;
}








