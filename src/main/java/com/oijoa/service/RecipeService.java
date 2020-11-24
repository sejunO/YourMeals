package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Recipe;

public interface RecipeService {

  List<Recipe> list() throws Exception;
}
