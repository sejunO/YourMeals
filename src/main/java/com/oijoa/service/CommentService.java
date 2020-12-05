package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Comment;
import com.oijoa.domain.User;

public interface CommentService {
	int add(Comment comment) throws Exception;
	List<Comment> list() throws Exception;
	int deleteByRecipeNo(int recipeNo) throws Exception;
	Comment list(User user) throws Exception;
}
