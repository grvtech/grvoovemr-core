package com.grvtech.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class MessageRequest implements Serializable {
	private static final long serialVersionUID = 89266137555650743L;
	private UUID uuidorganization;
	private UUID uuidsession;
	private UUID uuidevent;
	private String state; /* clear|enc */
	private ArrayList<Object> elements;

}
