package com.entity;

import java.io.Serializable;

public class HotelManagerInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String staffId;//Ô±¹¤±àºÅ
	private String staffName;//Ô±¹¤Ãû×Ö
	private String hotelId;//ÂÃµê±àºÅ
	private String password;//µÇÂ¼ÃÜÂë
	private HotelInfo hotelInfo;
	public HotelManagerInfo(){}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}
	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
}
