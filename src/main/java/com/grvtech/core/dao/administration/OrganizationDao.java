package com.grvtech.core.dao.administration;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.grvtech.core.model.administration.Organization;

public class OrganizationDao implements IOrganizationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Organization getOrganizationByUUID(UUID uuidorganization) {
		Organization result = new Organization();
		String sql = "select * from grvemr.organization where uuidorganization = '" + uuidorganization.toString() + "'";
		List<Organization> orgs = jdbcTemplate.query(sql, new OrganizationMapper());
		if (orgs.size() > 0) {
			result = orgs.get(0);
		}
		return result;
	}

}
