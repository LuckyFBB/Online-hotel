package com.service;

import java.util.List;

import javax.annotation.Resource;

import com.dao.RoomDao;
import com.entity.RoomInfo;

public class RoomService {
	@Resource 
	RoomDao roomDao;
	public RoomDao getRoomDao() {
		return roomDao;
	}
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	public List<RoomInfo> roomList()
	{
		return roomDao.roomList();
	}
	public List<RoomInfo> searchRoom(String searchRoomId)
	{
		return roomDao.searchRoom(searchRoomId);
	}
	public List<RoomInfo> findRoomByHotelId(String hotelId)
	{
		return roomDao.findRoomByHotelId(hotelId);
	}
	public boolean addRoom(RoomInfo addRoom)
	{
		return roomDao.addRoom(addRoom);
	}
	public boolean updateRoom(RoomInfo updateRoom)
	{
		return roomDao.updateRoom(updateRoom);
	}
	public boolean deleteRoom(String roomId)
	{
		return roomDao.deleteRoom(roomId);
	}
	public boolean updateSaleVolume(String roomId)
	{
		return roomDao.updateSaleVolume(roomId);
	}
}
