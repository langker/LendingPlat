package me.langker.LendingPlat.Dao;

import javax.persistence.*;
import me.langker.LendingPlat.Entity.LeasePeriod;

public class LeasePeriodDao extends UserDao {
	@PersistenceContext
	EntityManager em;
	
	public LeasePeriod updateLease(String name,int value) {
		LeasePeriod lp = new LeasePeriod();
		lp.setName(name);
		lp.setValue(value);
		em.merge(lp);
		return lp;
	}
	public LeasePeriod findLeasePeriod(String name) {
		String sql = "Select * from User where name="+name;
		return (LeasePeriod)em.createNativeQuery(sql, LeasePeriod.class).getSingleResult();
	}
}
