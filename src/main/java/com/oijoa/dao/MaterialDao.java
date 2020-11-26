package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Material;

public interface MaterialDao {
  List<Material> findAll(String keyword) throws Exception;
}








