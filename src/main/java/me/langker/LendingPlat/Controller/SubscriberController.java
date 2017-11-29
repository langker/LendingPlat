package me.langker.LendingPlat.Controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import me.langker.LendingPlat.Dao.SubscriberDao;
import me.langker.LendingPlat.Entity.Subscriber;
import me.langker.LendingPlat.Util.Util;

@Stateless
public class SubscriberController {
	@Inject SubscriberDao subDao;
	public void saveSub(String name) {
		subDao.createSubscribe(Util.getInstance().getUserId(), name);
	}
	public void delSub(int id) {
		subDao.delSubById(id);
	}
	public List<Subscriber> findAllSub() {
		return subDao.findSubByUserId(Util.getInstance().getUserId());
	}
}
