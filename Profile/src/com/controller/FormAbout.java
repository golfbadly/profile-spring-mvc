package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.AboutService;

@Controller
public class FormAbout {
	static Logger log = Logger.getLogger(FormAbout.class.getName());

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(HttpServletRequest request, ModelMap model) {

		log.info("FormAbout/ Get session username.");
		HttpSession session = request.getSession(true);
		String userName = (String) session.getAttribute("name");

		AboutService about = new AboutService();
		String aboutuser = about.GetDetail(userName);
		model.addAttribute("about", aboutuser);

		return "p_aboutme";

	}

}
