package com.grvtech.core.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DBTool {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DBTool() {
		super();
		// jdbcTemplate =
	}

	public void createTables() {

		String userTableDrop = "DROP TABLE IF EXISTS groovemr_user";
		String userTableCreate = "CREATE TABLE `grv_user` (\n" + "  `iduser` int(11) NOT NULL AUTO_INCREMENT,\n"
				+ "  `uuidperson` varchar(255) DEFAULT NULL,\n" + "  `uuiduser` varchar(255) DEFAULT NULL,\n"
				+ "  `email` varchar(255) NOT NULL,\n" + "  `pin` varchar(10) NOT NULL,\n"
				+ "  `username` varchar(255) NOT NULL,\n" + "  `password` varchar(255) NOT NULL,\n"
				+ "  `logo` blob default NULL,\n" + "  `securityimage` blob default NULL,\n"
				+ "  PRIMARY KEY (`iduser`)\n" + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n" + "";

		jdbcTemplate.execute(userTableDrop);
		jdbcTemplate.execute(userTableCreate);

	}

}
