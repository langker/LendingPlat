package me.langker.LendingPlat.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String photo;
    private String name;
    @Column(length=65535) 
    private String description;
    
    @ManyToOne
    private User user;
    //0:can be lent
    //1:lent to others
    private int status;
    private boolean insurance;
    private int price;
    private int times;
    private Date availableDate;
    
    @OneToMany(mappedBy="product")
	List<SubscriberNotify> SubscriberNotifys;
    
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Boolean getInsurance() {
		return insurance;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableData(Date availableDate) {
		this.availableDate = availableDate;
	}
	public void setUserid(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
}
