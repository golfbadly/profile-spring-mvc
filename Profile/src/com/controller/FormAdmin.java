//package com.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.model.Myprofile;
//import com.model.MyprofileJDBC;
//
//@Controller
//public class FormAdmin {
//
//	static Logger log = Logger.getLogger(FormAdmin.class.getName());
//	private static ApplicationContext context;
//
//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	public String list(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//		context = new ClassPathXmlApplicationContext("Beans.xml");
//		MyprofileJDBC jdbc = (MyprofileJDBC) context.getBean("myProfileJDBC");
//		
//		log.info("FormAdmin/ Set all data.");
//
//		List<Myprofile> alluser = jdbc.listUser();
//
//		ModelMap modelMap = new ModelMap();
//		modelMap.addAttribute("userList", alluser);
//		
//		log.info("FormAdmin/ Call admin page.");
//		
//		return "admin";
//
//	}
//
//}
