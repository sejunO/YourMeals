package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.BasketDao;
import com.oijoa.domain.Basket;

public class DefaultBasketService implements BasketService {

  BasketDao basketDao;

  public DefaultBasketService(BasketDao basketDao) {
    this.basketDao = basketDao;
  }

  //  @Override
  //  public int delete(int no) throws Exception {
  //    return boardDao.delete(no);
  //  }
  //
  @Override
  public int add(Basket basket) throws Exception {
    return basketDao.insert(basket);
  }

  @Override
  public List<Basket> myList(int loginUserNo) throws Exception {
    return basketDao.findByUserNo(loginUserNo);
  }

  @Override
  public List<Basket> list() throws Exception {
    return basketDao.findAll(null);
  }

  @Override
  public Basket get(int no) throws Exception {
    return basketDao.findByNo(no);
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
