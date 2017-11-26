package me.langker.LendingPlat.Entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int userid;
    private int status;
    private boolean insurance;
    private int price;
    private int times;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Boolean getInsurance() {
		return insurance;
	}
	public void setInsurance(Boolean insurance) {
		this.insurance = insurance;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
}
