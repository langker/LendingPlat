package me.langker.LendingPlat.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.Subscriber;
import me.langker.LendingPlat.Util.Util;

@Stateless
public class SubscriberDao {
	@PersistenceContext
	EntityManager em;
	public Subscriber createSubscribe(int userid, String name) {
		Subscriber sub = new Subscriber();
		sub.setUserid(userid);
		sub.setSubscribe_name(name);
		em.persist(sub);
		return sub;
	}
	public void delSubById(int id) {
		String sql = "Delete From Subscriber where id=?";
		em.createNativeQuery(sql,Subscriber.class).setParameter(1, id).executeUpdate();
	}
	public List<Subscriber> findSubByName(String name) {
		String sql = "Select * from Subscriber where subscribe_name like ?";
		return (List<Subscriber>)em.createNativeQuery(sql, Subscriber.class).setParameter(1, "%"+name+"%").getResultList();
	}
	public List<Subscriber> findSubByUserId(int userid) {
		String sql = "Select * from Subscriber where userid=?";
		return (List<Subscriber>)em.createNativeQuery(sql, Subscriber.class).setParameter(1, userid).getResultList();
	}
	public List<Product> findSubProdcut(int id) {
		String sql = "select *from Product where id in (select pid from SubscriberNotify where userid=?)";
		return (List<Product>)em.createNativeQuery(sql, Product.class).setParameter(1, id).getResultList();
	}
	
}
