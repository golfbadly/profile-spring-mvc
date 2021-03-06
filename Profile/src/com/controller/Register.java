package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.RegisterService;

@Controller
public class Register {

	static Logger log = Logger.getLogger(Register.class.getName());

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		

		PrintWriter out = response.getWriter();

		String Name = request.getParameter("name");
		String Last = request.getParameter("last");
		String Id = request.getParameter("userid");
		String Pass = request.getParameter("password");
		String About = request.getParameter("about");
		String Location = request.getParameter("location");
		String Contact = request.getParameter("contact");
		String Education = request.getParameter("education");

		log.info("Register Ckeck.");
		
		if (Name.equals("") || Last.equals("") || Id.equals("")
				|| Pass.equals("")) {
			out.print("<script>alert('Register fail!');"
					+ "window.location.href='/Profile/register';</script>");
		} else {
			RegisterService regis = new RegisterService();
			if (regis.register(Name, Last, Id, Pass, About, Location, Contact,
					Education)) {
				out.println("<script>alert('Register Complete!');"
						+ "window.location.href='/Profile/';</script>");
			} else {
				out.println("<script>alert('Please choose a different username!');"
						+ "window.location.href='/Profile/register';</script>");
			}
		}

		return null;

	}

}
