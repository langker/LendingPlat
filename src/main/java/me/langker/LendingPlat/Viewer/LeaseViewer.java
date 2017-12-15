package me.langker.LendingPlat.Viewer;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.User;

@ManagedBean(name = "lease")
@SessionScoped
public class LeaseViewer {
	private Contract lease;
	private User lender;
	private User lendee;
	private Product pro;
	@Inject ContractController conController;
	@Inject UserController userController;
	@Inject ProductController pController;
	public void getLease(String id) throws IOException {
		if (id.equals("")==false) {
			lease = conController.getConById(Integer.valueOf(id));
			if (lease==null)  {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			}
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}
	}
	public Contract getLease() {
		return lease;
	}
	public void setLease(Contract lease) {
		this.lease = lease;
	}
	public User getLender() {
		lender = userController.findUserProfile(lease.getLender().getId());
		return lender;
	}
	public void setLender(User lender) {
		this.lender = lender;
	}
	public User getLendee() {
		lender = userController.findUserProfile(lease.getLendee().getId());
		return lendee;
	}
	public void setLendee(User lendee) {
		this.lendee = lendee;
	}
	public Product getPro() {
		pro = pController.findProductById(lease.getProduct().getId());
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
}
