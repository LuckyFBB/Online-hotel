package com.action;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.entity.HotelManagerInfo;
import com.entity.OrderItems;
import com.entity.RoomInfo;
import com.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.service.OrderService;

public class OrderAction {
	@Resource
	OrderService orderService;
	private OrderItems addOrder;
	private int orderItemId;
	private String buyerMessage;
	private String roomId;
	InputStream excelStream;
	
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getBuyerMessage() {
		return buyerMessage;
	}
	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public OrderItems getAddOrder() {
		return addOrder;
	}
	public void setAddOrder(OrderItems addOrder) {
		this.addOrder = addOrder;
	}
	public String addOrderNoPay()
	{
		OrderItems order=new OrderItems();
		@SuppressWarnings("unchecked")
		List<RoomInfo> searchRoom=(List<RoomInfo>) ActionContext.getContext().getSession().get("searchRoom");
		Calendar aCalendar = Calendar.getInstance();
		order.setRoomId(searchRoom.get(0).getRoomId());
		order.setHotelId(searchRoom.get(0).getHotelInfo().getHotelId());
		order.setBeginTime(addOrder.getBeginTime());
		order.setEndTime(addOrder.getEndTime());
		order.setEmail(addOrder.getEmail());
		order.setName(addOrder.getName());
		order.setStatus("未付款");
		order.setBuyerMessage("无");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String begintime=addOrder.getBeginTime();
		String endtime=addOrder.getEndTime();
		try {
			Date beginTime = sdf.parse(begintime);
			Date endTime=sdf.parse(endtime);
		    aCalendar.setTime(beginTime);
		    int begin= aCalendar.get(Calendar.DAY_OF_YEAR);
		    aCalendar.setTime(endTime);
		    int end= aCalendar.get(Calendar.DAY_OF_YEAR);
			order.setTotalPrice(searchRoom.get(0).getPrice()*(end-begin));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(orderService.addOrder(order))
			return "addOrderNoPay";
		return "fail";
	}
	public String addOrderPay()
	{
		OrderItems order=new OrderItems();
		@SuppressWarnings("unchecked")
		List<RoomInfo> searchRoom=(List<RoomInfo>) ActionContext.getContext().getSession().get("searchRoom");
		Calendar aCalendar = Calendar.getInstance();
		order.setRoomId(searchRoom.get(0).getRoomId());
		ActionContext.getContext().getSession().put("updateSaleRoomId", searchRoom.get(0).getRoomId());
		order.setHotelId(searchRoom.get(0).getHotelInfo().getHotelId());
		order.setBeginTime(addOrder.getBeginTime());
		order.setEndTime(addOrder.getEndTime());
		order.setEmail(addOrder.getEmail());
		order.setName(addOrder.getName());
		order.setStatus("已付款");
		order.setBuyerMessage("无");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String begintime=addOrder.getBeginTime();
		String endtime=addOrder.getEndTime();
		try {
			Date beginTime = sdf.parse(begintime);
			Date endTime=sdf.parse(endtime);
		    aCalendar.setTime(beginTime);
		    int begin= aCalendar.get(Calendar.DAY_OF_YEAR);
		    aCalendar.setTime(endTime);
		    int end= aCalendar.get(Calendar.DAY_OF_YEAR);
			order.setTotalPrice(searchRoom.get(0).getPrice()*(end-begin));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(orderService.addOrder(order))
			return "addOrderPay";
		return "fail";
	}
	public String payMoney()
	{
		if(orderService.payMoney(orderItemId))
			return "payMoney";
		return "fail";				
	}
	public String showAddMessage()
	{
		if(orderService.showAddMessage())
		{
			ActionContext.getContext().getSession().put("orderItemId", orderItemId);
			return "showAddMessage";
		}
		return "fail";
	}
	public String addMessage()
	{
		if(buyerMessage!=null)
		{
			if(orderService.addMessage(orderItemId, buyerMessage))
				return "addMessage";
		}
		return "fail";
	}
	public String showUserOrders()
	{
		UserInfo showUser=(UserInfo) ActionContext.getContext().getSession().get("showUser");
		String email=showUser.getEmail();
		List<OrderItems> userOrderList=orderService.showUserOrders(email);
		if(userOrderList!=null)
		{
			ActionContext.getContext().getSession().put("userOrderList", userOrderList);
			return "userOrderList";
		}
		return "fail";
	}
	public String showUserShopCart()
	{
		UserInfo showUser=(UserInfo) ActionContext.getContext().getSession().get("showUser");
		String email=showUser.getEmail();
		List<OrderItems> userShopCartList=orderService.showUserShopCart(email);
		if(userShopCartList!=null)
		{
			ActionContext.getContext().getSession().put("userShopCartList", userShopCartList);
			return "userShopCartList";
		}
		return "fail";
	}
	public String getRoomMessage()
	{
		List<OrderItems> roomMessageList=orderService.roomMessageList(roomId);
		ActionContext.getContext().getSession().put("searchRoomId", roomId);
		ActionContext.getContext().getSession().put("roomMessageList", roomMessageList);
		return "roomMessage";
	}
	public String deleteShopCart()
	{
		if(orderService.deleteShopCart(orderItemId))
			return "deleteShopCart";
		return "fail";
	}
	public String showHotelOrder()
	{
		HotelManagerInfo manager=(HotelManagerInfo) ActionContext.getContext().getSession().get("hotelManager");
		String hotelId=manager.getHotelId();
		List<OrderItems> hotelOrderList=orderService.showHotelOrders(hotelId);
		if(hotelOrderList!=null)
		{
			ActionContext.getContext().getSession().put("hotelOrderList", hotelOrderList);
			return "showHotelOrder";
		}
		return "fail";
	}
	public String allOrder()
	{

		List<OrderItems> allOrderList=orderService.allOrder();
		ActionContext.getContext().getSession().put("allOrderList", allOrderList);
		return "allOrder";
	}
	public String showExcel() 
	{
		HotelManagerInfo manager=(HotelManagerInfo) ActionContext.getContext().getSession().get("hotelManager");
		String hotelId=manager.getHotelId();
		excelStream=orderService.getInputStream(hotelId);
	    return "showExcel";
	}
	public String showOrderExcel() 
	{
		excelStream=orderService.getInputStream();
	    return "showOrderExcel";
	}
}
