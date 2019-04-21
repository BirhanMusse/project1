package com.revature.main;

import com.revature.beans.Employee;
import com.revature.dao.ShaneScriptDAO;
import com.revature.dao.ShaneScriptDAOImpl;
import com.revature.service.ShaneScriptService;
import com.revature.service.ShaneScriptServiceImpl;

public class Driver {
	
	
	public static void main(String[] args) {
		ShaneScriptDAO ssd = new ShaneScriptDAOImpl();
	 ShaneScriptService s = new ShaneScriptServiceImpl();

		
		String user="BIRHANM";
		String pass="BIRHANM";
		
		Employee emp = ssd.getEmployee(2001);
		System.out.println(s.Employeelogin(user, pass));
		System.out.println(ssd.Employeelogin(user, pass));
		System.out.println(ssd.getIdFromLogin(user, pass));
	}

}
