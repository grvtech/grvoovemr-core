package com.grvtech.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grvtech.core.model.administration.User;
import com.grvtech.core.util.UserRowMapper;

@Transactional
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUserById(int UserId) {
		String sql = "SELECT * FROM user WHERE iduser = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User User = jdbcTemplate.queryForObject(sql, rowMapper, UserId);
		return User;
	}

	@Override
	public User getUserByUsernamePassword(String user, String pass) {
		String sql = "SELECT * FROM user WHERE username = '" + user + "' and password= '" + pass + "'";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		// User User = jdbcTemplate. .queryForObject(sql, rowMapper, user,
		// pass);
		System.out.println("get user from db sql : " + sql);
		List<User> users = jdbcTemplate.query(sql, rowMapper);
		User u = new User();
		System.out.println("get user from db!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		if (users.size() > 0) {
			System.out.println("user found in db!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			u = users.get(0);
		}
		return u;
	}

	@Override
	public User getUserByEmailPassword(String email, String pass) {
		String sql = "SELECT * FROM user WHERE email = ? and password=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		// User User = jdbcTemplate.queryForObject(sql, rowMapper, email, pass);
		List users = jdbcTemplate.query(sql, rowMapper, email, pass);
		User u = new User();
		if (users.size() > 0) {
			u = (User) users.get(0);
		}
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM user";
		// RowMapper<User> rowMapper = new
		// BeanPropertyRowMapper<User>(User.class);
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void addUser(User User) {
		// Add User
		String sql = "INSERT INTO user (uuiduser,uuidperson,username,password,email,logo,securityimage, pin) values (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, User.getUuiduser().toString(), User.getUuidperson().toString(), User.getUsername(), User.getPassword(), User.getEmail(), User.getLogo(), User.getSecurityimage(), User
				.getPin());

		// Fetch User id
		sql = "SELECT iduser FROM user WHERE username = ? and password=?";
		int UserId = jdbcTemplate.queryForObject(sql, Integer.class, User.getUsername(), User.getPassword());

		// Set User id
		User.setIduser(UserId);
	}

	@Override
	public void updateUser(User User) {
		String sql = "UPDATE user SET username=?, password=?, email=?, logo=?, securityimage = ?, pin=? WHERE iduser=?";
		jdbcTemplate.update(sql, User.getUsername(), User.getPassword(), User.getEmail(), User.getLogo(), User.getSecurityimage(), User.getPin(), User.getIduser());
	}

	@Override
	public void deleteUser(int UserId) {
		String sql = "DELETE FROM user WHERE iduser=?";
		jdbcTemplate.update(sql, UserId);
	}

	@Override
	public boolean userExists(String username, String password) {
		String sql = "SELECT count(*) FROM user WHERE username = ? and password=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

}
