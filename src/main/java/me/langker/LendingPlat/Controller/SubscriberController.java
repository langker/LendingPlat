package me.langker.LendingPlat.Controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import me.langker.LendingPlat.Dao.ProductDao;
import me.langker.LendingPlat.Dao.SubscribeNotifyDao;
import me.langker.LendingPlat.Dao.SubscriberDao;
import me.langker.LendingPlat.Entity.Product;
import me.langker.LendingPlat.Entity.Subscriber;
import me.langker.LendingPlat.Util.Util;

@Stateless
public class SubscriberController {
	@Inject SubscriberDao subDao;
	@Inject ProductDao pDao;
	@Inject SubscribeNotifyDao snDao;
	public void saveSub(String name) {
		subDao.createSubscribe(Util.getInstance().getUserId(), name);
	}
	public void delSub(int id) {
		subDao.delSubById(id);
	}
	public List<Subscriber> findAllSub() {
		return subDao.findSubByUserId(Util.getInstance().getUserId());
	}
	public void update(int pid) {
		String pname = pDao.findProductById(pid).getName();
		List<Subscriber> subs = subDao.findSubByName(pname);
		for(Subscriber sub:subs) snDao.createSubscribeNotify(pid, sub.getId(),sub.getUserid());
	}
	public List<Product> findSubProdcut() {
		return subDao.findSubProdcut(Util.getInstance().getUserId());
	}
}
