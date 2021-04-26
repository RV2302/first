package models;

public class Userr {
	
	private String name;
	private String pass;
	private String dummy;
	private String name_error;
	private String pass_error;
	
	public String getName_error() {
		return name_error;
	}

	public void setName_error(String name_error) {
		this.name_error = name_error;
	}

	public String getPass_error() {
		return pass_error;
	}

	public void setPass_error(String pass_error) {
		this.pass_error = pass_error;
	}

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

	public void Userr() {
		System.out.println("in Userr const");
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

}
