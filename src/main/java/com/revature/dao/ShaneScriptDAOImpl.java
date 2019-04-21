package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class ShaneScriptDAOImpl implements ShaneScriptDAO{

	@Override
	public Employee getEmployee(int empid) {
			Employee emp= new Employee();
			try(Connection con = ConnectionUtil.getConnectionFromFile("//Users//birhan//eclipse-workspace3//birhanproject1//src//main//resources//connection.properties")){
			String query = "SELECT * FROM EMPLOYEE";
			PreparedStatement stmt = con.prepareStatement(query);
			empid=9;
			
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("EMP_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				int reps = rs.getInt("REPORTSTO");
				String email = rs.getString("EMAIL");
				int man = rs.getInt("IS_MANAGER");
				emp = new Employee(id, firstname, lastname, reps, email, man);
			} 
	}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
			return emp;

}

	@Override
	public boolean Employeelogin(String username, String password) {
		boolean x = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile("//Users//birhan//eclipse-workspace3//birhanproject1//src//main//resources//connection.properties")){
		String query = "SELECT * FROM LOGIN WHERE USERNAME=? AND PASS=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			x=true;
		}
	}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}return x;
	}

	@Override
	public boolean isManager( int empid) {
		boolean man = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile("//Users//birhan//eclipse-workspace3//birhanproject1//src//main//resources//connection.properties")){
		String query = "SELECT IS_MANAGER FROM EMPLOYEE WHERE EMP_ID=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, empid);
		
		ResultSet rs= stmt.executeQuery();
		if(rs.getInt("IS_MANAGER")==1) {
			man=true;
		}
		
	}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}
		return man;
	}

	@Override
	public int getIdFromLogin(String username, String password) {
		int x = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile("//Users//birhan//eclipse-workspace3//birhanproject1//src//main//resources//connection.properties")){
		String query = "SELECT EMP_ID FROM LOGIN WHERE USERNAME=? AND PASS=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		x=rs.getInt("EMP_ID");
	}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}
		return x;
	}


}
