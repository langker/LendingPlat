package me.langker.LendingPlat.test;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Dao.UserDao;
import me.langker.LendingPlat.Entity.User;

@RunWith(Arquillian.class)
public class UserTest extends MainTest {
	
	@Inject UserController uc;
	@Inject UserDao ud;
	@Test
	public void testName() {
		User u = ud.createUser("langke@123.com", "qwe", "qwe", "xiang", "666");
		Assert.assertEquals(null,u);
	}
}

