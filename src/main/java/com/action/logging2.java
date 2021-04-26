package com.action;

import com.mysql.cj.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.SQLException;

import models.*;
import com.service.*;
public class logging2 extends ActionSupport implements ModelDriven<Userr>{

	private Userr user = new Userr();
		
	public String execute() throws ClassNotFoundException, SQLException {
		
		System.out.println("inside execute method");
		System.out.println(user.getName());
		System.out.println(user.getPass());
		System.out.print(user.getDummy());
		Validation serviceclass = new Validation(user);
		if(serviceclass.check_for_login_status())
			return "success";
		return "failure";
	}


	
	
	@Override
	public Userr getModel() {
		return user;
	}
	
}
