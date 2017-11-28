package me.langker.LendingPlat.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Entity.User;

@Stateless
public class ContractDao {
	@PersistenceContext
	EntityManager em;
	
	public Contract createContract(int age, String customer_detail,String detail,int finalprice,String location,int lenderid,int lendeeid, int product_id,int status) {
		Contract con = new Contract();
		con.setAge(age);
		con.setCustomer_detail(customer_detail);
		con.setDetail(detail);
		con.setFinalprice(finalprice);
		con.setLocation(location);
		con.setLenderid(lenderid);
		con.setLendeeid(lenderid);
		con.setProductid(product_id);
		con.setStatus(status);
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
		String sql = "Select * from Contract where lenderid=?";
		return (List<Contract>)em.createNativeQuery(sql, Contract.class).setParameter(1, uid).getResultList();
	}
	public void updateStatus(int cid, int s) {
		String sql = "UPDATE Contract SET status =? WHERE id = ?";
		Query query = em.createNativeQuery(sql, Contract.class).setParameter(1,s).setParameter(2, cid);
		query.executeUpdate();
	}
}
