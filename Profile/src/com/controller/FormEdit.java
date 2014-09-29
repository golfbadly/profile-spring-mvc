package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FormEdit {
	static Logger log = Logger.getLogger(FormEdit.class.getName());

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String formRegister() {
		log.info("FormRegister/ Call edit page.");
		return "edit";
	}

}
