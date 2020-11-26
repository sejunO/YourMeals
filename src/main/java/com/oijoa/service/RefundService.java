package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Refund;

public interface RefundService {

  List<Refund> list() throws Exception;
}
