package com.grvtech.core.modules.trace.model;

import java.util.Date;
import java.util.UUID;

public class Event {
	private int idevent;
	private UUID uuidsession; // reference in the application
	private UUID uuidaction;
	private Date created;
}

/*
 * Event Definition: what action in what session (meaning between what time and
 * what time for what user) on what time
 * 
 * this record should be stored on db
 * 
 * it does not have an uuid because it is not referenced somewhere else only in
 * DB
 * 
 * 
 * 
 * 
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
