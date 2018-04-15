package com.service;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import com.dao.OrderDao;
import com.entity.OrderItems;

public class OrderService {
	@Resource 
	OrderDao orderDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public boolean addOrder(OrderItems addOrder)
	{
		return orderDao.addOrder(addOrder);
	}
	public boolean payMoney(int orderItemId)
	{
		return orderDao.payMoney(orderItemId);
	}
	public boolean showAddMessage()
	{
		return orderDao.showAddMessage();
	}
	public boolean addMessage(int orderItemId,String buyerMessage)
	{
		return orderDao.addMessage(orderItemId, buyerMessage); 
	}
	public List<OrderItems> showUserOrders(String email)
	{
		return orderDao.showUserOrders(email);
	}
	public List<OrderItems> showUserShopCart(String email)
	{
		return orderDao.showUserShopCart(email);
	}
	public List<OrderItems> roomMessageList(String roomId)
	{
		return orderDao.roomMessageList(roomId);
	}
	public boolean deleteShopCart(int orderItemId)
	{
		return orderDao.deleteShopCart(orderItemId);
	}
	public List<OrderItems> showHotelOrders(String hotelId) 
	{
		return orderDao.showHotelOrders(hotelId);
	}
	public List<OrderItems> allOrder()
	{
		return orderDao.allOrder();
	}
	public InputStream getInputStream(String hotelId)
	{
		return orderDao.getInputStream(hotelId);
	}
	public InputStream getInputStream()
	{
		return orderDao.getInputStream();
	}
}
