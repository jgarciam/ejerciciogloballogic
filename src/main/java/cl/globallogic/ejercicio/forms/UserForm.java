package cl.globallogic.ejercicio.forms;

import java.util.List;

public class UserForm {

	
	private String name;
	private String email;
	private String password;
	private List<PhoneForm> phones;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PhoneForm> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneForm> phones) {
		this.phones = phones;
	}
	
	
}
