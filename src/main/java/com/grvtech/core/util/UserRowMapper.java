package com.grvtech.core.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import com.grvtech.core.model.administration.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet row, int rowNum) throws SQLException {
		User user = new User();
		user.setIduser(row.getInt("iduser"));
		user.setUuiduser(UUID.fromString(row.getString("uuiduser")));
		user.setUuidperson(UUID.fromString(row.getString("uuidperson")));
		user.setUsername(row.getString("username"));
		user.setPassword(row.getString("password"));
		user.setEmail(row.getString("email"));
		user.setLogo(row.getBlob("logo").toString());
		user.setSecurityimage(row.getBlob("securityimage").toString());
		user.setPin(row.getString("pin"));
		return user;
	}

}
