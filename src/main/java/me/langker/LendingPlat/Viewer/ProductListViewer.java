package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Entity.Product;

@ManagedBean(name = "productList")
@SessionScoped
public class ProductListViewer {
	private ArrayList<Product> productList;
	private String keyword;
	@Inject ProductController productController;
	
	@PostConstruct
	public void getProductAllList() {
		productList = (ArrayList<Product>)productController.getAllProducts();
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
