package me.langker.LendingPlat.Controller;

import javax.ejb.Stateless;
import javax.inject.Inject;

import me.langker.LendingPlat.Dao.LeasePeriodDao;

@Stateless
public class LeasePeriodController {
	@Inject LeasePeriodDao lpdao;
	
	public void init () {
		if(lpdao.findAllLeasePeriod().size()==0) {
			lpdao.initLeasePeriod();
		}
	}
	public void updateTerm(int shortT,int medium, int average) {
		lpdao.updateLease("short", shortT);
		lpdao.updateLease("medium", medium);
		lpdao.updateLease("average", average);
	}
	public int findValueByName (String name) {
		return lpdao.findLeasePeriodByName(name).getValue();
	}
}
