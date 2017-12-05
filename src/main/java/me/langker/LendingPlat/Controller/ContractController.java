package me.langker.LendingPlat.Controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.ContractDao;
import me.langker.LendingPlat.Dao.ContractHistoryDao;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Util.Util;

@Stateless
public class ContractController {
	@Inject ContractDao contractdao;
	@Inject ProductDao productdao;
	@Inject ContractHistoryDao chdao;
	public void addContract(int pid,int uid,int term,Date date) {
		Contract con = contractdao.createContract(0, "", "", productdao.findProductById(pid).getPrice(), "", uid,Util.getInstance().getUserId(),pid,1,term,date);
		chdao.createContractHistory(con.getId(), 1);
	}
	public List<Contract> getAllCon() {
		return contractdao.findContractByLenderID(Util.getInstance().getUserId());
	}
	public List<Contract> getAllConForAdmin() {
		return contractdao.findContracts();
	}
	public Contract getConById(int id) {
		return contractdao.findContractsById(id);
	}
	public void setConStatus(int cid, int s) {
		contractdao.updateStatus(cid, s);
		chdao.createContractHistory(cid, s);
	}
	public void updateContract(int cid, int age, int price,String location,String cusdetail) {
		contractdao.updateCon(cid, age, price, location, cusdetail);
	}
}
