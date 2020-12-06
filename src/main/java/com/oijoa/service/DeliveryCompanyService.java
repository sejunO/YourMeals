package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.DeliveryCompany;

public interface DeliveryCompanyService {

  List<DeliveryCompany> list() throws Exception;

  DeliveryCompany get(int no) throws Exception;
}
