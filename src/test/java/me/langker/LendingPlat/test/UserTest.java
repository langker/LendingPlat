package me.langker.LendingPlat.test;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.User;

@RunWith(Arquillian.class)
public class UserTest extends MainTest {
	
	@Inject UserController uc;
	
	@PersistenceContext
	EntityManager em;
	@Test
	public void testName() {
		Assert.assertEquals(true, em!=null);
	}
}

