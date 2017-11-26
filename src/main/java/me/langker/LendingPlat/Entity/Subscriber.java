package me.langker.LendingPlat.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscriber {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int userid;
    private String subscribe_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSubscribe_name() {
		return subscribe_name;
	}
	public void setSubscribe_name(String subscribe_name) {
		this.subscribe_name = subscribe_name;
	}
}
