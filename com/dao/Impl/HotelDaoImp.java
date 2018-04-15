package com.dao.Impl;

import java.util.List;

import com.entity.HotelInfo;

public interface HotelDaoImp {
	public List<HotelInfo> allHotel(); 
	public HotelInfo findHotel(String hotelId);
	public List<HotelInfo> cityHotel(String city);
	public boolean updateHotel(HotelInfo hotel);
	public boolean addHotel(HotelInfo addHotel);
}
