//package com.service;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.model.Myprofile;
//import com.model.MyprofileJDBC;
//
//public class AdminService {
//
//	private static ApplicationContext context;
//	static Logger log = Logger.getLogger(AdminService.class.getName());
//
//	public String getDetail(String userName) {
//		context = new ClassPathXmlApplicationContext("Beans.xml");
//		MyprofileJDBC jdbc = (MyprofileJDBC) context.getBean("myProfileJDBC");
//		
//		log.info("AdminService/ Call *form user");
//		
//		List<Myprofile> alluser = jdbc.listUser();
//		
//		for (Myprofile record : alluser) {		
//			record.getID();
//			record.getUserName();
//			record.getPassword();
//			record.getFName();
//			record.getLName();	
//			record.getJob();
//		}
//
//		return null;
//
//	}
//}
