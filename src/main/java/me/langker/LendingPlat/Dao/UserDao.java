package me.langker.LendingPlat.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import me.langker.LendingPlat.Entity.User;

@Stateless
public class UserDao {
	@PersistenceContext
	private EntityManager em;
	
	public List<User> findByEmailAndPassword(String email, String password) {
		String sql = "Select * from User where email='"+email+"' and password='"+password+"'";
		return (List<User>)em.createNativeQuery(sql, User.class).getResultList();
	}
	public List<User> findByEmail(String email) {
		String sql = "Select * from User where email="+email;
		return (List<User>)em.createNativeQuery(sql, User.class).getResultList();
	}
	public User createUser(String email, String password, String address, String credential) {
		User user = new User();
		user.setAddress(address);
		user.setCredential(credential);
		user.setEmail(email);
		user.setIsAdmin(false);
		user.setPassword(password);
		em.persist(user);
		return user;
	}
	public User findUserProfile(String email) {
		String sql = "Select * from User where email="+email;
		return (User)em.createNativeQuery(sql, User.class).getSingleResult();
	}
}
