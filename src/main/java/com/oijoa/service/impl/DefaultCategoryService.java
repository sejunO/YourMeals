package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.CategoryDao;
import com.oijoa.domain.Category;
import com.oijoa.service.CategoryService;

@Service
public class DefaultCategoryService implements CategoryService {

  CategoryDao categoryDao;

  public DefaultCategoryService(CategoryDao categoryDao) {
    this.categoryDao = categoryDao;
  }

  // @Override
  // public int delete(int no) throws Exception {
  // return boardDao.delete(no);
  // }
  //
  // @Override
  // public int add(Board board) throws Exception {
  // return boardDao.insert(board);
  // }
  //
  @Override
  public List<Category> list() throws Exception {
    return categoryDao.findAll(null);
  }

  @Override
  public Category get(int no) throws Exception {
    return categoryDao.findByNo(no);
  }

  // @Override
  // public List<Order> list(String keyword) throws Exception {
  // return orderDao.findAll(keyword);
  // }
  //
  // @Override
  // public Board get(int no) throws Exception {
  // Board board = boardDao.findByNo(no);
  // if (board != null) {
  // boardDao.updateViewCount(no);
  // }
  // return board;
  // }
  //
  // @Override
  // public int update(Board board) throws Exception {
  // return boardDao.update(board);
  // }

}
