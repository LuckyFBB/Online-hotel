package com.action;
import java.util.List;
import javax.annotation.Resource;
import com.entity.HotelManagerInfo;
import com.opensymphony.xwork2.ActionContext;
import com.service.HotelManagerService;

public class HotelManagerAction {
	@Resource 
	HotelManagerService hotelManagerService;
	private HotelManagerInfo loginHotelManager;
	private HotelManagerInfo addHotelManager;
	private String addManagerHotelId;
	public String getAddManagerHotelId() {
		return addManagerHotelId;
	}
	public void setAddManagerHotelId(String addManagerHotelId) {
		this.addManagerHotelId = addManagerHotelId;
	}
	public HotelManagerInfo getAddHotelManager() {
		return addHotelManager;
	}
	public void setAddHotelManager(HotelManagerInfo addHotelManager) {
		this.addHotelManager = addHotelManager;
	}
	public HotelManagerInfo getLoginHotelManager() {
		return loginHotelManager;
	}
	public void setLoginHotelManager(HotelManagerInfo loginHotelManager) {
		this.loginHotelManager = loginHotelManager;
	}
	public String login()
	{
		if(hotelManagerService.login(loginHotelManager))
			return "loign_success";
		return "loign_fail";
	}
	@SuppressWarnings("unused")
	public String searchManager()
	{
		String staffId=loginHotelManager.getStaffId();
		HotelManagerInfo hotelmanager=hotelManagerService.searchManager(staffId);
		HotelManagerInfo hotelManager=new HotelManagerInfo();
		hotelManager.setHotelId(hotelmanager.getHotelInfo().getHotelId());
		hotelManager.setStaffName(hotelmanager.getStaffName());
		System.out.println(hotelManager.getHotelId());
		ActionContext.getContext().getSession().put("hotelManager", hotelManager);
		if(hotelManager!=null)
			return "searchManager";
		return "fail";
	}
	public String allHotelManager()
	{
		List<HotelManagerInfo> allHotelManager=hotelManagerService.allHotelManager();
		if(allHotelManager!=null)
		{
			ActionContext.getContext().getSession().put("allHotelManager", allHotelManager);
			return "allHotelManager";
		}
		return "fail";
	}
	public String addHotelManager()
	{
		if(hotelManagerService.addHotelManager(addHotelManager, addManagerHotelId))
			return "addHotelManager";
		return "fail";
	}
}
