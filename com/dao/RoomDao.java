package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Impl.RoomDaoImp;
import com.entity.RoomInfo;
@Service @Transactional
public class RoomDao implements RoomDaoImp{
	@Resource
	SessionFactory sessionFactory;
	@Override
	public List<RoomInfo> roomList() {
		// TODO Auto-generated method stub
		String hql="from RoomInfo room";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<RoomInfo> roomList=query.list();
		return roomList;
	}
	@Override
	public List<RoomInfo> searchRoom(String searchRoomId) {
		String hql="from RoomInfo as room where room.roomId=:roomId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("roomId", searchRoomId);
		@SuppressWarnings("unchecked")
		List <RoomInfo> searchRoomResult=query.list();
		return searchRoomResult;
	}
	@Override
	public boolean addRoom(RoomInfo addRoom) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(addRoom);
		return true;
	}
	@Override
	public List<RoomInfo> findRoomByHotelId(String hotelId) {
		String hql="from RoomInfo room where room.HotelInfo.hotelId=:hotelId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("hotelId", hotelId);
		@SuppressWarnings("unchecked")
		List<RoomInfo> roomListByHotelId=query.list();
		return roomListByHotelId;
	}
	@Override
	public boolean updateRoom(RoomInfo updateRoom) {
		// TODO Auto-generated method stub
		String hql="update RoomInfo as room set room.price=:price,room.roomType=:roomType,room.image=:image,room.roomIntro=:intro where room.roomId=:roomId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setDouble("price", updateRoom.getPrice());
		query.setString("roomType", updateRoom.getRoomType());
		query.setString("intro", updateRoom.getRoomIntro());
		query.setString("image",updateRoom.getImage());
		query.setString("roomId", updateRoom.getRoomId());
		if(query.executeUpdate()!=0)
			return true;
		return false;
	}
	@Override
	public boolean deleteRoom(String roomId) {
		// TODO Auto-generated method stub
		RoomInfo room=(RoomInfo) sessionFactory.getCurrentSession().get(RoomInfo.class, roomId);
		sessionFactory.getCurrentSession().delete(room);
		return true;
	}
	@Override
	public boolean updateSaleVolume(String roomId) {
		// TODO Auto-generated method stub
		String hql="update RoomInfo as room set room.saleVolumn=room.saleVolumn+1 where room.roomId=:roomId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("roomId", roomId);
		if(query.executeUpdate()!=0)
			return true;
		return false;
	}
}
