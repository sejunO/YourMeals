package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.ProductDao;
import com.oijoa.domain.Product;
import com.oijoa.service.ProductService;

@Service
public class DefaultProductService implements ProductService {

  ProductDao productDao;

  public DefaultProductService(ProductDao productDao) {
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

  @Override
  public int add(Product product) {
    return productDao.insert(product);
  }

  @Override
  public Product get(int no) {
    return productDao.findByNo(no);
  }
  @Override
  public int update(Product product) {
    return productDao.update(product);
  }

}
