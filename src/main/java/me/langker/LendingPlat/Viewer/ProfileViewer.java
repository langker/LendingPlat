package me.langker.LendingPlat.Viewer;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Util.Util;

@ManagedBean(name = "profile")
@SessionScoped
public class ProfileViewer {
	private String email;
	private String address;
	private ArrayList<Product> productList;
	private String cred;
	private Part file;
	@Inject UserController userController;
	
	public Part getFile() {  
        return file;  
    }  
    public void setFile(Part file) {  
        this.file = file;  
    }
    public void saveCred() throws IOException {
    	String filename = Util.getInstance().submit(file,"/upload_cred");
    	userController.updateCred(filename);
    }
	public void saveAddress() {
		userController.updateAddress(address);
	}
	public String getEmail() {
		return userController.findUserProfile().getEmail();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return userController.findUserProfile().getAddress();
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	public String getCred() {
		cred = userController.findUserProfile().getCredential();
		return cred;
	}
	public void setCred(String cred) {
		this.cred = cred;
	}
}
