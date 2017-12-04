package me.langker.LendingPlat.Viewer;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Product;

@ManagedBean(name = "product")
@ViewScoped
@SessionScoped
public class ProductViewer {
	private Product p;
	private Date startRentingdate;
	private int term;
	@Inject ProductController pController;
	@Inject ContractController contractController;
	public void getProduct(String id) throws IOException { 
		if (id.equals("")==false) {
			p = pController.findProductById(Integer.valueOf(id));
			if (p==null) FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}
	}
	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}
	public void rentProduct(String pid, String uid) {
		pController.setNewAvailableDate(Integer.valueOf(pid), term, startRentingdate);
		contractController.addContract(Integer.valueOf(pid),Integer.valueOf(uid),term,startRentingdate);
	}
	public Date getStartRentingdate() {
		return startRentingdate;
	}
	public void setStartRentingdate(Date startRentingdate) {
		this.startRentingdate = startRentingdate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
}
