package me.langker.LendingPlat.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.Subscriber;

@Stateless
public class SubscriberDao {
	@PersistenceContext
	EntityManager em;
	@Inject UserDao udao;
	public Subscriber createSubscribe(int userid, String name) {
		Subscriber sub = new Subscriber();
		sub.setUser(udao.findUserProfile(userid));
		sub.setSubscribe_name(name);
		em.persist(sub);
		return sub;
	}
	public void delSubById(int id) {
		String sql = "Delete From Subscriber where id=?";
		em.createNativeQuery(sql,Subscriber.class).setParameter(1, id).executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<Subscriber> findSubByName(String name) {
		String sql = "Select * from Subscriber where InStr(?,rtrim(subscribe_name))";
		return (List<Subscriber>)em.createNativeQuery(sql, Subscriber.class).setParameter(1, name).getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Subscriber> findSubByUserId(int userid) {
		String sql = "Select * from Subscriber where user_id=?";
		return (List<Subscriber>)em.createNativeQuery(sql, Subscriber.class).setParameter(1, userid).getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Product> findSubProdcut(int id) {
		String sql = "select *from Product where id in (select product_id from SubscriberNotify where user_id=?)";
		return (List<Product>)em.createNativeQuery(sql, Product.class).setParameter(1, id).getResultList();
	}
	@SuppressWarnings("unchecked")
	public Subscriber findSubById(int id) {
		String sql = "select *from Subscriber where id=?";
		return (Subscriber)em.createNativeQuery(sql, Subscriber.class).setParameter(1, id).getSingleResult();
	}
	
}
