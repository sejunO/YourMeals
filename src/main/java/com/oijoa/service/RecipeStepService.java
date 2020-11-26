package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.RecipeStep;

public interface RecipeStepService {

  List<RecipeStep> list() throws Exception;
}
