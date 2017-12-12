package me.langker.LendingPlat.Test;


import java.util.List;

import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.User;

@RunWith(Arquillian.class)
public class UserTest extends MainTest {
	
	@Inject UserController uc;
	
	@Before
	public void init() {
	   uc.reg(user.getEmail(), user.getPassword(), user.getAddress(), user.getName(), user.getPhone());
	}
	
	@Test
	public void testReg() {
		User u =  uc.reg(user.getEmail(), user.getPassword(), user.getAddress(), user.getAddress(), user.getPhone());
		Assert.assertTrue(u==null);
		u =uc.reg("langker@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		Assert.assertTrue(u!=null);
	}
	@Test
	public void testLogin() {
		User u = uc.login(user.getEmail(), user.getPassword());
		Assert.assertTrue(u!=null);
	}
	@Test
	public void testUpdateProfile() {
		User u = uc.login("langker@aliyun.com", "abcd12345");
		uc.updateProfile(u.getId(), "Wuhan,China", "Xiang Chaoran", "18995654993");
		User u1 = uc.findUserProfile(u.getId());
		
		Assert.assertTrue(u1.getAddress().equals("Wuhan,China"));
		Assert.assertTrue(u1.getName().equals("Xiang Chaoran"));
		Assert.assertTrue(u1.getPhone().equals("18995654993"));
	}
	@Test
	public void testUpdateCred() {
		User u = uc.login("langker@aliyun.com", "abcd12345");
		uc.updateCred(u.getId(), "666.jpg");
		User u1 = uc.findUserProfile(u.getId());
		
		Assert.assertTrue(u1.getCredential().equals("666.jpg"));
	}
	@Test
	public void testFindUserProfile() {
		User u = uc.login("langker@aliyun.com", "abcd12345");
		User u1 = uc.findUserProfile(u.getId());
		
		Assert.assertTrue(u1.getEmail().equals(user.getEmail()));
		Assert.assertTrue(u1.getAddress().equals(user.getAddress()));
		Assert.assertTrue(u1.getName().equals(user.getName()));
		Assert.assertTrue(u1.getPhone().equals(user.getPhone()));
	}
	@Test
	public void testFindAllUser() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		uc.reg("langker@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		uc.reg("langker@163.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		List<User> u = uc.findAllUser();
		
		Assert.assertTrue(!u.isEmpty());
	}
}

