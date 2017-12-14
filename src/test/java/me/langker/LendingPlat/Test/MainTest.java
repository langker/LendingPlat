package me.langker.LendingPlat.Test;

import java.io.File;

import javax.inject.Inject;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.langker.LendingPlat.Entity.User;
import me.langker.LendingPlat.Util.Util;
 
@RunWith(Arquillian.class)
public class MainTest {
 
	Logger log = Logger.getLogger(MainTest.class);
	protected User user;
	protected User u;
	@Deployment
	public static Archive<?> createDeployment() {
		  File[] files = Maven.resolver().loadPomFromFile(Util.getProjectpompath())
			        .importRuntimeDependencies().resolve().withTransitivity().asFile();
		  WebArchive archive = ShrinkWrap.create(WebArchive.class, "TestLendingPlat.war")
			        .addPackages(true, "me.langker.LendingPlat.Controller")
			        .addPackages(true, "me.langker.LendingPlat.Dao")
			        .addPackages(true, "me.langker.LendingPlat.Entity")
			        .addPackages(true, "me.langker.LendingPlat.Util")
			        .addPackages(true, "me.langker.LendingPlat.Viewer")
			        .addPackages(true, "me.langker.LendingPlat.Test")
			        .addAsResource("META-INF/persistence.xml")
			        .addAsLibraries(files)
			        .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
					return archive;
	}
	@Test
	public void testEnv() throws Exception {
	     Assert.assertTrue(true);
	}
	@Inject
	UserTransaction utx;
	
	@Before
	public void startTransaction() throws Exception {
	    utx.begin();
	    user = new User();
	    user.setAddress("Greencampus,Pavia,Italy");
	    user.setCredential("666.jpg");
	    user.setEmail("langker@aliyun.com");
	    user.setName("Xiang Chaoran");
	    user.setPassword("abcd12345");
	    user.setPhone("18995654993");
	}
	@After
	public void rollbackTransaction() throws Exception {
	    utx.rollback();
	}
	
}