package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Member;

public interface MemberDao {
  List<Member> findAll(String keyword) throws Exception;
}








