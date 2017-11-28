package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Entity.Contract;

@ManagedBean(name = "con")
@SessionScoped
public class ContractViewer {
	private ArrayList<Contract> conList;
	@Inject ContractController conController;
	public ArrayList<Contract> getConList() {
		conList = (ArrayList<Contract>)conController.getAllCon();
		return conList;
	}
	public void setConList(ArrayList<Contract> conList) {
		this.conList = conList;
	}
	public void setConStatus(int cid,int s) {
		conController.setConStatus(cid, s);
	}
}
