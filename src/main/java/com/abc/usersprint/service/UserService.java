	package com.abc.usersprint.service;


import com.abc.usersprint.model.Category;
import com.abc.usersprint.model.Details;
import com.abc.usersprint.model.User;

public interface UserService {
	
	public User addUser(User user);
	
	public Details getUserById(int userId);
	
	public void deleteUser(int userId);
	
	public User updateUser(User user);
	
	public User getUserByIdproof(String idProof);
	
	public Category getCategoryDetails(String categoryName);
	
	public User getUserDetails(int userId);

}
