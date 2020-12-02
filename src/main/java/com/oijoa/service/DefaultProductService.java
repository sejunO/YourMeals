package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.ProductDao;
import com.oijoa.domain.Product;

public class DefaultProductService implements ProductService {

  ProductDao productDao;

  public DefaultProductService( ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  public List<Product> list() throws Exception {
    return productDao.findAll(null);
  }

  @Override
  public List<Product> list(String keyword) throws Exception {
    return productDao.findAll(keyword);
  }



}
