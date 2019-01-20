CREATE TABLE `action` (
  `idaction` int(11) NOT NULL AUTO_INCREMENT,
  `uuidaction` varchar(50) NOT NULL,
  `uuidapplication` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`idaction`,`uuidapplication`),
  UNIQUE KEY `uuidaction_UNIQUE` (`uuidaction`),
  KEY `fk_grvemr_action_grvemr_application1_idx` (`uuidapplication`),
  CONSTRAINT `fk_grvemr_action_grvemr_application1` FOREIGN KEY (`uuidapplication`) REFERENCES `application` (`uuidapplication`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `application` (
  `idapplication` int(11) NOT NULL AUTO_INCREMENT,
  `uuidapplication` varchar(50) NOT NULL,
  `uuidorganisation` varchar(50) NOT NULL,
  `license` varchar(50) NOT NULL,
  `lws` datetime NOT NULL,
  `lwe` datetime NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idapplication`,`uuidorganisation`),
  UNIQUE KEY `uuidapplication_UNIQUE` (`uuidapplication`),
  KEY `fk_grvemr_application_grvemr_organisation1_idx` (`uuidorganisation`),
  CONSTRAINT `fk_grvemr_application_grvemr_organisation1` FOREIGN KEY (`uuidorganisation`) REFERENCES `organization` (`uuidorganization`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clinical_category` (
  `idclinicalcategory` int(11) NOT NULL AUTO_INCREMENT,
  `uuidclinicalcategory` varchar(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idclinicalcategory`),
  UNIQUE KEY `uuidclinicalcategory_UNIQUE` (`uuidclinicalcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clinical_data` (
  `idclinicaldata` int(11) NOT NULL AUTO_INCREMENT,
  `uuidclinicaldata` varchar(50) NOT NULL,
  `uuidpatient` varchar(50) NOT NULL,
  `uuidclinicalcategory` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `visible` int(1) DEFAULT '1',
  `state` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idclinicaldata`,`uuidpatient`,`uuidclinicalcategory`),
  UNIQUE KEY `uuidclinicaldata_UNIQUE` (`uuidclinicaldata`),
  KEY `fk_grvemr_clinical_data_grvemr_patient1_idx` (`uuidpatient`),
  KEY `fk_grvemr_clinical_data_grvemr_clinical_category1_idx` (`uuidclinicalcategory`),
  CONSTRAINT `fk_grvemr_clinical_data_grvemr_clinical_category1` FOREIGN KEY (`uuidclinicalcategory`) REFERENCES `clinical_category` (`uuidclinicalcategory`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grvemr_clinical_data_grvemr_patient1` FOREIGN KEY (`uuidpatient`) REFERENCES `patient` (`uuidpatient`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `group` (
  `idgroup` int(11) NOT NULL AUTO_INCREMENT,
  `uuidgroup` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idgroup`),
  UNIQUE KEY `uuidgroup_UNIQUE` (`uuidgroup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `group_user` (
  `idgroupuser` int(11) NOT NULL AUTO_INCREMENT,
  `uuidgroupuser` varchar(50) NOT NULL,
  `uuiduser` varchar(50) NOT NULL,
  `uuidgroup` varchar(50) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idgroupuser`,`uuiduser`,`uuidgroup`),
  KEY `fk_grvemr_group_user_grvemr_user1_idx` (`uuiduser`),
  KEY `fk_grvemr_group_user_grvemr_group1_idx` (`uuidgroup`),
  CONSTRAINT `fk_grvemr_group_user_grvemr_group1` FOREIGN KEY (`uuidgroup`) REFERENCES `group` (`uuidgroup`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grvemr_group_user_grvemr_user1` FOREIGN KEY (`uuiduser`) REFERENCES `user` (`uuiduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `organization` (
  `idorganization` int(11) NOT NULL AUTO_INCREMENT,
  `uuidorganization` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `licence` varchar(45) DEFAULT NULL,
  `lws` datetime DEFAULT NULL,
  `lwe` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idorganization`),
  UNIQUE KEY `grvemr_organisationcol_UNIQUE` (`uuidorganization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `patient` (
  `idpatient` int(11) NOT NULL AUTO_INCREMENT,
  `uuidpatient` varchar(50) NOT NULL,
  `uuidperson` varchar(50) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  `active` int(1) DEFAULT NULL,
  `deceased` int(1) DEFAULT NULL,
  PRIMARY KEY (`idpatient`,`uuidperson`),
  UNIQUE KEY `uuidpatient_UNIQUE` (`uuidpatient`),
  KEY `fk_grvemr_patient_grvemr_person1_idx` (`uuidperson`),
  CONSTRAINT `fk_grvemr_patient_grvemr_person1` FOREIGN KEY (`uuidperson`) REFERENCES `person` (`uuidperson`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `idperson` int(11) NOT NULL AUTO_INCREMENT,
  `uuidperson` varchar(50) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idperson`),
  UNIQUE KEY `uuidperson_UNIQUE` (`uuidperson`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `property` (
  `idproperty` int(11) NOT NULL AUTO_INCREMENT,
  `uuidproperty` varchar(50) NOT NULL,
  `uuidpropertytype` varchar(50) NOT NULL,
  `uuidperson` varchar(50) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT '0',
  `visible` int(1) DEFAULT '1',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idproperty`,`uuidperson`,`uuidpropertytype`),
  KEY `fk_grvemr_property_grvemr_person1_idx` (`uuidperson`),
  KEY `fk_grvemr_property_grvemr_property_type1_idx` (`uuidpropertytype`),
  CONSTRAINT `fk_grvemr_property_grvemr_person1` FOREIGN KEY (`uuidperson`) REFERENCES `person` (`uuidperson`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grvemr_property_grvemr_property_type1` FOREIGN KEY (`uuidpropertytype`) REFERENCES `property_type` (`uuidpropertytype`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `property_category` (
  `idpropertycategory` int(11) NOT NULL AUTO_INCREMENT,
  `uuidpropertycategory` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idpropertycategory`),
  UNIQUE KEY `uuidpropertycategory_UNIQUE` (`uuidpropertycategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `property_type` (
  `idpropertytype` int(11) NOT NULL AUTO_INCREMENT,
  `uuidpropertytype` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `uuidpropertycategory` varchar(50) NOT NULL,
  PRIMARY KEY (`idpropertytype`,`uuidpropertycategory`),
  UNIQUE KEY `uuidpropertytype_UNIQUE` (`uuidpropertytype`),
  KEY `fk_grvemr_property_type_grvemr_property_category1_idx` (`uuidpropertycategory`),
  CONSTRAINT `fk_grvemr_property_type_grvemr_property_category1` FOREIGN KEY (`uuidpropertycategory`) REFERENCES `property_category` (`uuidpropertycategory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `idrole` int(11) NOT NULL AUTO_INCREMENT,
  `uuidrole` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idrole`),
  UNIQUE KEY `uuidrole_UNIQUE` (`uuidrole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_action` (
  `idroleaction` int(11) NOT NULL AUTO_INCREMENT,
  `uuidroleaction` varchar(50) NOT NULL,
  `uuidrole` varchar(50) NOT NULL,
  `uuidaction` varchar(50) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idroleaction`,`uuidrole`,`uuidaction`),
  KEY `fk_grvemr_role_action_grvemr_role1_idx` (`uuidrole`),
  KEY `fk_grvemr_role_action_grvemr_action1_idx` (`uuidaction`),
  CONSTRAINT `fk_grvemr_role_action_grvemr_action1` FOREIGN KEY (`uuidaction`) REFERENCES `action` (`uuidaction`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grvemr_role_action_grvemr_role1` FOREIGN KEY (`uuidrole`) REFERENCES `role` (`uuidrole`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_user` (
  `idroleuser` int(11) NOT NULL AUTO_INCREMENT,
  `uuidroleuser` varchar(50) NOT NULL,
  `uuiduser` varchar(50) NOT NULL,
  `uuidrole` varchar(50) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idroleuser`,`uuiduser`),
  KEY `fk_grvemr_role_user_grvemr_role1_idx` (`uuidrole`),
  KEY `fk_grvemr_role_user_grvemr_user1_idx` (`uuiduser`),
  CONSTRAINT `fk_grvemr_role_user_grvemr_role1` FOREIGN KEY (`uuidrole`) REFERENCES `role` (`uuidrole`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grvemr_role_user_grvemr_user1` FOREIGN KEY (`uuiduser`) REFERENCES `user` (`uuiduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `uuiduser` varchar(50) NOT NULL,
  `uuidperson` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `logo` varchar(100) DEFAULT NULL,
  `securityimage` varchar(100) DEFAULT NULL,
  `authmethod` varchar(50) DEFAULT NULL,
  `language` varchar(2) DEFAULT 'en',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `uuiduser_UNIQUE` (`uuiduser`),
  KEY `fk_grvemr_user_grvemr_person_idx` (`uuidperson`),
  CONSTRAINT `fk_grvemr_user_grvemr_person` FOREIGN KEY (`uuidperson`) REFERENCES `person` (`uuidperson`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



/*INSERTS*/


SET @uuidperson = UUID();
insert into person (uuidperson, created,modified,createdby,modifiedby) values (@uuidperson, NOW(), NOW(), NULL,NULL);

SET @uuiduser = UUID();
insert into user (uuiduser,uuidperson,email,pin,username,password,logo,securityimage,authmethod,language,created,modified,createdby,modifiedby)
values (@uuiduser,@uuidperson,'radu@grvtech.com','2407','radu','radu',NULL,NULL,'userpass','en',now(),now(),NULL,NULL);


SET @uuidpcategoryRecord = UUID();
insert into property_category (uuidpropertycategory,name,code,type,created,modified,createdby,modifiedby)
values (@uuidpcategoryRecord, 'Patient Record', 'PREC', 'record',now(), now(),@uuiduser,@uuiduser);

/*possible types in record  : name, address, contact, phisical, family, dates, observations, flags*/

SET @uuidptypeName = UUID();
insert into property_type (uuidpropertytype,name,code,type,uuidpropertycategory)
values (@uuidptypeName, 'Name', 'PRECNAME', 'text',now(), now(),@uuiduser,@uuiduser);

SET @uuidptypeAddress = UUID();
insert into property_type (uuidpropertytype,name,code,type,uuidpropertycategory)
values (@uuidptypeAddress, 'Address', 'PRECADR', 'text',now(), now(),@uuiduser,@uuiduser);

SET @uuidptypeDate = UUID();
insert into property_type (uuidpropertytype,name,code,type,uuidpropertycategory)
values (@uuidptypeDate, 'Date', 'PRECDATE', 'date',now(), now(),@uuiduser,@uuiduser);

SET @uuidptypeContact = UUID();
insert into property_type (uuidpropertytype,name,code,type,uuidpropertycategory)
values (@uuidptypeContact, 'Date', 'PRECDATE', 'text',now(), now(),@uuiduser,@uuiduser);



insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeName, @uuidperson, 'First Name', 'fname','Radu', 1, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeName, @uuidperson, 'Last Name', 'lname','Gabor', 3, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeName, @uuidperson, 'Middle Name', 'mname','Victor', 2, 1, now(), now(), @uuiduser);


insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeAddress, @uuidperson, 'Street', 'street','rue Magloire-Hotte', 2, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeAddress, @uuidperson, 'Number', 'no','2365', 1, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeAddress, @uuidperson, 'Zipcode', 'zip','H7L 0H9', 3, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeAddress, @uuidperson, 'City', 'city','Laval', 4, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeAddress, @uuidperson, 'Province', 'province','Quebec', 5, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeAddress, @uuidperson, 'Contry', 'contry','Canada', 6, 1, now(), now(), @uuiduser);


insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeContact, @uuidperson, 'Home Phone', 'hphone','450-000-0000', 1, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeContact, @uuidperson, 'Email', 'email','radu@videotron.com', 2, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeContact, @uuidperson, 'Facebook', 'facebookuser','radu.gabor.222222', 3, 1, now(), now(), @uuiduser);

insert into property (uuidproperty,uuidpropertytype, uuidperson, name, code, value, order, visible, created, modified, cretedby, modifiedby)
values (UUID(), @uuidptypeDate, @uuidperson, 'Date of birth', 'dob','1974-09-17', 1, 1, now(), now(), @uuiduser);













