package me.langker.LendingPlat.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Contract {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int lenderid;
    private int lendeeid;
    private String detail;
    private Date startDate;
    private int term;
    private int productid;
    private int finalprice;
    private String location;
    private String age;
    @Column(length=65535) 
    private String customer_detail;
    @Column(length=65535) 
    private String lenderSignature;
    @Column(length=65535) 
    private String lendeeSignature;
    //0:close or error or lender refuse to lend
    //1:waiting for lender
    //2:lender agree to lend the product and make the contract
    //3:lendee agree the contract
    //4:lender send the product to the lendee
    //5:lendee receive the product and the product is not available for others
    //6:lendee return the product to the lender
    //7:lender receive the product and the whole progress finish
    private int status;
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
		this.id = id;
	}
	public int getLenderid() {
		return lenderid;
	}
	public void setLenderid(int lenderid) {
		this.lenderid = lenderid;
	}
	public int getLendeeid() {
		return lendeeid;
	}
	public void setLendeeid(int lendeeid) {
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
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
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
	public String getLenderSignature() {
		return lenderSignature;
	}
	public void setLenderSignature(String lenderSignature) {
		this.lenderSignature = lenderSignature;
	}
	public String getLendeeSignature() {
		return lendeeSignature;
	}
	public void setLendeeSignature(String lendeeSignature) {
		this.lendeeSignature = lendeeSignature;
	}
}
