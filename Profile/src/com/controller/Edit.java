package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.EditService;

@Controller
public class Edit {

	static Logger log = Logger.getLogger(Edit.class.getName());

	@RequestMapping(value = "/Edit", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(true);
		String userName = (String) session.getAttribute("name");

		String About = request.getParameter("about");
		String Location = request.getParameter("location");
		String Contact = request.getParameter("contact");
		String Education = request.getParameter("education");

		log.info("Edit Check.");
		EditService edit = new EditService();
		if (edit.edit(userName, About, Location, Contact, Education)) {
			out.println("<script>alert('Edit Complete!');"
					+ "window.location.href='/Profile/menu';</script>");
		} else {
			out.println("<script>alert('Edit Fail!');"
					+ "window.location.href='/Profile/edit';</script>");
		}
		return null;

	}
}