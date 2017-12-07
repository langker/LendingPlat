package me.langker.LendingPlat.Controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import me.langker.LendingPlat.Dao.UserDao;
import me.langker.LendingPlat.Entity.User;
import me.langker.LendingPlat.Util.Util; 


@Stateless
public class UserController {  
	@Inject UserDao userdao;
	public User login(String email, String password) {
		List<User>res = userdao.findByEmailAndPassword(email, password);
		if (res.size() >= 1) {
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("userid",res.get(0).getId());
			return res.get(0);
		} else 
			return null;
	}
	public Boolean isLogin() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("userid")!=null)return true;
		else return false;
	}
	public void logout() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("userid", null);
	}
	public User reg(String email, String password,String address,String name, String phone) {
		if (userdao.findByEmail(email).size() >= 1)  {
			return null;
		} else {
			return userdao.createUser(email, password, address, name,phone);
		}
	}
	public void updateProfile(String address,String name, String phone) {
		userdao.updateProfile(Util.getInstance().getUserId(), address,name,phone);
	}
	public void updateCred(String filename) {
		userdao.updateCred(Util.getInstance().getUserId(), filename);
	}
	public User findUserProfile() {
		return userdao.findUserProfile(Util.getInstance().getUserId());
	}
	public User findUserProfileById(int id) {
		return userdao.findUserProfile(id);
	}
	public List<User> findAllUser() {
		return userdao.findAllUser();
	}
}   