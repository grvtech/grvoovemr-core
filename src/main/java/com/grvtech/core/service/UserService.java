package com.grvtech.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grvtech.core.dao.IUserDao;
import com.grvtech.core.model.administration.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userdao;

	@Override
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

	@Override
	public User getUserById(int userId) {
		return userdao.getUserById(userId);
	}

	@Override
	public User getUserByUsernamePassword(String user, String pass) {
		return userdao.getUserByUsernamePassword(user, pass);
	}

	@Override
	public User getUserByEmailPassword(String email, String pass) {
		return userdao.getUserByEmailPassword(email, pass);
	}
	@Override
	public boolean addUser(User user) {

		if (userdao.userExists(user.getUsername(), user.getPassword())) {
			return false;
		} else {
			userdao.addUser(user);
			return true;
		}

	}

	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
	}

	@Override
	public void deleteUser(int iduser) {
		userdao.deleteUser(iduser);
	}

}
