package me.langker.LendingPlat.Controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.UserDao;
import me.langker.LendingPlat.Entity.User; 

@Stateless
public class UserController {  
	@Inject UserDao userdao;
	public User login(String email, String password) throws Exception {
		List<User>res = userdao.findByEmailAndPassword(email, password);
		if (res.size() >= 1) return res.get(0);
		else throw new Exception("login failed");
	}
	
	public User reg(String email, String password,String address,String credential) throws Exception {
		if (userdao.findByEmail(email).size() >= 1)  {
			throw new Exception("reg failed");
		} else {
			return userdao.createUser(email, password, address, credential);
		}
	}
}   