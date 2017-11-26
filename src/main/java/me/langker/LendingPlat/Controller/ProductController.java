package me.langker.LendingPlat.Controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.User;


@Stateless
public class ProductController {
	@Inject ProductDao productdao;
	public List<Product> getAllProducts() {
		return productdao.findAllProducts();
	}
	public List<Product> searchProducts(String keyword) {
		return productdao.findProductsByKeyword(keyword);
	}
	public void addProduct(String name,int price, String description, boolean insurance, int userid) {
		productdao.createProduct(description, insurance, name, price, userid);
	}
}
