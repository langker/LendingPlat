package me.langker.LendingPlat.Viewer;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Entity.User;

@ManagedBean(name = "admin")
@SessionScoped
public class AdminViewer {
	private ArrayList<User> users;
	private ArrayList<Contract> con;
	@Inject UserController userController;
	@Inject ContractController conController;
	public ArrayList<User> getUsers() {
		users = (ArrayList<User>)userController.findAllUser();
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public void checkIsAdmin() throws IOException {
		if(userController.findUserProfile().getIsAdmin()!=true)
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}
	public ArrayList<Contract> getCon() {
		con = (ArrayList<Contract>)conController.getAllConForAdmin();
		return con;
	}
	public void setCon(ArrayList<Contract> con) {
		this.con = con;
	}
}
