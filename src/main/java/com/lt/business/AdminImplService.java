package com.lt.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jvnet.hk2.annotations.Service;

import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.AdminDAOInterface;
import com.lt.bean.Admin;
import com.lt.bean.Course;
import net.minidev.json.JSONArray;

@Service
public class AdminImplService implements AdminInterface {

	private static Logger logger = Logger.getLogger(AdminImplService.class);
	AdminDAOInterface adminDAO = new AdminDAOImpl();

	public void addProfessor() {
		// TODO Auto-generated method stub

	}

	public boolean approveStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	public void generateReportCard() {
		// TODO Auto-generated method stub

	}

	public void dropCourse() {

	}

	public List<Course> publishResult() throws IOException {
		return null;
	}

	@Override
	public String fetchAdmin(Admin admin) {
		List<Admin> adminList = new ArrayList<>();
		System.out.println("json");
		adminList = adminDAO.fetchAdmin(admin);
		String jsonStr = JSONArray.toJSONString(adminList);
		System.out.println("Print json string " + jsonStr);
		return jsonStr;
	}

	@Override
	public boolean createAdmin(Admin admin) {
		System.out.println("json create admin");

		boolean adminCreation1 = false;
		try {
			adminCreation1 = adminDAO.createAdmin(admin);
			if (adminCreation1) {
				logger.info("created ");

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return adminCreation1;

	}

	public String displayAdmins(Admin admin) {
		List<Admin> adminList = new ArrayList<>();
		System.out.println("json");
		adminList = adminDAO.displayAdmins(admin);
		String jsonStr = JSONArray.toJSONString(adminList);
		System.out.println("Print json string " + jsonStr);
		return jsonStr;
	}

}