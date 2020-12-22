package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Product;

public interface ProductService {

  List<Product> list(String keyword) throws Exception;

  List<Product> list() throws Exception;

  int add(Product product);

  int get(int no);
}
