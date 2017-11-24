package me.langker.LendingPlat.Controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Product;


@Stateless
public class ProductController {
	@Inject ProductDao productdao;
	public List<Product> getAllProducts() {
		return productdao.findAllProducts();
	}
}
