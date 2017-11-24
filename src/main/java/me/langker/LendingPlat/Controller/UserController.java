package me.langker.LendingPlat.Controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import me.langker.LendingPlat.Dao.UserDao;
import me.langker.LendingPlat.Entity.User; 


@Stateless
public class UserController {  
	@Inject UserDao userdao;
	public User login(String email, String password) throws Exception {
		List<User>res = userdao.findByEmailAndPassword(email, password);
		if (res.size() >= 1) {
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("email",email);
			return res.get(0);
		} else 
			throw new Exception("login failed");
	}
	public Boolean isLogin() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("email")!=null)return true;
		else return false;
	}
	public User reg(String email, String password,String address,String credential) throws Exception {
		if (userdao.findByEmail(email).size() >= 1)  {
			throw new Exception("reg failed");
		} else {
			return userdao.createUser(email, password, address, credential);
		}
	}
}   