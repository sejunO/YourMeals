package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Basket;

public interface BasketService {

  List<Basket> list() throws Exception;
  int add(Basket basket) throws Exception;
  List<Basket> myList(int loginUserNo) throws Exception;
  Basket get(int no) throws Exception;
  int delete(int no) throws Exception;
}
