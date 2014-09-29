package com.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Myprofile;
import com.model.MyprofileJDBC;

public class AboutService {

	private static ApplicationContext context;
	static Logger log = Logger.getLogger(AboutService.class.getName());
	private String username;
	String about;

	public String GetDetail(String userName) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		MyprofileJDBC jdbc = (MyprofileJDBC) context.getBean("myProfileJDBC");
		this.username = userName;

		log.info("AboutService/ Get about of user");
		try {
			Myprofile mp = jdbc.getProfile(username);
			about = mp.getAbout();

		} catch (Exception e) {
			log.info("MenuService/ Get about Fail!");
		}

		return about;

	}
}
