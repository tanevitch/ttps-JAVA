package clases;

public class User {
	private String name;
	private String password;
	private String profile;
	
	public User(String name, String password, String profile) {
		this.name = name;
		this.password = password;
		this.profile = profile;
	}

	public boolean isValid(String name, String password) {
		return this.name.equals(name) && this.password.equals(password);
	}

	public String getProfile() {
		return profile;
	}
	
	
	
	
}
