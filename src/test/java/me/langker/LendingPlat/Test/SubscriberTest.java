package me.langker.LendingPlat.Test;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Controller.SubscriberController;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.Subscriber;

@RunWith(Arquillian.class)
public class SubscriberTest extends MainTest {
	
	@Inject SubscriberController sc;
	@Inject UserController uc;
	@Inject ProductController pc;
	
	@Before
	public void init() {
	   uc.reg(user.getEmail(), user.getPassword(), user.getAddress(), user.getName(), user.getPhone());
	   u = uc.login(user.getEmail(), user.getPassword());
	}
	
	@Test
	public void testSaveSub() {
		sc.saveSub(u.getId(), "car");
		List<Subscriber> s = sc.findAllSub(u.getId());
		Assert.assertTrue(!s.isEmpty());
	}
	
	@Test
	public void testDelSub() {
		sc.saveSub(u.getId(), "car");
		List<Subscriber> s = sc.findAllSub(u.getId());
		sc.delSub(s.get(0).getId());
		s = sc.findAllSub(u.getId());
		Assert.assertTrue(s.isEmpty());
	}
	
	@Test
	public void testFindAllSub() {
		sc.saveSub(u.getId(), "car");
		List<Subscriber> s = sc.findAllSub(u.getId());
		Assert.assertTrue(!s.isEmpty());
	}
	
	@Test
	public void testFindSubProdcut() {
		sc.saveSub(u.getId(), "car");
		pc.addProduct("byt car", 100, "rubbish", true, u.getId(), "666.jpg");
		List<Product>p = sc.findSubProdcut(u.getId());
		Assert.assertTrue(!p.isEmpty());
	}
	
	@Test
	public void testUpdate() {
		sc.saveSub(u.getId(), "car");
		pc.addProduct("byt car", 100, "rubbish", true, u.getId(), "666.jpg");
		List<Product>p = sc.findSubProdcut(u.getId());
		Assert.assertTrue(!p.isEmpty());
	}
	
}
