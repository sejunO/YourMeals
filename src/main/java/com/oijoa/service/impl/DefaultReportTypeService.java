package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.ReportTypeDao;
import com.oijoa.domain.ReportType;
import com.oijoa.service.ReportTypeService;

@Service
public class DefaultReportTypeService implements ReportTypeService {

  ReportTypeDao reportTypeDao;

  public DefaultReportTypeService(ReportTypeDao reportTypeDao) {
    this.reportTypeDao = reportTypeDao;
  }

  // @Override
  // public int delete(int no) throws Exception {
  // return boardDao.delete(no);
  // }
  //
  // @Override
  // public int add(Board board) throws Exception {
  // return boardDao.insert(board);
  // }
  //
  @Override
  public List<ReportType> list() throws Exception {
    return reportTypeDao.findAll(null);
  }

  // @Override
  // public List<Order> list(String keyword) throws Exception {
  // return orderDao.findAll(keyword);
  // }
  //
  // @Override
  // public Board get(int no) throws Exception {
  // Board board = boardDao.findByNo(no);
  // if (board != null) {
  // boardDao.updateViewCount(no);
  // }
  // return board;
  // }
  //
  // @Override
  // public int update(Board board) throws Exception {
  // return boardDao.update(board);
  // }

}
