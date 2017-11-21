package me.langker.LendingPlat.Entity;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String email;
	private String password;
	private Boolean isAdmin;
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
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
//		result = prime * result + ((credential== null) ? 0 : credential.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		
		return true;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
