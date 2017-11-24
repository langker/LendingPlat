package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Entity.Product;

@ManagedBean(name = "productList")
@SessionScoped
public class ProductListViewer {
	private ArrayList<Product> productList;
	@Inject ProductController productController;
	public ArrayList<Product> getProductList() {
		productList = (ArrayList<Product>)productController.getAllProducts();
//		productList = new ArrayList<Product>(Arrays.asList(
//			    new Product(),
//			    new Product(),
//			    new Product()
//			  ));
		return productList;
	}
}
