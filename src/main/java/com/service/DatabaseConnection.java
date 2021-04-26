package com.service;

import java.sql.*;

public class DatabaseConnection {
    public static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/accounts";
        
        // Database name to access
        String User = "root";
		String Pass = "23022000";
		System.out.println("Preparing for Connection");
        
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,User, Pass);
        return con;
    }
    
    public static ResultSet result_set() throws ClassNotFoundException, SQLException {
    	String sql = "select * from accounts";
    	Connection con  = initializeDatabase();
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(sql);
    	
    	while(rs.next()) {
    		System.out.println(rs.getString("user"));
    	    System.out.println(rs.getString("password"));
    	   
    	}
    	return rs;
    }
    
    public static boolean checkindb(String myname,String pass) throws ClassNotFoundException, SQLException {
    	String sql = "select * from accounts";
    	Connection con  = initializeDatabase();
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(sql);
    	
    	while(rs.next()) {
    		if(rs.getString("user").equals(myname) && rs.getString("password").equals(pass))
    			{
    				System.out.println("matches");
    				return true;	   
    			}
    	}
    	System.out.println("not matches");
    	return false;
    }
    
    public static boolean checkforname(String myname) throws ClassNotFoundException, SQLException {
    	String sql = "select * from accounts";
    	Connection con  = initializeDatabase();
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(sql);
    	
    	while(rs.next()) {
    		if(rs.getString("user").equals(myname))
    			{
    				System.out.println("matches");
    				return true;	   
    			}
    	}
    	System.out.println("not matches");
    	return false;
    }
    
    public static void putindb(String myname,String pass) throws ClassNotFoundException, SQLException {
    	
    	String sql = "insert into accounts values(?,?)";
    	Connection con  = initializeDatabase();
    	PreparedStatement st = con.prepareStatement(sql);
    	System.out.println("Statement prepared");
    	st.setString(1,myname);
    	st.setString(2,pass);
    	System.out.println("Statement executed");
    	st.executeUpdate();
    	System.out.println("inserted into DB successfully");
    }
    
    
}