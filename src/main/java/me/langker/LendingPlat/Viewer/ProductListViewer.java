package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Entity.Product;

@ManagedBean(name = "productList")
@ViewScoped
@SessionScoped
public class ProductListViewer {
	private ArrayList<Product> productList;
	private String keyword;
	@Inject ProductController productController;
	
	public void getProductAllList() {
		//avoid called during ajax
		if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) { 
			return;
		} else {
			productList = (ArrayList<Product>)productController.getAllProducts();
		}
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
}
