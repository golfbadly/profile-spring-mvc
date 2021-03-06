package com.model;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyprofileJDBC implements MyprofileDOA {

	private JdbcTemplate jdbcTemplateObject;
	static Logger log = Logger.getLogger(MyprofileJDBC.class.getName());
	private Myprofile myProfile;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	public void create(String username, String password, String f_name,
			String l_name, String about, String location, String contact,
			String education) {

		String SQL = "insert into user (username, password, f_name, "
				+ "l_name, about, location, contact, education)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, username, password, f_name, l_name,
				about, location, contact, education);
		log.info("Created new profile " + username + " complete.");
		return;
	}

	public Myprofile getProfile(String username) {

		String SQL = "select * from user where username = ?";
		myProfile = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { username }, new MyprofileMapper());
		log.info("Get Profile with username = " + username);
		return myProfile;
	}

	public List<Myprofile> listUser() {
		String SQL = "select * from user";
		List<Myprofile> myProfile = jdbcTemplateObject.query(SQL,
				new MyprofileMapper());
		log.info("Get List User");
		return myProfile;
	}

	public void delete(Integer id) {
		String SQL = "delete from user where id = ?";
		jdbcTemplateObject.update(SQL, id);
		log.info("Deleted Record with ID = " + id);
		return;
	}

	public void updateJob(String tmp, String job) {
		String SQL = "update user set job = ? where id = ?";
		jdbcTemplateObject.update(SQL, job, tmp);
		log.info("Updated Record with ID = " + tmp);
		return;
	}

	public void updateDetail(String username, String about, String location,
			String contact, String education) {
		String SQL1 = "update user set about = ? where username = ?";
		String SQL2 = "update user set location = ? where username = ?";
		String SQL3 = "update user set contact = ? where username = ?";
		String SQL4 = "update user set education = ? where username = ?";

		jdbcTemplateObject.update(SQL1, about, username);
		jdbcTemplateObject.update(SQL2, location, username);
		jdbcTemplateObject.update(SQL3, contact, username);
		jdbcTemplateObject.update(SQL4, education, username);

		log.info("Updated Record with Username = " + username);
		return;
	}

	public Myprofile loginValidate(String username, String password) {

		String SQL = "select * from user where username=? and password=?";
		myProfile = jdbcTemplateObject.queryForObject(SQL, new Object[] {
				username, password }, new MyprofileMapper());

		log.info("Login Record with username = " + username);
		return myProfile;
	}

	public Myprofile getName(String username) {

		String SQL = "select f_name from user where username = ?";
		myProfile = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { username }, new MyprofileMapper());
		log.info("Get name with username = " + username);
		return myProfile;
	}

}
