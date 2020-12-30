package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Comment;

public interface CommentService {
  int add(Comment comment) throws Exception;
  List<Comment> list() throws Exception;
  List<Comment> list(int recipeNo) throws Exception;
  List<Comment> userNoList(int userNo) throws Exception;
  Comment get(int no) throws Exception;
  //int update(int no) throws Exception;
  int deleteByRecipeNo(int recipeNo) throws Exception;
  
  List<Comment> list(Integer recipeNo) throws Exception;
  void create(Comment comment) throws Exception;
  void update(Comment comment) throws Exception;
  void delete(Integer commentNo) throws Exception;
}
