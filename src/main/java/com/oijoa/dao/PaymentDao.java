package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Payment;

public interface PaymentDao {
  List<Payment> findAll(String keyword) throws Exception;
}








