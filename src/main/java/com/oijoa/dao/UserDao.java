package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.User;

public interface UserDao {
	 List<User> findAll() throws Exception;
	 User findByNo(int no) throws Exception;
	 int update(User user) throws Exception;
	 int delete(int no) throws Exception;



}
