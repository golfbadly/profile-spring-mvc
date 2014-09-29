package com.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Myprofile;
import com.model.MyprofileJDBC;

public class LocationService {

	private static ApplicationContext context;
	static Logger log = Logger.getLogger(LocationService.class.getName());
	private String username;
	String location;

	public String GetDetail(String userName) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		MyprofileJDBC jdbc = (MyprofileJDBC) context.getBean("myProfileJDBC");
		this.username = userName;

		log.info("LocationService/ Get location of user");
		try {
			Myprofile mp = jdbc.getProfile(username);
			location = mp.getLocation();

		} catch (Exception e) {
			log.info("LocationService/ Get location Fail!");
		}

		return location;

	}
}
