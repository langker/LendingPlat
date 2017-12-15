package me.langker.LendingPlat.Dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.langker.LendingPlat.Entity.ContractHistory;

@Stateless
public class ContractHistoryDao {
	@PersistenceContext
	EntityManager em;
	@Inject ContractDao cdao;
	public void createContractHistory(int conid,int status) {
		ContractHistory ch = new ContractHistory();
		ch.setContract(cdao.findContractsById(conid));
		ch.setStatus(status);
		ch.setStatus(status);
		ch.setDate(new Date());
		em.persist(ch);
	}
	@SuppressWarnings("unchecked")
	public List<ContractHistory> findContractHistoryByConid(int conid) {
		String sql = "Select * from ContractHistory where contract_id=?";
		return (List<ContractHistory>)em.createNativeQuery(sql, ContractHistory.class).setParameter(1, conid).getResultList();
	}
}
