package com.dao.Impl;
import java.util.List;

import com.entity.HotelManagerInfo;

public interface HotelManagerDaoImp {
	public boolean login(HotelManagerInfo hotelManager);
	public HotelManagerInfo searchManager(String staffId);
	public List<HotelManagerInfo> allHotelManager();
	public boolean addHotelManager(HotelManagerInfo hotelManager,String hotelId);
}
