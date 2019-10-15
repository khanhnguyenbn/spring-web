package vn.topica.itlab4.springweb.model;

public class UserModel {
	
	private int id;
	private String userName;
	private String password;
	private String name;
	private String email;
	
	
	public UserModel() {
		
	}
	
	public UserModel(int id, String userName, String password, String name, String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
