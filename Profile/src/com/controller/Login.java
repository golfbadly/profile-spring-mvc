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

import com.service.LoginService;

@Controller
public class Login {

	static Logger log = Logger.getLogger(Login.class.getName());

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		log.info("Login Check");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("id");
		String p = request.getParameter("pass");

		if (n.equals("admin") && p.equals("admin")) {

			log.info("Admin login complete.");
	
			return "admin";
		} else {

			HttpSession session = request.getSession(true);
			session.setAttribute("name", n);
			
			log.info("Check User login.");
			LoginService login = new LoginService();
			
			if (login.validateLogin(n, p)) {

				log.info("User login complete.");
				out.println("<script>window.location.href='/Profile/menu';</script>");
				return null;
			} else {
				// out.println("<html><body onload=\"alert('UserID or Password wrong!')\"></body></html>");
				out.println("<script>alert('UserID or Password wrong!');"
						+ "window.location.href='/Profile/';</script>");
				return null;
			}
		}

	}

}