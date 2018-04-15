package com.dao.Impl;

import java.util.List;

import com.entity.RoomInfo;

public interface RoomDaoImp {
	public List<RoomInfo> roomList();
	public List<RoomInfo> searchRoom(String searchRoomId); 
	public boolean addRoom(RoomInfo addRoom);
	public List<RoomInfo> findRoomByHotelId(String HotelId);
	public boolean updateRoom(RoomInfo updateRoom);
	public boolean deleteRoom(String roomId);
	public boolean updateSaleVolume(String roomId);
}
