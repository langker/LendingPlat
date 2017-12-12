package me.langker.LendingPlat.Controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Dao.SubscribeNotifyDao;
import me.langker.LendingPlat.Dao.SubscriberDao;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.Subscriber;

@Stateless
public class SubscriberController {
	@Inject SubscriberDao subDao;
	@Inject ProductDao pDao;
	@Inject SubscribeNotifyDao snDao;
	public void saveSub(int id, String name) {
		subDao.createSubscribe(id, name);
	}
	public void delSub(int id) {
		subDao.delSubById(id);
	}
	public List<Subscriber> findAllSub(int id) {
		return subDao.findSubByUserId(id);
	}
	public void update(int pid) {
		String pname = pDao.findProductById(pid).getName();
		List<Subscriber> subs = subDao.findSubByName(pname);
		for(Subscriber sub:subs) snDao.createSubscribeNotify(pid, sub.getId(),sub.getUserid());
	}
	public List<Product> findSubProdcut(int id) {
		return subDao.findSubProdcut(id);
	}
}
