package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.KakaoPay;

public interface KakaoPayDao {
  List<KakaoPay> findAll(String keyword) throws Exception;
}








