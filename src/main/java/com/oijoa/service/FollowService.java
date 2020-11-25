package com.oijoa.service;

import java.util.List;
import com.oijoa.domain.Follow;

public interface FollowService {

  List<Follow> list() throws Exception;

}
