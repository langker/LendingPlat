package me.langker.LendingPlat.Dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.User;

@Stateless
public class ProductDao {
	@PersistenceContext
	EntityManager em;
	public Product createProduct(String description, String insurance, String name, int price, String status,User userid) {
		Product prd = new Product();
		prd.setInsurance(insurance);
		prd.setName(name);
		prd.setPrice(price);
		prd.setStatus(status);
		prd.setTimes(0);
		prd.setUserid(userid);
		em.persist(prd);
		return prd;
	}
	public Product updateProduct(String description, String insurance, String name, int price, String status,User userid) {
		Product prd = new Product();
		prd.setInsurance(insurance);
		prd.setName(name);
		prd.setPrice(price);
		prd.setStatus(status);
		prd.setTimes(0);
		prd.setUserid(userid);
		em.merge(prd);
		return prd;
	}
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {		
		String sql = "Select * from Product";
		return (List<Product>)em.createNativeQuery(sql, Product.class).getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByKeyword(String keyword) {		
		String sql = "Select * from Product where name like ?";
		Query query = em.createNativeQuery(sql, Product.class).setParameter(1, "%"+keyword+"%");
		return (List<Product>)query.getResultList();
	}
}
