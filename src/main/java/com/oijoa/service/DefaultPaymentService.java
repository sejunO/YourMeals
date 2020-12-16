package com.oijoa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.PaymentDao;
import com.oijoa.domain.Payment;

@Service
public class DefaultPaymentService implements PaymentService {

  PaymentDao paymentDao;

  public DefaultPaymentService(PaymentDao paymentDao) {
    this.paymentDao = paymentDao;
  }


  @Override
  public List<Payment> list(String keyword) throws Exception {
    return paymentDao.findAll(keyword);
  }



}
