package com.grvtech.core.model.administration;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.grvtech.core.model.clinical.ClinicalCategories;

public class Application {
	private int idapplication;
	private UUID uuidapplication;
	private UUID uuidorganisation;
	private String licence;
	private Date lws;
	private Date lwe;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;
	private ArrayList<ClinicalCategories> categories;

}
