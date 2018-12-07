package com.grvtech.core.service.administration;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.grvtech.core.dao.administration.IOrganizationDao;
import com.grvtech.core.model.administration.Organization;

public class OrganizationService implements IOrganizationService {

	@Autowired
	IOrganizationDao odao;

	@Override
	public Organization getOrganizationByUUID(UUID uuidorganization) {
		return odao.getOrganizationByUUID(uuidorganization);
	}

}
