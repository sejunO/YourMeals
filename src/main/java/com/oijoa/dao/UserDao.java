package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.User;

public interface UserDao {
	 List<User> findAll(String keyword) throws Exception;



}
