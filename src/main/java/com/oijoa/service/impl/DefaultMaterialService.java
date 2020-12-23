package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.MaterialDao;
import com.oijoa.domain.Material;
import com.oijoa.service.MaterialService;

@Service
public class DefaultMaterialService implements MaterialService {

  MaterialDao materialDao;

  public DefaultMaterialService(MaterialDao materialDao) {
    this.materialDao = materialDao;
  }

  // @Override
  // public int delete(int no) throws Exception {
  // return boardDao.delete(no);
  // }
  //
  @Override
  public int add(int no) throws Exception {
    return materialDao.insert(no);
  }

  @Override
  public List<Material> list() throws Exception {
    return materialDao.findAll(null);
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
