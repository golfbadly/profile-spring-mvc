package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.LocationService;

@Controller
public class FormLocation {
	static Logger log = Logger.getLogger(FormLocation.class.getName());

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String location(HttpServletRequest request, ModelMap model) {

		log.info("FormLocation/ Get session username.");
		HttpSession session = request.getSession(true);
		String userName = (String) session.getAttribute("name");

		LocationService location = new LocationService();
		String locationuser = location.GetDetail(userName);
		model.addAttribute("location", locationuser);

		return "p_where";

	}

}
