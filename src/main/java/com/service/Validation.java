package com.service;

import java.sql.SQLException;

import com.mysql.cj.util.StringUtils;

import models.*;
import com.service.DatabaseConnection;

public class Validation {
	
	private Userr user;

	public Validation(Userr user) throws ClassNotFoundException, SQLException {
		super();
		this.user = user;
		this.validate();
	}
	
	public Userr validate() throws ClassNotFoundException, SQLException {
		System.out.println("validation called");
		if(StringUtils.isEmptyOrWhitespaceOnly(user.getName()))
		{
			user.setName_error("username cannot be empty");
		}
		else if(!(DatabaseConnection.checkforname(user.getName()))){
			user.setName_error("username not present");
		}
		else {
			user.setName_error("username present");}
		
		
		if(StringUtils.isEmptyOrWhitespaceOnly(user.getPass()))
		{
			user.setPass_error("password cannot be empty");
		}
		else if(!(DatabaseConnection.checkindb(user.getName(), user.getPass())))	{
			user.setPass_error("invalid username and password combination");
		}
			
		return this.user;
	}
	
	public boolean check_for_login_status() throws ClassNotFoundException, SQLException {
		return DatabaseConnection.checkindb(user.getName(), user.getPass());
	}
	
	public boolean check_for_signing() throws ClassNotFoundException, SQLException {
		if(StringUtils.isEmptyOrWhitespaceOnly(user.getPass()))
		{
			return false;
		}else if(StringUtils.isEmptyOrWhitespaceOnly(user.getName()))
			return false;
		else if(DatabaseConnection.checkforname(user.getName()))
			return false;
		
		
		DatabaseConnection.putindb(user.getName(), user.getPass());
		
		return true;
		
	}
		

	
}
