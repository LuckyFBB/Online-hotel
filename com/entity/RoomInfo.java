package com.entity;

import java.io.Serializable;

public class RoomInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String roomType;//��������
	private String roomId;//������
	private double price;//�۸�
	private String hotelId;//�õ���
	private int saleVolumn;//����
	private String image;//����ͼƬ
	private String roomIntro;//�������
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
