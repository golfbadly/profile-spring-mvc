package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.EducationService;

@Controller
public class FormEducation {
	static Logger log = Logger.getLogger(FormEducation.class.getName());

	@RequestMapping(value = "/education", method = RequestMethod.GET)
	public String location(HttpServletRequest request, ModelMap model) {

		log.info("FormEducation/ Get session username.");
		HttpSession session = request.getSession(true);
		String userName = (String) session.getAttribute("name");

		EducationService education = new EducationService();
		String educationuser = education.GetDetail(userName);
		model.addAttribute("education", educationuser);

		return "p_education";

	}

}
