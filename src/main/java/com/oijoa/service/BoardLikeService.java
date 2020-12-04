package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.BoardLike;

public interface BoardLikeService {

  List<BoardLike> list() throws Exception;
  int deleteByRecipeNo(int recipeNo) throws Exception;

}
