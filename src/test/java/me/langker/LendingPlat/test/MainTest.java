package me.langker.LendingPlat.test;

import java.io.File;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import me.langker.LendingPlat.Controller.UserController;
 
@RunWith(Arquillian.class)
public class MainTest {
 
//	Logger log = Logger.getLogger(MainTest.class);
	
  @Deployment
  public static Archive<?> createDeployment() {
	  WebArchive archive = ShrinkWrap.create(WebArchive.class, "TestLendingPlat.war")
		        .addPackages(true, "me.langker.LendingPlat.Controller")
		        .addPackages(true, "me.langker.LendingPlat.Dao")
		        .addPackages(true, "me.langker.LendingPlat.Entity")
		        .addPackages(true, "me.langker.LendingPlat.Util")
		        .addPackages(true, "me.langker.LendingPlat.Viewer")
		        .addAsResource("META-INF/persistence.xml").addClass(UserController.class)
		        .addAsWebInfResource(new StringAsset("<faces-config version=\"2.0\"/>"), "faces-config.xml")
		        .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
				
				archive.as(ZipExporter.class).exportTo(
						    new File("target/TestLendingPlat.war"), true);
				
				return archive;
//	  return ShrinkWrap.create(WebArchive.class)
//		      .addPackage("me.langker.LendingPlat.Controller")
//		      .addAsResource("META-INF/persistence.xml");
  	}
	  @Test
	  public void getAllTrickers() throws Exception
	  {
	     Assert.assertTrue(true);
	  }
}