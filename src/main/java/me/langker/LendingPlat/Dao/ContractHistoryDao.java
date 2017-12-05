package me.langker.LendingPlat.Dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.langker.LendingPlat.Entity.ContractHistory;

@Stateless
public class ContractHistoryDao {
	@PersistenceContext
	EntityManager em;
	public void createContractHistory(int conid,int status) {
		ContractHistory ch = new ContractHistory();
		ch.setContractid(conid);
		ch.setStatus(status);
		ch.setStatus(1);
		ch.setDate(new Date());
		em.persist(ch);
	}
	public List<ContractHistory> findContractHistoryByConid(int conid) {
		String sql = "Select * from ContractHistory where contractid=?";
		return (List<ContractHistory>)em.createNativeQuery(sql, ContractHistory.class).setParameter(1, conid).getResultList();
	}
}
