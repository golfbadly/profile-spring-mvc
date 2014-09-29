package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.MenuService;

@Controller
public class FormMenu {
	static Logger log = Logger.getLogger(FormMenu.class.getName());

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request, ModelMap model) {

		log.info("FormMenu/ Get session username.");
		HttpSession session = request.getSession(true);
		String userName = (String) session.getAttribute("name");

		MenuService menu = new MenuService();
		String fname = menu.GetDetail(userName);
		model.addAttribute("fname", fname);

		return "p_menu";

	}

}