package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Impl.HotelDaoImp;
import com.entity.HotelInfo;
@Service @Transactional
public class HotelDao implements HotelDaoImp{
	@Resource
	SessionFactory sessionFactory;
	@Override
	public List<HotelInfo> allHotel() {
		String hql="from HotelInfo hotel";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<HotelInfo> hotelList=query.list();
		return hotelList;
	}
	@Override
	public HotelInfo findHotel(String hotelId) {
		// TODO Auto-generated method stub
		HotelInfo hotel=(HotelInfo) sessionFactory.getCurrentSession().get(HotelInfo.class, hotelId);
		return hotel;
	}
	@Override
	public List<HotelInfo> cityHotel(String city) {
		// TODO Auto-generated method stub
		String hql="from HotelInfo as hotel where hotel.city=:city";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("city", city);
		@SuppressWarnings("unchecked")
		List<HotelInfo> cityHotelList=query.list();
		return cityHotelList;
	}
	@Override
	public boolean updateHotel(HotelInfo hotel) {
		// TODO Auto-generated method stub
		String hql="update HotelInfo as hotel set hotel.city=:city,hotel.hotelName=:hotelName,hotel.image=:image,hotel.intro=:intro where hotel.hotelId=:hotelId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("city", hotel.getCity());
		query.setString("hotelName", hotel.getHotelName());
		query.setString("intro", hotel.getIntro());
		query.setString("image",hotel.getImage());
		query.setString("hotelId", hotel.getHotelId());
		System.out.println(hotel.getHotelId());
		if(query.executeUpdate()!=0)
			return true;
		return false;
	}
	@Override
	public boolean addHotel(HotelInfo addHotel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(addHotel);
		return true;
	}
}
