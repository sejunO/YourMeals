package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.BasketDao;
import com.oijoa.domain.Basket;
import com.oijoa.service.BasketService;

@Service
public class DefaultBasketService implements BasketService {

  BasketDao basketDao;

  public DefaultBasketService(BasketDao basketDao) {
    this.basketDao = basketDao;
  }

  // @Override
  // public int delete(int no) throws Exception {
  // return boardDao.delete(no);
  // }
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

  @Override
  public int delete(int no) throws Exception {
    return basketDao.delete(no);
  }


}
