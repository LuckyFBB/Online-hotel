package com.action;

import java.util.List;
import javax.annotation.Resource;
import com.entity.HotelInfo;
import com.entity.HotelManagerInfo;
import com.opensymphony.xwork2.ActionContext;
import com.service.HotelService;

public class HotelAction {

	@Resource
	HotelService hotelService;
	private String hotelId;
	private String city;
	private HotelInfo updateHotel;
	private HotelInfo addHotel;
	private String updateHotelId;
	public String getUpdateHotelId() {
		return updateHotelId;
	}
	public void setUpdateHotelId(String updateHotelId) {
		this.updateHotelId = updateHotelId;
	}
	public HotelInfo getAddHotel() {
		return addHotel;
	}
	public void setAddHotel(HotelInfo addHotel) {
		this.addHotel = addHotel;
	}
	public HotelInfo getUpdateHotel() {
		return updateHotel;
	}
	public void setUpdateHotel(HotelInfo updateHotel) {
		this.updateHotel = updateHotel;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String hotelList()
	{
		List<HotelInfo> hotelList =hotelService.allHotel();
		ActionContext.getContext().getSession().put("hotelList", hotelList);
		return "success";
	}
	public String findHotel()
	{
		HotelInfo hotel=hotelService.findHotel(hotelId);
		ActionContext.getContext().getSession().put("hotel",hotel);
		return "hotel";
	}
	public String cityHotel()
	{
		List<HotelInfo> cityHotelList=hotelService.cityHotel(city);
		if(cityHotelList!=null)
		{
			ActionContext.getContext().getSession().put("cityHotelList",cityHotelList);
			return "cityHotel";
		}
		return "fail";
	}
	public String hotelManagerFindHotel()
	{
		HotelManagerInfo manager=(HotelManagerInfo) ActionContext.getContext().getSession().get("hotelManager");
		String hotelId=manager.getHotelId();
		HotelInfo hotelManagerFindHotel=hotelService.findHotel(hotelId);
		ActionContext.getContext().getSession().put("hotelManagerFindHotel", hotelManagerFindHotel);
		return "hotelManagerFindHotel";
	}
	public String findHotelForAddRoom()
	{
		HotelManagerInfo manager=(HotelManagerInfo) ActionContext.getContext().getSession().get("hotelManager");
		String hotelId=manager.getHotelId();
		HotelInfo findHotelForAddRoom=hotelService.findHotel(hotelId);
		ActionContext.getContext().getSession().put("findHotelForAddRoom", findHotelForAddRoom);
		return "findHotelForAddRoom";
	}
	public String updateHotel()
	{
		HotelManagerInfo manager=(HotelManagerInfo) ActionContext.getContext().getSession().get("hotelManager");
		String hotelId=manager.getHotelId();
		updateHotel.setHotelId(hotelId);
		updateHotel.setImage("img/"+updateHotel.getImage());
		if(hotelService.updateHotel(updateHotel))
			return "updateHotel";
		return "fail";
	}
	public String managerHotelList()
	{
		List<HotelInfo> managerHotelList =hotelService.allHotel();
		ActionContext.getContext().getSession().put("managerHotelList", managerHotelList);
		return "managerHotel";
	}
	public String addHotel()
	{
		addHotel.setImage("img/"+addHotel.getImage());
		if(hotelService.addHotel(addHotel))
			return "addHotel";
		return "fail";
	}
	public String findUpdateHotel()
	{
		HotelInfo updateHotel=hotelService.findHotel(updateHotelId);
		ActionContext.getContext().getSession().put("updateHotel", updateHotel);
		return "updateHotel";
	}
	public String managerUpdateHotel()
	{
		updateHotel.setImage("img/"+updateHotel.getImage());
		System.out.println(updateHotel.getImage());
		hotelService.updateHotel(updateHotel);
		System.out.println(updateHotel.getCity()+updateHotel.getHotelId()+updateHotel.getIntro());
		return "managerUpdateHotel";
	}
}
