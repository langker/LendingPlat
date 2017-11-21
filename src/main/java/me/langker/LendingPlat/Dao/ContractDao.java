package me.langker.LendingPlat.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.User;

public class ContractDao {
	@PersistenceContext
	EntityManager em;
	
	public Contract createContract(int age, String customer_detail,String detail,int finalprice,String location,User lenderid,Product product_id) {
		Contract con = new Contract();
		con.setAge(age);
		con.setCustomer_detail(customer_detail);
		con.setDetail(detail);
		con.setFinalprice(finalprice);
		con.setLocation(location);
		con.setLenderid(lenderid);
		con.setProductid(product_id);
		em.persist(con);
		return con;
	}
	public Contract updateContract(int age, String customer_detail,String detail,int finalprice,String location,User lenderid,Product product_id) {
		Contract con = new Contract();
		con.setAge(age);
		con.setCustomer_detail(customer_detail);
		con.setDetail(detail);
		con.setFinalprice(finalprice);
		con.setLocation(location);
		con.setLenderid(lenderid);
		con.setProductid(product_id);
		em.merge(con);
		return con;
	}
	public List<Contract> findContractByLenderID(User user) {
		String sql = "Select * from Contract where lenderid="+user.getId();
		return (List<Contract>)em.createNativeQuery(sql, Contract.class).getResultList();
	}
}
