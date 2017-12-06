package me.langker.LendingPlat.Viewer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.primefaces.model.UploadedFile;

import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Util.Util;

@ManagedBean(name = "addProduct")
@ViewScoped
@SessionScoped
public class AddProductViewer {
	private String name;
	private int price;
	private String description;
	private boolean insurance;
	private Part file; 
    public Part getFile() {  
        return file;  
    }  
    public void setFile(Part file) {  
        this.file = file;  
    }
	@Inject ProductController productController;
	public void addProduct() {
		try {
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			String filename = Util.getInstance().submit(file.getInputStream(),"/upload_product/");
			productController.addProduct(name,price,description,insurance, (int)session.getAttribute("userid"),filename);
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
}
