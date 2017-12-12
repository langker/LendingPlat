package me.langker.LendingPlat.Viewer;

import java.io.IOException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Util.Util;

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
		if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) { 
			return;
		} else {
			if (id.equals("")==false) {
				p = pController.findProductById(Integer.valueOf(id));
				if (p==null) FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			}
		}
	}
	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}
	public void rentProduct(String pid, String uid) {
		if (startRentingdate!=null&&term!=0) {
			if(startRentingdate.before(p.getAvailableDate())==true) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "the date you choose should after the available date!"));
				
			} else {
				// start main processing
				pController.setNewAvailableDateAndStatus(Integer.valueOf(pid), term, startRentingdate,1);
				contractController.addContract(Integer.valueOf(pid),Integer.valueOf(uid),term,startRentingdate,Util.getInstance().getUserId());
				RequestContext.getCurrentInstance().execute("alert('rent successful');PF('rentDlg').hide()");
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR: you should input",""));
		}
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
