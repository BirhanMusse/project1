package com.revature.service;

import com.revature.dao.ShaneScriptDAO;
import com.revature.dao.ShaneScriptDAOImpl;

public class ShaneScriptServiceImpl implements ShaneScriptService {

	private ShaneScriptDAO ssd = new ShaneScriptDAOImpl();
	
	@Override
	public boolean Employeelogin(String username, String password) {
		return ssd.Employeelogin(username, password);
	}

	@Override
	public boolean isManager(int empid) {
		return false;
	}

	@Override
	public int getIdFromLogin(String username, String password) {
		// TODO Auto-generated method stub
		return ssd.getIdFromLogin(username, password);
	}
	
}