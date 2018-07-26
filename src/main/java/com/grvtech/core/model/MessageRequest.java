package com.grvtech.core.model;

import java.util.ArrayList;
import java.util.UUID;

public class MessageRequest {
	private UUID uuidevent;
	private UUID uuidorganization;
	private UUID uuidsession;
	private String state; /* clear|enc */
	private ArrayList<Object> elements;

}
