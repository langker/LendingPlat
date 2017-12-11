package me.langker.LendingPlat.test;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
 
@RunWith(Arquillian.class)
public class MainTest {
 
	Logger log = Logger.getLogger(MainTest.class);
	
  @Deployment
  public static Archive<?> createDeployment() {
	  File[] files = Maven.resolver().loadPomFromFile("/Users/langker/code/pavia-research/LendingPlat/pom.xml")
		        .importRuntimeDependencies().resolve().withTransitivity().asFile();
	  WebArchive archive = ShrinkWrap.create(WebArchive.class, "TestLendingPlat.war")
		        .addPackages(true, "me.langker.LendingPlat.Controller")
		        .addPackages(true, "me.langker.LendingPlat.Dao")
		        .addPackages(true, "me.langker.LendingPlat.Entity")
		        .addPackages(true, "me.langker.LendingPlat.Util")
		        .addPackages(true, "me.langker.LendingPlat.Viewer")
		        .addPackages(true, "me.langker.LendingPlat.test")
//		        .addAsWebInfResource(new StringAsset("<faces-config version=\"2.0\"/>"), "faces-config.xml")
		        .addAsResource("META-INF/persistence.xml")
		        .addAsLibraries(files)
		        .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
				return archive;
  	}
	  @Test
	  public void getAllTrickers() throws Exception
	  {
	     Assert.assertTrue(true);
	  }
}