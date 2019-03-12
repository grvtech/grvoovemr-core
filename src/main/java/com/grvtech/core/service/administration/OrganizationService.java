package com.grvtech.core.service.administration;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		return odao.getOrganizationByUUID(uuidorganization);
	}

	@Override
	public boolean hasValidLicence(Organization organisation) {
		boolean result = false;
		Date lwe = organisation.getLwe();
		Date lws = organisation.getLws();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println("-------------------------------------------");
		System.out.println("- now :" + sdf.format(now));
		System.out.println("- lwe :" + sdf.format(lwe));
		System.out.println("- lws :" + sdf.format(lws));
		System.out.println("-------------------------------------------");

		if (now.after(lws) && now.before(lwe)) {
			System.out.println("-------------------------------------------");
			System.out.println("- now is a valid date ");
			System.out.println("-------------------------------------------");
			result = true;
		}
		return result;
	}

}
