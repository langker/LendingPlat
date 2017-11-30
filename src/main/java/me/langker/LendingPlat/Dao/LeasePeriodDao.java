package me.langker.LendingPlat.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import me.langker.LendingPlat.Entity.LeasePeriod;
import me.langker.LendingPlat.Entity.User;

@Stateless
public class LeasePeriodDao {
	@PersistenceContext
	EntityManager em;
	
	public void updateLease(String name,int value) {
		String sql = "UPDATE LeasePeriod SET value =? WHERE name =?";
		Query query = em.createNativeQuery(sql, LeasePeriod.class).setParameter(1,value).setParameter(2, name);
		query.executeUpdate();
	}
	public LeasePeriod findLeasePeriodByName(String name) {
		String sql = "Select * from LeasePeriod where name=?";
		return (LeasePeriod)em.createNativeQuery(sql, LeasePeriod.class).setParameter(1, name).getSingleResult();
	}
	public List<LeasePeriod> findAllLeasePeriod() {
		String sql = "Select * from LeasePeriod";
		return (List<LeasePeriod>)em.createNativeQuery(sql, LeasePeriod.class).getResultList();
	}
	public void initLeasePeriod() {
		LeasePeriod lp1 = new LeasePeriod();
		lp1.setName("short");
		lp1.setValue(10);
		em.persist(lp1);
		
		LeasePeriod lp2 = new LeasePeriod();
		lp2.setName("medium");
		lp2.setValue(20);
		em.persist(lp2);
		
		LeasePeriod lp3 = new LeasePeriod();
		lp3.setName("average");
		lp3.setValue(30);
		em.persist(lp3);
	}
}
