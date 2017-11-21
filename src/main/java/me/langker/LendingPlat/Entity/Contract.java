package me.langker.LendingPlat.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Contract {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@OneToOne
    private User lenderid;
	@OneToOne
    private User lendeeid;
    private String detail;
    private Date startDate;
    private int term;
    @OneToOne
    private Product productid;
    private int finalprice;
    private String location;
    private int age;
    private String customer_detail;
    //0:waiting for lender
    //1:lender agree to lend the product and make the contract
    //2:lendee agree the contract
    //3:lender send the product to the lendee
    //4:lendee receive the product and the product is not available for others
    //5:lendee return the product to the lender
    //6:lender receive the product and the whole progress finish
    private int status;
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
		this.id = id;
	}
	public User getLenderid() {
		return lenderid;
	}
	public void setLenderid(User lenderid) {
		this.lenderid = lenderid;
	}
	public User getLendeeid() {
		return lendeeid;
	}
	public void setLendeeid(User lendeeid) {
		this.lendeeid = lendeeid;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public Product getProductid() {
		return productid;
	}
	public void setProductid(Product productid) {
		this.productid = productid;
	}
	public int getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(int finalprice) {
		this.finalprice = finalprice;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCustomer_detail() {
		return customer_detail;
	}
	public void setCustomer_detail(String customer_detail) {
		this.customer_detail = customer_detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getDetail() {
		return detail;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
