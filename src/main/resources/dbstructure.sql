CREATE TABLE `grvemr_person` (
  `idperson` int(11) NOT NULL AUTO_INCREMENT,
  `uuidperson` varchar(50) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idperson`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into grvemr_person (uuidperson, created,modified,createdby,modifiedby) values (UUID(), NOW(), NOW(), NULL,NULL);

CREATE TABLE `grvemr_property` (
  `idproperty` int(11) NOT NULL AUTO_INCREMENT,
  `uuidproperty` varchar(50) NOT NULL,
  `uuidpropertytype` varchar(50) NOT NULL,
  `uuidperson` varchar(50) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT '0',
  `visible` int(1) DEFAULT '1',
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idproperty`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `grvemr_user` (
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
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


insert into grvemr_user (uuiduser,uuidperson,email,pin,username,password,logo,securityimage,authmethod,language,created,modified,createdby,modifiedby)
values (UUID(),(SELECT uuidperson from grvemr_person where idperson=1),'radu@grvtech.com','2407','radu','radu',NULL,NULL,'userpass','en',now(),now(),NULL,NULL);


CREATE TABLE `grvemr_role` (
  `idrole` int(11) NOT NULL AUTO_INCREMENT,
  `uuidrole` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `grvemr_role_user` (
  `idroleuser` int(11) NOT NULL AUTO_INCREMENT,
  `uuidroleuser` varchar(50) NOT NULL,
  `uuiduser` varchar(50) NOT NULL,
  `uuidrole` varchar(50) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idroleuser`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `grvemr_group` (
  `idgroup` int(11) NOT NULL AUTO_INCREMENT,
  `uuidgroup` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idgroup`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `grvemr_group_user` (
  `idgroupuser` int(11) NOT NULL AUTO_INCREMENT,
  `uuidgroupuser` varchar(50) NOT NULL,
  `uuiduser` varchar(50) NOT NULL,
  `uuidgroup` varchar(50) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idgroupuser`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `grvemr_action` (
  `idaction` int(11) NOT NULL AUTO_INCREMENT,
  `uuidaction` varchar(50) NOT NULL,
  `uuidapplication` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`idaction`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `grvemr_role_action` (
  `idroleaction` int(11) NOT NULL AUTO_INCREMENT,
  `uuidroleaction` varchar(50) NOT NULL,
  `uuidrole` varchar(50) NOT NULL,
  `uuidaction` varchar(50) NOT NULL,
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idroleaction`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `grvemr_application` (
  `idapplication` int(11) NOT NULL AUTO_INCREMENT,
  `uuidapplication` varchar(50) NOT NULL,
  `uuidorganisation` varchar(50) NOT NULL,
  `license` varchar(50) NOT NULL,
  `lws` DATETIME NOT NULL,
  `lwe` DATETIME NOT NULL,
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idapplication`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;






