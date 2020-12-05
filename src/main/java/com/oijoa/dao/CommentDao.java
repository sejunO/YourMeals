package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Comment;

public interface CommentDao {
  int insert(Comment comment) throws Exception;
  List<Comment> findAll(String keyword) throws Exception;
  int deleteByRecipeNo(int recipeNo) throws Exception;
  List<Comment> findByUserNo(int userNo) throws Exception; // 로그인 넘버 조건으로 조회
}
