package me.langker.LendingPlat.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subscriber {
    @Id
    private int id;
    @ManyToOne
    private User userid;
    private String subscribe_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	public String getSubscribe_name() {
		return subscribe_name;
	}
	public void setSubscribe_name(String subscribe_name) {
		this.subscribe_name = subscribe_name;
	}
}
