package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Comment;

public interface CommentDao {
  int insert(Comment comment) throws Exception;
  List<Comment> findAll(String keyword) throws Exception;
  List<Comment> findByUserNo(int userNo) throws Exception; // 로그인 넘버 조건으로 조회
  List<Comment> findByRecipeNo(int recipeNo) throws Exception;
  Comment findByNo(int no) throws Exception;
  Comment update(int no) throws Exception;
  int deleteByRecipeNo(int recipeNo) throws Exception;
  
  List<Comment> listAsc(Integer recipeNo) throws Exception;
  void create(Comment comment) throws Exception;
  void update(Comment comment) throws Exception;
  void delete(Integer commentNo) throws Exception;
}
