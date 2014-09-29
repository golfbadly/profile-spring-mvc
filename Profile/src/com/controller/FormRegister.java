package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FormRegister {
	static Logger log = Logger.getLogger(FormRegister.class.getName());

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String formRegister() {
		log.info("FormRegister/ Call register page.");
		return "register";
	}

}
