package com.action;

import com.mysql.cj.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import models.*;

public class logging extends ActionSupport {

	private String name;
	private String pass;
	private String user_error;
	private String pass_error;
	private User user;
	public String getUser_error() {
		return user_error;
	}

	public void setUser_error(String user_error) {
		this.user_error = user_error;
	}

	public String getPass_error() {
		return pass_error;
	}

	public void setPass_error(String pass_error) {
		this.pass_error = pass_error;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String execute() {
		user =  new User(getName(),getPass());
		System.out.println("inside execute method");
		System.out.println(getName());
		System.out.println(getPass());
		
		if(StringUtils.isEmptyOrWhitespaceOnly(getName()))
		{
			user_error = "empty";
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(getPass()))
		{
			pass_error = "empty";
		}
		
		return "failure";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
