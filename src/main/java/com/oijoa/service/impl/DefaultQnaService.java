package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.QnADao;
import com.oijoa.domain.Qna;
import com.oijoa.service.QnaService;

@Service
public class DefaultQnaService implements QnaService {

  QnADao qnaDao;

  public DefaultQnaService(QnADao qnaDao) {
    this.qnaDao = qnaDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return qnaDao.delete(no);
  }

  @Override
  public int add(Qna qna) throws Exception {
    return qnaDao.insert(qna);
  }

  @Override
  public List<Qna> list() throws Exception {
    return qnaDao.findAll(null);
  }

  // @Override
  // public List<Order> list(String keyword) throws Exception {
  // return orderDao.findAll(keyword);
  // }
  //
  @Override
  public Qna get(int no) throws Exception {
    // Qna qna = qnaDao.findByNo(no);
    // if (qna != null) {
    // qnaDao.updateViewCount(no);
    // }
    return qnaDao.findByNo(no);
  }

  //
  @Override
  public int update(Qna qna) throws Exception {
    return qnaDao.update(qna);
  }

  @Override
  public List<Qna> userNoList(int no) throws Exception {
    return qnaDao.findByUserNo(no);
  }
}
