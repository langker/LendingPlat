package me.langker.LendingPlat.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.langker.LendingPlat.Entity.Subscriber;
import me.langker.LendingPlat.Entity.User;

public class SubscriberDao {
	@PersistenceContext
	EntityManager em;
	public Subscriber createSubscribe(int user, String name) {
		Subscriber sub = new Subscriber();
		sub.setUserid(user);
		sub.setSubscribe_name(name);
		em.persist(sub);
		return sub;
	}
	public List<Subscriber> findSub(String name) {
		String sql = "Select * from Subscriber where name %like%"+name;
		return (List<Subscriber>)em.createNativeQuery(sql, Subscriber.class).getResultList();
	}
	
}
