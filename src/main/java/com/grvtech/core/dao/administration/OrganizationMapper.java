package com.grvtech.core.dao.administration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import com.grvtech.core.model.administration.Organization;

public class OrganizationMapper implements RowMapper<Organization> {
	@Override
	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
		Organization org = new Organization();
		org.setIdorganization(rs.getInt("idorganization"));
		org.setUuidorganization(UUID.fromString(rs.getString("uuidorganization")));
		org.setCodeorganization(rs.getString("code"));
		org.setNameOrganization(rs.getString("name"));
		org.setLicence(rs.getString("licence"));
		org.setLws(rs.getTimestamp("lws"));
		org.setLwe(rs.getTimestamp("lwe"));
		return org;
	}
}
