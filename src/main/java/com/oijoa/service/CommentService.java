package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Comment;

public interface CommentService {
  int add(Comment comment) throws Exception;
  List<Comment> list() throws Exception;
  int deleteByRecipeNo(int recipeNo) throws Exception;
  List<Comment> userNoList(int userNo) throws Exception;
}
