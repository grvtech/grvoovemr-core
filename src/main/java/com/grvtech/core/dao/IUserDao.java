package com.grvtech.core.dao;

import java.util.List;

import com.grvtech.core.model.administration.User;

public interface IUserDao {
	List<User> getAllUsers();

	User getUserById(int iduser);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int iduser);

	boolean userExists(String username, String password);

	User getUserByUsernamePassword(String user, String pass);

	User getUserByEmailPassword(String email, String pass);

}
