/*package com.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.MyprofileJDBC;

public class MainApp {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		MyprofileJDBC jdbc = (MyprofileJDBC) context.getBean("myProfileJDBC");

		List<Myprofile> alluser = jdbc.listUser();

		for (Myprofile record : alluser) {

			int id = record.getID();
			String fname = record.getFName();
			String lname = record.getLName();
			String about = record.getAbout();
			String location = record.getLocation();
			String contact = record.getContact();
			String education = record.getEducation();
			String job = record.getJob();

			System.out.println(id + " " + fname + " " + lname + " " + about
					+ " " + location + " " + contact + " " + education + " "
					+ job);

		}

	}
}
*/