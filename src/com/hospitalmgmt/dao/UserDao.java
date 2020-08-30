package com.hospitalmgmt.dao;

import java.util.List;

import com.hospitalmgmt.pojo.User;

public interface UserDao {

	boolean createUser(User user);
	
	boolean updateUser(User user);
	
	boolean deleteUser(String email);
	
	boolean activateUser(String email);
	
	User getUserById(int userId);

	List<User> getAllUsers(boolean status);
	
	//for future references
	
//	User getUserByEmail(User user);
	
	User getUserLogin(User user);
	
}
