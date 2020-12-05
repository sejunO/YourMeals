package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.CommentDao;
import com.oijoa.domain.Comment;
import com.oijoa.domain.User;

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
  public Comment list(User user) throws Exception {
    return commentDao.findByLogno(user);
  }
}
