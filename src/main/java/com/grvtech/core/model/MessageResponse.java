package com.grvtech.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class MessageResponse {
	private UUID uuidmessage;
	private int idmessage;
	private String uuisession;
	private String uuidevent;
	private String state;
	private String status;
	private Date timestamp;
	private ArrayList<Object> elements;

}
