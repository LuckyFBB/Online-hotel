package com.dao;

import java.util.Iterator;
import java.util.*;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Impl.HotelManagerDaoImp;
import com.entity.HotelInfo;
import com.entity.HotelManagerInfo;
import com.entity.ManagerInfo;
@Service @Transactional
public class HotelManagerDao implements HotelManagerDaoImp{
	@Resource
	SessionFactory sessionFactory;
	@Override
	public boolean login(HotelManagerInfo hotelManager) {
		// TODO Auto-generated method stubString id=manager.getManagerId();
		String id=hotelManager.getStaffId();
		String pass=hotelManager.getPassword();
		String hql="from HotelManagerInfo as m where m.staffId=:id and m.password=:pass";
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
	@Override
	public HotelManagerInfo searchManager(String staffId) {
		// TODO Auto-generated method stub
		HotelManagerInfo hotelManager=(HotelManagerInfo) sessionFactory.getCurrentSession().get(HotelManagerInfo.class, staffId);
		return hotelManager;
	}
	@Override
	public List<HotelManagerInfo> allHotelManager() {
		// TODO Auto-generated method stub
		String hql="from HotelManagerInfo as hotelManager";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<HotelManagerInfo> allHotelManager=query.list();
		for(int i=0; i<allHotelManager.size();i++)
		{
			allHotelManager.get(i).setHotelId(allHotelManager.get(i).getHotelInfo().getHotelId());
		}
		return allHotelManager;
	}
	@Override
	public boolean addHotelManager(HotelManagerInfo hotelManager, String hotelId) {
		// TODO Auto-generated method stub
		HotelInfo hotel=(HotelInfo) sessionFactory.getCurrentSession().get(HotelInfo.class, hotelId);
		hotelManager.setHotelInfo(hotel);
		sessionFactory.getCurrentSession().save(hotelManager);
		return true;
	}
}
