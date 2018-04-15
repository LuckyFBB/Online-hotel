package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class HotelInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String hotelId;//�õ���
	private String hotelName;//�õ�����
	private String city;//�õ��ַ
	private String intro;//�õ���
	private String image; //�õ�ͼƬ
	private Set <HotelManagerInfo>hotelManagerInfo=new HashSet<HotelManagerInfo>();
	private Set <RoomInfo>roomInfo=new HashSet<RoomInfo>();
	public HotelInfo(){}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<HotelManagerInfo> getHotelManagerInfo() {
		return hotelManagerInfo;
	}
	public void setHotelManagerInfo(Set<HotelManagerInfo> hotelManagerInfo) {
		this.hotelManagerInfo = hotelManagerInfo;
	}
	public Set<RoomInfo> getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(Set<RoomInfo> roomInfo) {
		this.roomInfo = roomInfo;
	}
}
