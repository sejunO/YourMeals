package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Comment;

public interface CommentDao {
  List<Comment> findAll(String keyword) throws Exception;
}








