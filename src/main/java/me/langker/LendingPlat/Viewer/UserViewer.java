package me.langker.LendingPlat.Viewer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import me.langker.LendingPlat.Controller.UserController;

@ManagedBean(name = "user")
@SessionScoped
public class UserViewer {
	@Inject UserController userController;
	
	private String email;
	private String password;
	private String credentail;
	private String address;
	
	public void login() {
		try {
			userController.login(email, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void reg() {
		
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
	public String getCredentail() {
		return credentail;
	}
	public void setCredentail(String credentail) {
		this.credentail = credentail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
