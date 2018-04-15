package com.service;

import java.util.List;

import javax.annotation.Resource;

import com.dao.HotelDao;
import com.entity.HotelInfo;

public class HotelService {
	@Resource 
	HotelDao hotelDao;
	public HotelDao getHotelDao() {
		return hotelDao;
	}
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}
	public List<HotelInfo> allHotel()
	{
		return hotelDao.allHotel();
	}
	public HotelInfo findHotel(String hotelId)
	{
		return hotelDao.findHotel(hotelId);
	}
	public List<HotelInfo> cityHotel(String city)
	{
		return hotelDao.cityHotel(city);
	}
	public boolean updateHotel(HotelInfo hotel)
	{
		return hotelDao.updateHotel(hotel);
	}
	public boolean addHotel(HotelInfo addHotel)
	{
		return hotelDao.addHotel(addHotel);
	}
}
