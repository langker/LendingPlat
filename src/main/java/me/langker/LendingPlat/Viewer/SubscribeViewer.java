package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.SubscriberController;
import me.langker.LendingPlat.Entity.Subscriber;

@ManagedBean(name = "sub")
@ViewScoped
@SessionScoped
public class SubscribeViewer {
	private String keyword;
	private ArrayList<Subscriber> keywords;
	@Inject SubscriberController subController;
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void saveSub() {
		subController.saveSub(keyword);
	}

	public void delSub(int id) {
		subController.delSub(id);
	}
	
	public ArrayList<Subscriber> getKeywords() {
		keywords = (ArrayList<Subscriber>) subController.findAllSub();
		return keywords;
	}

	public void setKeywords(ArrayList<Subscriber> keywords) {
		this.keywords = keywords;
	}
	
}
