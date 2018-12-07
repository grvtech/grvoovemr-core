package com.grvtech.core.service.administration;

import java.util.UUID;

import com.grvtech.core.model.administration.Organization;

public interface IOrganizationService {

	public Organization getOrganizationByUUID(UUID uuidorganization);
}
