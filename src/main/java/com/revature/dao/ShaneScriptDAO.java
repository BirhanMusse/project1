package com.revature.dao;

import com.revature.beans.Employee;

public interface ShaneScriptDAO {

	public Employee getEmployee(int empid);
	public boolean Employeelogin(String username, String password);
	public boolean isManager(int empid);
	public int getIdFromLogin(String username, String password);

}
