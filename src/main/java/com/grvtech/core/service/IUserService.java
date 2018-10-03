package com.grvtech.core.service;

import java.util.List;

import com.grvtech.core.model.User;

public interface IUserService {
	List<User> getAllUsers();

	User getUserById(int userId);

	boolean addUser(User user);

	void updateUser(User user);

	void deleteUser(int iduser);

	User getUserByUsernamePassword(String user, String pass);

	User getUserByEmailPassword(String email, String pass);
}
