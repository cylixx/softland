package com.softland.users.dao;

import com.softland.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}