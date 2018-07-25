package com.grvtech.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grvtech.core.model.User;
import com.grvtech.core.model.UserRowMapper;

@Transactional
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUserById(int UserId) {
		String sql = "SELECT * FROM grv_user WHERE iduser = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User User = jdbcTemplate.queryForObject(sql, rowMapper, UserId);
		return User;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM grv_user";
		// RowMapper<User> rowMapper = new
		// BeanPropertyRowMapper<User>(User.class);
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void addUser(User User) {
		// Add User
		String sql = "INSERT INTO grv_user (uuiduser,uuidperson,username,password,email,logo,securityimage, pin) values (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, User.getUuiduser().toString(), User.getUuidperson().toString(), User.getUsername(),
				User.getPassword(), User.getEmail(), User.getLogo(), User.getSecurityimage(), User.getPin());

		// Fetch User id
		sql = "SELECT iduser FROM grv_user WHERE username = ? and password=?";
		int UserId = jdbcTemplate.queryForObject(sql, Integer.class, User.getUsername(), User.getPassword());

		// Set User id
		User.setIduser(UserId);
	}

	@Override
	public void updateUser(User User) {
		String sql = "UPDATE grv_user SET username=?, password=?, email=?, logo=?, securityimage = ?, pin=? WHERE iduser=?";
		jdbcTemplate.update(sql, User.getUsername(), User.getPassword(), User.getEmail(), User.getLogo(),
				User.getSecurityimage(), User.getPin(), User.getIduser());
	}

	@Override
	public void deleteUser(int UserId) {
		String sql = "DELETE FROM grv_user WHERE iduser=?";
		jdbcTemplate.update(sql, UserId);
	}

	@Override
	public boolean userExists(String username, String password) {
		String sql = "SELECT count(*) FROM grv_user WHERE username = ? and password=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

}
