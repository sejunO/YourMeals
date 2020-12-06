package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Material;

public interface MaterialService {

  List<Material> list() throws Exception;
  int add(int no) throws Exception;
}
