package me.langker.LendingPlat.Controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import me.langker.LendingPlat.Dao.UserDao;
import me.langker.LendingPlat.Entity.User;



@Stateless
public class UserController {  
	@Inject UserDao userdao;
	public User login(String email, String password) {
		List<User>res = userdao.findByEmailAndPassword(email, password);
		if (res.size() >= 1) {
			return res.get(0);
		} else 
			return null;
	}
	public User reg(String email, String password,String address,String name, String phone) {
		if (userdao.findByEmail(email).size() >= 1)  {
			return null;
		} else {
			return userdao.createUser(email, password, address, name,phone);
		}
	}
	public void updateProfile(int id,String address,String name, String phone) {
		userdao.updateProfile(id, address,name,phone);
	}
	public void updateCred(int id,String filename) {
		userdao.updateCred(id, filename);
	}
	public User findUserProfile(int id) {
		return userdao.findUserProfile(id);
	}
	public List<User> findAllUser() {
		return userdao.findAllUser();
	}
}   