package me.langker.LendingPlat.Viewer;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Product;

@ManagedBean(name = "product")
@ViewScoped
@SessionScoped
public class ProductViewer {
	private Product p;
	@Inject ProductDao pdao;
	@Inject ContractController contractController;
	public void getProduct(String id) throws IOException { 
		if (id.equals("")==false) {
			p = pdao.findProductById(Integer.valueOf(id));
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
		contractController.addContract(Integer.valueOf(pid),Integer.valueOf(uid));
	}
}
