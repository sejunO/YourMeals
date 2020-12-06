package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.DeliveryCompany;

public interface DeliveryCompanyDao {
  List<DeliveryCompany> findAll(String keyword) throws Exception;

  DeliveryCompany findByNo(int no) throws Exception;
}


