package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Product;

@ManagedBean(name = "profile")
@SessionScoped
public class ProfileViewer {
	private String email;
	private String address;
	private ArrayList<Product> productList;
	@Inject UserController userController;
	
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
}
