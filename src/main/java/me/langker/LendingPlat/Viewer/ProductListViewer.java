package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Entity.Product;

@ManagedBean(name = "productList")
@ViewScoped
@SessionScoped
public class ProductListViewer {
	private ArrayList<Product> productList;
	private String keyword;
	private int id;
	private int userid;
	@Inject ProductController productController;
	@Inject ContractController contractController;
	public void getProductAllList() {
		//avoid called during ajax
		if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) { 
			return;
		} else {
			productList = (ArrayList<Product>)productController.getAllProducts();
		}
	}
	public void rentProduct(String pid, String uid) {
		contractController.addContract(Integer.valueOf(pid),Integer.valueOf(uid));
	}
	public void getProductListByKeyword() {
		this.productList = (ArrayList<Product>)productController.searchProducts(keyword);
	}
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
