package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.BoardLike;

public interface BoardLikeDao {
  List<BoardLike> findAll(String keyword) throws Exception;
  BoardLike findByRecipeNo(int recipeNo) throws Exception;
  int countBoardLike(BoardLike boardLike) throws Exception;
  int deleteByRecipeNo(int reicpeNo) throws Exception;
}








