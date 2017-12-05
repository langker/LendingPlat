package me.langker.LendingPlat.Dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import me.langker.LendingPlat.Entity.Product;

@Stateless
public class ProductDao {
	@PersistenceContext
	EntityManager em;
	public Product createProduct(String description, boolean insurance, String name, int price, int userid,String photo) {
		Product prd = new Product();
		prd.setInsurance(insurance);
		prd.setName(name);
		prd.setPrice(price);
		prd.setStatus(0);
		prd.setTimes(0);
		prd.setUserid(userid);
		prd.setDescription(description);
		prd.setPhoto(photo);
		prd.setAvailableData(new Date());
		em.persist(prd);
		return prd;
	}
	public Product updateProduct(String description, Boolean insurance, String name, int price, int status,int userid) {
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
	public Product findProductById(int id) {		
		String sql = "Select * from Product where id=?";
		return (Product)em.createNativeQuery(sql,Product.class).setParameter(1, id).getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByKeyword(String keyword) {		
		String sql = "Select * from Product where name like ?";
		Query query = em.createNativeQuery(sql, Product.class).setParameter(1, "%"+keyword+"%");
		return (List<Product>)query.getResultList();
	}
	public void updateAvailableDate(int id,Date date) {
		Product p = findProductById(id);
		p.setAvailableData(date);
		em.merge(p);
	}
}
