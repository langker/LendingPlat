package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Contract;

@ManagedBean(name = "con")
@SessionScoped
public class ContractViewer {
	private ArrayList<Contract> conList;
	private String location;
	private int age;
	private int price;
	private String customer_detail;
	private String lendeeAddress;
	private String lenderAddress;
	@Inject ContractController conController;
	@Inject UserController userController;
	public ArrayList<Contract> getConList() {
		conList = (ArrayList<Contract>)conController.getAllCon();
		return conList;
	}
	public void setConList(ArrayList<Contract> conList) {
		this.conList = conList;
	}
	public void setConStatus(int cid,int s) {
		conController.setConStatus(cid, s);
	}
	//When the lendee send the contract to the lender, 
	//this call on, lender call it to fill the location,the age,the price and the customer detail 
	public void updateContractWithFirstTime(int id) {
		conController.updateContract(id,age , price, location,customer_detail);
		conController.setConStatus(id, 2);
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCustomer_detail() {
		return customer_detail;
	}
	public void setCustomer_detail(String customer_detail) {
		this.customer_detail = customer_detail;
	}
	public String getLendeeAddress(int id) {
		lendeeAddress = userController.findUserProfileById(conController.getConById(id).getLendeeid()).getAddress();
		return lendeeAddress;
	}
	public void setLendeeAddress(String lendeeAddress) {
		this.lendeeAddress = lendeeAddress;
	}
	public String getLenderAddress(int id) {
		lenderAddress = userController.findUserProfileById(conController.getConById(id).getLenderid()).getAddress();
		return lenderAddress;
	}
	public void setLenderAddress(String lenderAddress) {
		this.lenderAddress = lenderAddress;
	}
}
