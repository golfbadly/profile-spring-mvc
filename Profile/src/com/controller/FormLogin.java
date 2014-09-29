package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FormLogin {
	static Logger log = Logger.getLogger(FormLogin.class.getName());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String formLogin() {
		log.info("FormLogin/ Call login page.");
		return "login";
	}

}
