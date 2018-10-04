package com.grvtech.core.modules.trace.model;

import java.util.Date;
import java.util.UUID;

public class Event {
	private int idevent;
	private UUID uuidsession; // reference in the application
	private UUID uuidapplication;
	private UUID uuiduser;
	private UUID uuidaction;
	private Date created;
}

/*
 * Session from 1 to 5 session id user id
 * 
 * session event login add data delete data modify data consult data
 * 
 * action add data : insert update delete select id data id table idevenet
 * 
 * examples
 * 
 * login success = select user iduser
 * 
 * login fail = select user data
 * 
 * 
 * add patient = insert person, patient, idperson idpatient modify patient =
 * update person id person modify patient = update patient id patient modify
 * patient update person patient id person, patient
 * 
 * 
 * 
 * 
 */
