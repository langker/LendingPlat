package me.langker.LendingPlat.Test;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Controller.SubscriberController;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.Subscriber;
import me.langker.LendingPlat.Entity.User;

@RunWith(Arquillian.class)
public class SubscriberTest extends MainTest {
	
	@Inject SubscriberController sc;
	@Inject UserController uc;
	@Inject ProductController pc;
	
	@Test
	public void testSaveSub() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		User u = uc.login("langker@aliyun.com", "abcd12345");
		sc.saveSub(u.getId(), "car");
		List<Subscriber> s = sc.findAllSub(u.getId());
		Assert.assertTrue(!s.isEmpty());
	}
	
	@Test
	public void testDelSub() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		User u = uc.login("langker@aliyun.com", "abcd12345");
		sc.saveSub(u.getId(), "car");
		List<Subscriber> s = sc.findAllSub(u.getId());
		sc.delSub(s.get(0).getId());
		s = sc.findAllSub(u.getId());
		Assert.assertTrue(s.isEmpty());
	}
	
	@Test
	public void testFindAllSub() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		User u = uc.login("langker@aliyun.com", "abcd12345");
		sc.saveSub(u.getId(), "car");
		List<Subscriber> s = sc.findAllSub(u.getId());
		Assert.assertTrue(!s.isEmpty());
	}
	
	@Test
	public void testFindSubProdcut() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		User u = uc.login("langker@aliyun.com", "abcd12345");
		sc.saveSub(u.getId(), "car");
		pc.addProduct("byt car", 100, "rubbish", true, u.getId(), "666.jpg");
		List<Product>p = sc.findSubProdcut(u.getId());
		Assert.assertTrue(!p.isEmpty());
	}
	
	@Test
	public void testUpdate() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Chaoran Xiang", "3393391450");
		User u = uc.login("langker@aliyun.com", "abcd12345");
		sc.saveSub(u.getId(), "car");
		pc.addProduct("byt car", 100, "rubbish", true, u.getId(), "666.jpg");
		List<Product>p = sc.findSubProdcut(u.getId());
		Assert.assertTrue(!p.isEmpty());
	}
	
}
