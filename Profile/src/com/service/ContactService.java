package com.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Myprofile;
import com.model.MyprofileJDBC;

public class ContactService {

	private static ApplicationContext context;
	static Logger log = Logger.getLogger(ContactService.class.getName());
	private String username;
	String contact;

	public String GetDetail(String userName) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		MyprofileJDBC jdbc = (MyprofileJDBC) context.getBean("myProfileJDBC");
		this.username = userName;

		log.info("ContactService/ Get contact of user");
		try {
			Myprofile mp = jdbc.getProfile(username);
			contact = mp.getContact();

		} catch (Exception e) {
			log.info("ContactService/ Get contact Fail!");
		}

		return contact;

	}
}
