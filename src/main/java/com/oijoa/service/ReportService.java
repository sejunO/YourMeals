package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Report;

public interface ReportService {

  List<Report> list() throws Exception;
}
