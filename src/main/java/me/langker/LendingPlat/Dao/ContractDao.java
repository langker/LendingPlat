package me.langker.LendingPlat.Dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import me.langker.LendingPlat.Entity.Contract;

@Stateless
public class ContractDao {
	@PersistenceContext
	EntityManager em;
	
	public Contract createContract(int age, String customer_detail,String detail,int finalprice,String location,int lenderid,int lendeeid, int product_id,int status,int term,Date date) {
		Contract con = new Contract();
		con.setAge(age);
		con.setCustomer_detail(customer_detail);
		con.setDetail(detail);
		con.setFinalprice(finalprice);
		con.setLocation(location);
		con.setLenderid(lenderid);
		con.setLendeeid(lendeeid);
		con.setProductid(product_id);
		con.setStatus(status);
		con.setTerm(term);
		con.setStartDate(date);
		em.persist(con);
		return con;
	}
	public Contract updateContract(int age, String customer_detail,String detail,int finalprice,String location,int lenderid,int lendeeid,int product_id) {
		Contract con = new Contract();
		con.setAge(age);
		con.setCustomer_detail(customer_detail);
		con.setDetail(detail);
		con.setFinalprice(finalprice);
		con.setLocation(location);
		con.setLenderid(lenderid);
		con.setLendeeid(lendeeid);
		con.setProductid(product_id);
		em.merge(con);
		return con;
	}
	public List<Contract> findContractByLenderID(int uid) {
		String sql = "Select * from Contract where lenderid=? or lendeeid=?";
		return (List<Contract>)em.createNativeQuery(sql, Contract.class).setParameter(1, uid).setParameter(2, uid).getResultList();
	}
	public List<Contract> findContracts() {
		String sql = "Select * from Contract";
		return (List<Contract>)em.createNativeQuery(sql, Contract.class).getResultList();
	}
	public Contract findContractsById(int id) {
		String sql = "Select * from Contract where id=?";
		return (Contract)em.createNativeQuery(sql, Contract.class).setParameter(1, id).getSingleResult();
	}
	public void updateStatus(int cid, int s) {
		String sql = "UPDATE Contract SET status =? WHERE id = ?";
		Query query = em.createNativeQuery(sql, Contract.class).setParameter(1,s).setParameter(2, cid);
		query.executeUpdate();
	}
	public void updateCon(int cid, int age, int price,String location,String cusdetail,String lenderSignature) {
		Contract con = findContractsById(cid);
		if (age!=0) con.setAge(age);
		if (price!=0) con.setFinalprice(price);
		if (location!=null) con.setLocation(location);
		if (cusdetail!=null) con.setCustomer_detail(cusdetail);
		con.setLenderSignature(lenderSignature);
		em.merge(con);
	}
	public void updateLendeeSign(int cid,String lendeeSignature) {
		Contract con = findContractsById(cid);
		con.setLendeeSignature(lendeeSignature);
		em.merge(con);
	}
}
