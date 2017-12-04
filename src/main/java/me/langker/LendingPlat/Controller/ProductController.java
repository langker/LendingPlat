package me.langker.LendingPlat.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Product;


@Stateless
public class ProductController {
	@Inject ProductDao productdao;
	@Inject SubscriberController sController;
	public List<Product> getAllProducts() {
		return productdao.findAllProducts();
	}
	public List<Product> searchProducts(String keyword) {
		return productdao.findProductsByKeyword(keyword);
	}
	public void addProduct(String name,int price, String description, boolean insurance, int userid, String photo) {
		Product p = productdao.createProduct(description, insurance, name, price, userid, photo);
		sController.update(p.getId());
	}
	public Product findProductById(int id) {
		return productdao.findProductById(id);
	}
	public void setNewAvailableDate(int id,int term,Date date) {
		Calendar tmp = Calendar.getInstance();
		tmp.setTime(date);
		tmp.add(Calendar.DAY_OF_YEAR, term);
		productdao.updateAvailableDate(id,tmp.getTime());		
	}
}
