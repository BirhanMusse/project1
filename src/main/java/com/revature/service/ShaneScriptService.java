package com.revature.service;


public interface ShaneScriptService {
	public boolean Employeelogin(String username, String password);
	public boolean isManager(int empid);
	public int getIdFromLogin(String username, String password);
}