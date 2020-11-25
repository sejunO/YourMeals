package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Payment;

public interface PaymentService {

  List<Payment> list(String keyword) throws Exception;

}
