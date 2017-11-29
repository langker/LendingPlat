package me.langker.LendingPlat.Viewer;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Util.Util;

@ManagedBean(name = "userLogin")
@SessionScoped
public class UserLoginViewer {
	private String email;
	private String password;
	@Inject UserController userController;
	public void login() throws IOException {
		try {
			userController.login(email, password);
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("failure.xhtml");
			e.printStackTrace();
		}
	}
	public void logout() {
		userController.logout();
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
	public void handleEvent() {
		try {
			if(!userController.isLogin())
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
