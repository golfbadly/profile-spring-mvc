package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.ContactService;

@Controller
public class FormContact {
	static Logger log = Logger.getLogger(FormContact.class.getName());

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String location(HttpServletRequest request, ModelMap model) {

		log.info("FormContact/ Get session username.");
		HttpSession session = request.getSession(true);
		String userName = (String) session.getAttribute("name");

		ContactService contact = new ContactService();
		String contactuser = contact.GetDetail(userName);
		model.addAttribute("contact", contactuser);

		return "p_contact";

	}

}