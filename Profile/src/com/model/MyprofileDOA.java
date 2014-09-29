package com.model;

import java.util.List;

import javax.sql.DataSource;

public interface MyprofileDOA {
	public void setDataSource(DataSource dataSource);

	public void create(String username, String password, String f_name,
			String l_name, String about, String location, String contact,
			String education);

	public Myprofile getProfile(String username);

	public List<Myprofile> listUser();

	public void delete(Integer id);

	//public void updateJob(Integer id, String job);

	public void updateJob(String tmp, String job);
	
	public void updateDetail(String username, String about, String location,
			String contact, String education);
	
	public Myprofile loginValidate(String username, String password);
	
	public Myprofile getName(String username);


}
