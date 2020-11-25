package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.KakaoPayDao;
import com.oijoa.domain.KakaoPay;

public class DefaultKakaoPayService implements KakaoPayService{

  KakaoPayDao kakaoPayDao;

  public DefaultKakaoPayService(KakaoPayDao kakaoPayDao) {
    this.kakaoPayDao = kakaoPayDao;
  }

  //  @Override
  //  public int delete(int no) throws Exception {
  //    return boardDao.delete(no);
  //  }
  //
  //  @Override
  //  public int add(Board board) throws Exception {
  //    return boardDao.insert(board);
  //  }
  //
  @Override
  public List<KakaoPay> list() throws Exception {
    return kakaoPayDao.findAll(null);
  }

  //  @Override
  //  public List<Order> list(String keyword) throws Exception {
  //    return orderDao.findAll(keyword);
  //  }
  //
  //  @Override
  //  public Board get(int no) throws Exception {
  //    Board board = boardDao.findByNo(no);
  //    if (board != null) {
  //      boardDao.updateViewCount(no);
  //    }
  //    return board;
  //  }
  //
  //  @Override
  //  public int update(Board board) throws Exception {
  //    return boardDao.update(board);
  //  }

}
