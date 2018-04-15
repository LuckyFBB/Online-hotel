package com.dao.Impl;

import java.io.InputStream;
import java.util.List;

import com.entity.OrderItems;

public interface OrderDaoImp {
	public boolean addOrder(OrderItems order);
	public boolean payMoney(int orderItemId);
	public boolean updateMessage(int orderItemId);
	public boolean showAddMessage();
	public boolean addMessage(int orderItemId,String buyerMessage);
	public List<OrderItems> showUserOrders(String email);
	public List<OrderItems> showUserShopCart(String email);
	public List<OrderItems> roomMessageList(String roomId);
	public boolean deleteShopCart(int orderItemId);
	public List<OrderItems> showHotelOrders(String hotelId);
	public List<OrderItems> allOrder();
	public InputStream getInputStream(String hotelId);
	public InputStream getInputStream();
}
