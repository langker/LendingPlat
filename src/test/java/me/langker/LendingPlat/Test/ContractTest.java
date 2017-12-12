package me.langker.LendingPlat.Test;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.ProductController;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.Contract;
import me.langker.LendingPlat.Entity.ContractHistory;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.User;

@RunWith(Arquillian.class)
public class ContractTest extends MainTest {

	@Inject UserController uc;
	@Inject ProductController pc;
	@Inject ContractController cc;
	
	@Test
	public void testAddContract() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		List<Contract> c = cc.getUserCon(lender.getId());
		
		Assert.assertTrue(c!=null);
	}
	@Test
	public void testGetUserCon() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		List<Contract> c = cc.getUserCon(lender.getId());
		
		Assert.assertTrue(c!=null);
	}
	@Test
	public void testGetAllCon() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		List<Contract> c = cc.getAllCon();
		
		Assert.assertTrue(c!=null);
	}
	@Test
	public void testGetConById() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		Contract c = cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		Contract cs = cc.getConById(c.getId());
		
		Assert.assertTrue(cs!=null);
	}
	@Test
	public void testSetConStatus() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		Contract c = cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		cc.setConStatus(c.getId(), 1);
		Contract cs = cc.getConById(c.getId());
		
		Assert.assertTrue(cs.getStatus()==1);
	}
	@Test
	public void testUpdateContract() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		Contract c = cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		cc.updateContract(c.getId(), "20+", 30, "italy", "666", "wqeqweqweqw");
		Contract cs = cc.getConById(c.getId());
		
		Assert.assertTrue(cs.getAge().equals("20+"));
		Assert.assertTrue(cs.getFinalprice()==30);
		Assert.assertTrue(cs.getLocation().equals("italy"));
		Assert.assertTrue(cs.getCustomer_detail().equals("666"));
		Assert.assertTrue(cs.getLenderSignature().equals("wqeqweqweqw"));
	}
	@Test
	public void testUpdateLendeeSign() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		Contract c = cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		cc.updateLendeeSign(c.getId(), "qweasdzxc");
		Contract cs = cc.getConById(c.getId());
		
		Assert.assertTrue(cs.getLendeeSignature().equals("qweasdzxc"));
	}
	@Test
	public void testGetConHistory() {
		uc.reg("langker@aliyun.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		uc.reg("179656046@qq.com", "abcd12345", "Greencampus,Pavia,Italy", "Xiang Chaoran", "3393391450");
		User lender = uc.login("langker@aliyun.com", "abcd12345");
		User lendee = uc.login("179656046@qq.com", "abcd12345");
		
		Product p = pc.addProduct("byt car", 100, "rubbish", true, lender.getId(), "666.jpg");
		Contract c = cc.addContract(p.getId(), lender.getId(), 10, new Date(), lendee.getId());
		List<ContractHistory> ch= cc.getConHistory(c.getId());
		
		Assert.assertTrue(ch!=null);
	}
}
