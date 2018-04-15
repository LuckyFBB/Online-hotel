package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.entity.HotelInfo;
import com.entity.HotelManagerInfo;
import com.entity.RoomInfo;
import com.opensymphony.xwork2.ActionContext;
import com.service.RoomService;

public class RoomAction {
	@Resource
	RoomService roomService;
	private String hotelIdForRoom;
	private RoomInfo addRoom;
	private RoomInfo updateRoom;
	private String deleteRoomId;
	private String updateRoomId;
	private String updateSaleRoomId;
	public String getUpdateSaleRoomId() {
		return updateSaleRoomId;
	}
	public void setUpdateSaleRoomId(String updateSaleRoomId) {
		this.updateSaleRoomId = updateSaleRoomId;
	}
	public String getUpdateRoomId() {
		return updateRoomId;
	}
	public void setUpdateRoomId(String updateRoomId) {
		this.updateRoomId = updateRoomId;
	}
	public String getDeleteRoomId() {
		return deleteRoomId;
	}
	public void setDeleteRoomId(String deleteRoomId) {
		this.deleteRoomId = deleteRoomId;
	}
	public RoomInfo getUpdateRoom() {
		return updateRoom;
	}
	public void setUpdateRoom(RoomInfo updateRoom) {
		this.updateRoom = updateRoom;
	}
	public RoomInfo getAddRoom() {
		return addRoom;
	}
	public void setAddRoom(RoomInfo addRoom) {
		this.addRoom = addRoom;
	}
	public String getHotelIdForRoom() {
		return hotelIdForRoom;
	}
	public void setHotelIdForRoom(String hotelIdForRoom) {
		this.hotelIdForRoom = hotelIdForRoom;
	}
	public String roomList()
	{
		List<RoomInfo> roomList =roomService.roomList();
		ActionContext.getContext().getSession().put("roomList", roomList);
		return "success";
	}
	public String searchRoom()
	{	
		String searchRoomId=(String) ActionContext.getContext().getSession().get("searchRoomId");
		List<RoomInfo> searchRoom=roomService.searchRoom(searchRoomId);
		ActionContext.getContext().getSession().put("searchRoom", searchRoom);
		return "success";
	}
	public String findRoomByHotelId()
	{
		List<RoomInfo> roomListByHotelId=roomService.findRoomByHotelId(hotelIdForRoom);
		ActionContext.getContext().getSession().put("roomListByHotelId", roomListByHotelId);
		return "success";
	}
	public String addRoom()
	{
		HotelInfo hotel=(HotelInfo) ActionContext.getContext().getSession().get("findHotelForAddRoom");
		addRoom.setHotelInfo(hotel);
		addRoom.setSaleVolumn(0);
		addRoom.setImage("img/"+addRoom.getImage());
		System.out.println(addRoom.getImage()+addRoom.getPrice()+addRoom.getRoomId()+addRoom.getSaleVolumn());
		if(roomService.addRoom(addRoom))
			return "addRoom";
		return "fail";
	}
	public String hotelManagerFindRoom()
	{
		HotelManagerInfo manager=(HotelManagerInfo) ActionContext.getContext().getSession().get("hotelManager");
		String hotelId=manager.getHotelId();
		List<RoomInfo> roomListByHotelManager=roomService.findRoomByHotelId(hotelId);
		ActionContext.getContext().getSession().put("roomListByHotelManager", roomListByHotelManager);
		return "roomListByHotelManager";
	}
	public String updateRoom()
	{
		updateRoom.setImage("img/"+updateRoom.getImage());
		if(roomService.updateRoom(updateRoom))
			return "updateRoom";
		return "fail";
	}
	public String deleteRoom()
	{
		if(roomService.deleteRoom(deleteRoomId))
			return "deleteRoom";
		return "fail";
	}
	public String findUpdateRoom()
	{
		List<RoomInfo> updateRoom=roomService.searchRoom(updateRoomId);
		ActionContext.getContext().getSession().put("updateRoom", updateRoom);
		return "findUpdateRoom";
	}
	public String updateSaleVolumn()
	{
		String roomId=(String) ActionContext.getContext().getSession().get("updateSaleRoomId");
		if(roomService.updateSaleVolume(roomId))
			return "updateSaleVolumn";
		return "fail";
	}
}
