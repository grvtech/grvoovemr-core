package com.grvtech.core.service.administration;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grvtech.core.dao.administration.IOrganizationDao;
import com.grvtech.core.model.administration.Organization;

@Component
public class OrganizationService implements IOrganizationService {

	@Autowired
	IOrganizationDao odao;

	@Override
	public Organization getOrganizationByUUID(UUID uuidorganization) {

		System.out.println("AAAAAAAAAAA");

		return odao.getOrganizationByUUID(uuidorganization);
	}

}
