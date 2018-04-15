package com.entity;

import java.io.Serializable;

public class RoomInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String roomType;//房间类型
	private String roomId;//房间编号
	private double price;//价格
	private String hotelId;//旅店编号
	private int saleVolumn;//销量
	private String image;//房间图片
	private String roomIntro;//房间介绍
	private HotelInfo hotelInfo;
	public RoomInfo(){}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getSaleVolumn() {
		return saleVolumn;
	}
	public void setSaleVolumn(int saleVolumn) {
		this.saleVolumn = saleVolumn;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}
	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	public String getRoomIntro() {
		return roomIntro;
	}
	public void setRoomIntro(String roomIntro) {
		this.roomIntro = roomIntro;
	}
}
