package com.print.service;

import com.print.model.User;

public interface UserService {
	public User getUserById(int id);
	public User getUserByName(String name);
	public int addUser(User user);
	public int updateUserPwdByName(User user);
	
}
