package me.langker.LendingPlat.Entity;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String email;
	private String password;
	private boolean isAdmin;
	private String credential;
	private String address;

    public int getId() {
        return id;
    }
    public void setId(int id) {
		this.id = id;
	}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
		this.email = email;
	}
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
		this.password = password;
	}
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
    public String getCredential() {
        return credential;
    }
    public void setCredential(String credential) {
		this.credential = credential;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
