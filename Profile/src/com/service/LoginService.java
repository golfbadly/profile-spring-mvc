package com.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.controller.Login;
import com.model.Myprofile;
import com.model.MyprofileJDBC;

public class LoginService {
	private static ApplicationContext context;
	static Logger log = Logger.getLogger(Login.class.getName());

	private String username;
	private String password;

	public LoginService() {
		// TODO Auto-generated constructor stub
	}

	public boolean validateLogin(String n, String p) {
		// TODO Auto-generated method stub
		this.username = n;
		this.password = p;

		context = new ClassPathXmlApplicationContext("Beans.xml");
		MyprofileJDBC jdbc = (MyprofileJDBC) context.getBean("myProfileJDBC");

		boolean status = false;

		try {
			log.info("LoginService/ Check");
			Myprofile myProfile = jdbc.loginValidate(username, password);
			if (myProfile != null)
				status = true;

		} catch (Exception e) {
			log.info("LoginService/ Check Fail!");
		}
		return status;
	}

}
