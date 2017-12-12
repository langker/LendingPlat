package me.langker.LendingPlat.Controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.ContractDao;
import me.langker.LendingPlat.Dao.ContractHistoryDao;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Entity.ContractHistory;

@Stateless
public class ContractController {
	@Inject ContractDao contractdao;
	@Inject ProductDao productdao;
	@Inject ContractHistoryDao chdao;
	public Contract addContract(int pid,int uid,int term,Date date,int currentuid) {
		int price = productdao.findProductById(pid).getPrice()*term;
		Contract con = contractdao.createContract(null, "", "",price, "", uid,currentuid,pid,1,term,date);
		chdao.createContractHistory(con.getId(), 1);
		return con;
	}
	public List<Contract> getUserCon(int uid) {
		return contractdao.findContractByLenderID(uid);
	}
	public List<Contract> getAllCon() {
		return contractdao.findContracts();
	}
	public Contract getConById(int id) {
		return contractdao.findContractsById(id);
	}
	public void setConStatus(int cid, int s) {
		contractdao.updateStatus(cid, s);
		chdao.createContractHistory(cid, s);
	}
	public void updateContract(int cid, String age, int price,String location,String cusdetail,String lenderS) {
		contractdao.updateCon(cid, age, price, location, cusdetail,lenderS);
	}
	public void updateLendeeSign(int cid, String lendeeS) {
		contractdao.updateLendeeSign(cid, lendeeS);
	}
	public List<ContractHistory> getConHistory(int id) {
		return chdao.findContractHistoryByConid(id);
	}
}
