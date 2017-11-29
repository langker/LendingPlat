package me.langker.LendingPlat.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.langker.LendingPlat.Entity.SubscriberNotify;

@Stateless
public class SubscribeNotifyDao {
	@PersistenceContext
	EntityManager em;
	public SubscriberNotify createSubscribeNotify(int pid,int subid,int userid) {
		SubscriberNotify sn = new SubscriberNotify();
		sn.setPid(pid);
		sn.setSubid(subid);
		sn.setUserid(userid);
		em.persist(sn);
		return sn;
	}
}
