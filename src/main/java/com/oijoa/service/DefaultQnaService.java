package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.QnADao;
import com.oijoa.domain.Qna;

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

  //  @Override
  //  public List<Order> list(String keyword) throws Exception {
  //    return orderDao.findAll(keyword);
  //  }
  //
  @Override
  public Qna get(int no) throws Exception {
    //Qna qna = qnaDao.findByNo(no);
    //    if (qna != null) {
    //      qnaDao.updateViewCount(no);
    //    }
    return qnaDao.findByNo(no);
  }
  //
  @Override
  public int update(Qna qna) throws Exception {
    return qnaDao.update(qna);
  }
}
