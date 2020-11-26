package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Comment;

public interface CommentService {

  List<Comment> list() throws Exception;

}
