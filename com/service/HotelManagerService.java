package com.service;

import java.util.List;

import javax.annotation.Resource;

import com.dao.HotelManagerDao;
import com.entity.HotelManagerInfo;

public class HotelManagerService {
	@Resource
	HotelManagerDao hotelManagerDao;
	public HotelManagerDao getHotelManagerDao() {
		return hotelManagerDao;
	}

	public void setHotelManagerDao(HotelManagerDao hotelManagerDao) {
		this.hotelManagerDao = hotelManagerDao;
	}
	public boolean login(HotelManagerInfo hotelManager)
	{
		return hotelManagerDao.login(hotelManager);
	}
	public HotelManagerInfo searchManager(String staffId)
	{
		return hotelManagerDao.searchManager(staffId);
	}
	public List<HotelManagerInfo> allHotelManager()
	{
		return hotelManagerDao.allHotelManager();
	}
	public boolean addHotelManager(HotelManagerInfo hotelManager,String hotelId)
	{
		return hotelManagerDao.addHotelManager(hotelManager, hotelId);
	}
}
