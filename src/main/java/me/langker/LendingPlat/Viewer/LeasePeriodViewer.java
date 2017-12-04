package me.langker.LendingPlat.Viewer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.LeasePeriodController;

@ManagedBean(name = "lp")
@SessionScoped
public class LeasePeriodViewer {
	private int shortTerm;
	private int mediumTerm;
	private int averageTerm;
	@Inject LeasePeriodController lpController;
	public int getShortTerm() {
		shortTerm = lpController.findValueByName("short");
		return shortTerm;
	}
	public void setShortTerm(int shortTerm) {
		this.shortTerm = shortTerm;
	}
	public int getMediumTerm() {
		mediumTerm = lpController.findValueByName("medium");
		return mediumTerm;
	}
	public void setMediumTerm(int mediumTerm) {
		this.mediumTerm = mediumTerm;
	}
	public int getAverageTerm() {
		averageTerm = lpController.findValueByName("average");
		return averageTerm;
	}
	public void setAverageTerm(int averageTerm) {
		this.averageTerm = averageTerm;
	}
	
	
}
