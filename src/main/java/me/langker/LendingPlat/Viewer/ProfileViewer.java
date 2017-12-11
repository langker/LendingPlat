package me.langker.LendingPlat.Viewer;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Util.Util;

@ManagedBean(name = "profile")
@SessionScoped
public class ProfileViewer {
	private String email;
	private String address;
	private String cred;
	private int userid;
	private UploadedFile file;
	private boolean isAdmin;
	private String name;
	private String phone;
	@Inject UserController userController;
	public UploadedFile getFile() {  
        return file;  
    }  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }
    public void saveCred(FileUploadEvent event) throws IOException {
    	String filename = Util.getInstance().submit(event.getFile().getInputstream(),"/upload_cred");
    	userController.updateCred(Util.getInstance().getUserId(),filename);
    }
	public void updateProfile() {
		userController.updateProfile(Util.getInstance().getUserId(),address, name, phone);
	}
	public String getEmail() {
		email = userController.findUserProfile(Util.getInstance().getUserId()).getEmail();
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		address = userController.findUserProfile(Util.getInstance().getUserId()).getAddress();
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCred() {
		cred = userController.findUserProfile(Util.getInstance().getUserId()).getCredential();
		return cred;
	}
	public void setCred(String cred) {
		this.cred = cred;
	}
	public int getUserid() {
		userid = Util.getInstance().getUserId();
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public boolean getIsAdmin() {
		isAdmin = userController.findUserProfile(Util.getInstance().getUserId()).getIsAdmin();
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getName() {
		name = userController.findUserProfile(Util.getInstance().getUserId()).getName();
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		phone = userController.findUserProfile(Util.getInstance().getUserId()).getPhone();
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
