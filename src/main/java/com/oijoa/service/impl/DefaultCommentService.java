package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.CommentDao;
import com.oijoa.domain.Comment;
import com.oijoa.service.CommentService;

@Service
public class DefaultCommentService implements CommentService {

  CommentDao commentDao;

  public DefaultCommentService(CommentDao commentDao) {
    this.commentDao = commentDao;
  }

  @Override
  public int deleteByRecipeNo(int recipeNo) throws Exception {
    return commentDao.deleteByRecipeNo(recipeNo);
  }

  @Override
  public int add(Comment comment) throws Exception {
    return commentDao.insert(comment);
  }

  @Override
  public List<Comment> list() throws Exception {
    return commentDao.findAll(null);
  }

  @Override
  public List<Comment> list(int recipeNo) throws Exception {
    return commentDao.findByRecipeNo(recipeNo);
  }

  @Override
  public List<Comment> userNoList(int userNo) throws Exception {
    return commentDao.findByUserNo(userNo);
  }
  
  @Override
	public Comment get(int no) throws Exception {
	  return commentDao.findByNo(no);
	}


}
