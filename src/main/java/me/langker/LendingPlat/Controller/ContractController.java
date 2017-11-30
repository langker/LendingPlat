package me.langker.LendingPlat.Controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.ContractDao;
import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Util.Util;

@Stateless
public class ContractController {
	@Inject ContractDao contractdao;
	@Inject ProductDao productdao;
	public void addContract(int pid,int uid) {
		contractdao.createContract(0, "", "", productdao.findProductById(pid).getPrice(), "", uid,Util.getInstance().getUserId(),pid,1);
	}
	public List<Contract> getAllCon() {
		return contractdao.findContractByLenderID(Util.getInstance().getUserId());
	}
	public List<Contract> getAllConForAdmin() {
		return contractdao.findContracts();
	}
	public void setConStatus(int cid, int s) {
		contractdao.updateStatus(cid, s);
	}
}
