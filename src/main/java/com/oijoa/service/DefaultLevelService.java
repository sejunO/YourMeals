package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.LevelDao;
import com.oijoa.domain.Level;

public class DefaultLevelService implements LevelService {

  LevelDao levelDao;

  public DefaultLevelService(LevelDao levelDao) {
    this.levelDao = levelDao;
  }

  //  @Override
  //  public int delete(int no) throws Exception {
  //    return levelDao.delete(no);
  //  }
  //
  //  @Override
  //  public int add(Level level) throws Exception {
  //    return levelDao.insert(level);
  //  }

  @Override
  public List<Level> list() throws Exception {
    return levelDao.findAll(null);
  }
  //
  //  @Override
  //  public List<Level> list(String keyword) throws Exception {
  //    return levelDao.findAll(keyword);
  //  }
  //
  //  @Override
  //  public Level get(int no) throws Exception {
  //    Level level = levelDao.findByNo(no);
  //    if (level != null) {
  //      levelDao.updateViewCount(no);
  //    }
  //    return level;
  //  }
  //
  //  @Override
  //  public int update(Level level) throws Exception {
  //    return levelDao.update(level);
  //  }

}
