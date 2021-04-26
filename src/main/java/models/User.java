package models;

public class User {
	
	private String name;
	private String pass;
	public String user_error;
	public String pass_error;
	
	
	public User(String name, String pass) {
		super();
		System.out.println("inside User constructor");
		this.name = name;
		this.pass = pass;
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

}
