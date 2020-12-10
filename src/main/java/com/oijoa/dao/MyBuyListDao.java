package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.MyBuyList;

public interface MyBuyListDao {

  List<MyBuyList> findByUnoOno(int userNo);
  
}
