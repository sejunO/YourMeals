package com.oijoa.dao;

import java.util.List;

import com.oijoa.domain.Comment;

public interface CommentDao {
	int insert(Comment comment) throws Exception;
	List<Comment> findAll(String keyword) throws Exception;
	int deleteByRecipeNo(int recipeNo) throws Exception;
}
