package com.grvtech.core.dao.administration;

import java.util.UUID;

import com.grvtech.core.model.administration.Organization;

public interface IOrganizationDao {
	public Organization getOrganizationByUUID(UUID uuidorganization);
}
