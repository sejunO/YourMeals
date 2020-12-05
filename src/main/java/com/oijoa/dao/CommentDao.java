package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Comment;
import com.oijoa.domain.User;

public interface CommentDao {
	int insert(Comment comment) throws Exception;
	List<Comment> findAll(String keyword) throws Exception;
	int deleteByRecipeNo(int recipeNo) throws Exception;
	Comment findByLogno(User user) throws Exception; // 로그인 넘버 조건으로 조회
}
