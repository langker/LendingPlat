package me.langker.LendingPlat.Viewer;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import me.langker.LendingPlat.Controller.SubscriberController;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.Subscriber;
import me.langker.LendingPlat.Util.Util;

@ManagedBean(name = "sub")
@ViewScoped
@SessionScoped
public class SubscribeViewer {
	private String keyword;
	private ArrayList<Subscriber> keywords;
	private ArrayList<Product> subProduct;
	@Inject SubscriberController subController;
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void saveSub() {
		subController.saveSub(Util.getInstance().getUserId(),keyword);
	}

	public void delSub(int id) {
		subController.delSub(id);
	}
	
	public ArrayList<Subscriber> getKeywords() {
		keywords = (ArrayList<Subscriber>) subController.findAllSub(Util.getInstance().getUserId());
		return keywords;
	}

	public void setKeywords(ArrayList<Subscriber> keywords) {
		this.keywords = keywords;
	}

	public ArrayList<Product> getSubProduct() {
		subProduct = (ArrayList<Product>)subController.findSubProdcut(Util.getInstance().getUserId());
		return subProduct;
	}

	public void setSubProduct(ArrayList<Product> subProduct) {
		this.subProduct = subProduct;
	}
	
}
