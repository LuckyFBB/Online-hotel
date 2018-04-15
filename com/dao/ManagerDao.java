package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Impl.ManagerDaoImp;
import com.entity.ManagerInfo;

@Service @Transactional
public class ManagerDao implements ManagerDaoImp{
	@Resource
	SessionFactory sessionFactory;
	@Override
	public ManagerInfo find(String managerId) {
		// TODO Auto-generated method stub
		return (ManagerInfo) sessionFactory.getCurrentSession().get(ManagerInfo.class, managerId);
	}
	@Override
	public boolean login(ManagerInfo manager) {
		// TODO Auto-generated method stub
		String id=manager.getManagerId();
		String pass=manager.getPassword();
		String hql="from ManagerInfo as m where m.managerId=:id and m.password=:pass";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("id", id);
		query.setString("pass", pass);
		@SuppressWarnings("unchecked")
		List<ManagerInfo> result=query.list();
		Iterator<ManagerInfo> it=result.iterator();
		if(it.hasNext())
			return true;
		return false;
	}
}
