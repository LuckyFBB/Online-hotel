package com.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Impl.OrderDaoImp;
import com.entity.OrderItems;
import com.entity.RoomInfo;

@Service @Transactional
public class OrderDao implements OrderDaoImp{
	@Resource
	SessionFactory sessionFactory;

	@Override
	public boolean addOrder(OrderItems order) {
		sessionFactory.getCurrentSession().save(order);
		return true;
	}

	@Override
	public boolean payMoney(int orderItemId) {
		// TODO Auto-generated method stub
		OrderItems order=(OrderItems) sessionFactory.getCurrentSession().get(OrderItems.class, orderItemId);
		order.setStatus("已付款");
		sessionFactory.getCurrentSession().update(order);
		return true;
		/*String hql="update OrderItems as order set order.status=:status where orderItemId=:orderItemId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("orderItemId", orderItemId);
		query.setString("status", "已付款");
		if(query.executeUpdate()!=0)
			return true;
		return false;*/
	}

	@Override
	public boolean updateMessage(int orderItemId) {
		// TODO Auto-generated method stub
		OrderItems order=(OrderItems) sessionFactory.getCurrentSession().get(OrderItems.class, orderItemId);
		order.setStatus("已付款");
		sessionFactory.getCurrentSession().update(order);
		return true;
	}

	@Override
	public boolean showAddMessage() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addMessage(int orderItemId, String buyerMessage) {
		// TODO Auto-generated method stub
		OrderItems order=(OrderItems) sessionFactory.getCurrentSession().get(OrderItems.class, orderItemId);
		order.setBuyerMessage(buyerMessage);
		sessionFactory.getCurrentSession().update(order);
		return true;
	}
	
	@Override
	public List<OrderItems> showUserOrders(String email) {
		// TODO Auto-generated method stub
		String hql="from OrderItems as order where order.email=:email and order.status=:status";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("email", email);
		query.setString("status", "已付款");
		@SuppressWarnings("unchecked")
		List<OrderItems> userOrderList=query.list();
		for(int i=0;i<userOrderList.size();i++)
		{
			String roomId=userOrderList.get(i).getRoomId();
			RoomInfo room=(RoomInfo) sessionFactory.getCurrentSession().get(RoomInfo.class, roomId);
			userOrderList.get(i).setHotelId(room.getHotelInfo().getHotelId());
			userOrderList.get(i).setRoomType(room.getRoomType());
		}
		return userOrderList;
	}
	
	@Override
	public List<OrderItems> showUserShopCart(String email) {
		// TODO Auto-generated method stub
		String hql="from OrderItems as order where order.email=:email and order.status=:status";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("email", email);
		query.setString("status", "未付款");
		@SuppressWarnings("unchecked")
		List<OrderItems> userShopCartList=query.list();
		for(int i=0;i<userShopCartList.size();i++)
		{
			String roomId=userShopCartList.get(i).getRoomId();
			RoomInfo room=(RoomInfo) sessionFactory.getCurrentSession().get(RoomInfo.class, roomId);
			userShopCartList.get(i).setHotelId(room.getHotelInfo().getHotelId());
			userShopCartList.get(i).setRoomType(room.getRoomType());
		}
		return userShopCartList;
	}

	@Override
	public List<OrderItems> roomMessageList(String roomId) {
		// TODO Auto-generated method stub
		String hql="from OrderItems as order where order.roomId=:roomId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("roomId",roomId);
		@SuppressWarnings("unchecked")
		List<OrderItems> roomMessageList=query.list();
		return roomMessageList;
	}

	@Override
	public boolean deleteShopCart(int orderItemId) {
		// TODO Auto-generated method stub
		OrderItems order=(OrderItems) sessionFactory.getCurrentSession().get(OrderItems.class, orderItemId);
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	@Override
	public List<OrderItems> showHotelOrders(String hotelId) {
		// TODO Auto-generated method stub
		String hql="from OrderItems as order where order.hotelId=:hotelId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("hotelId", hotelId);
		@SuppressWarnings("unchecked")
		List<OrderItems> hotelOrderList=query.list();
		return hotelOrderList;
	}

	@Override
	public List<OrderItems> allOrder() {
		// TODO Auto-generated method stub
		String hql="from OrderItems as order";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<OrderItems> allOrderList=query.list();
		return allOrderList;
	}
	

	@Override
	public InputStream getInputStream(String hotelId) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook();
	       HSSFSheet sheet=wb.createSheet("sheet1");
	       HSSFRow row = sheet.createRow(0);
	       HSSFCell cell=row.createCell((short)0);
	       cell.setCellValue("序号");
	       cell=row.createCell((short)1);
	       cell.setCellValue("姓名");
	       cell=row.createCell((short)2);;
	       cell.setCellValue("邮箱");
	       cell=row.createCell((short)3);
	       cell.setCellValue("房间编号");
	       cell=row.createCell((short)4);
	       cell.setCellValue("入住时间");
	       cell=row.createCell((short)5);
	       cell.setCellValue("退房时间");
	       cell=row.createCell((short)6);
	       cell.setCellValue("消费金额");
	       cell=row.createCell((short)7);
	       cell.setCellValue("留言");
	       List<OrderItems> hotelOrderList=showHotelOrders(hotelId);
	       for(int i=0;i<hotelOrderList.size();i++)
	       {
	    	   row=sheet.createRow(i+1);
	           cell=row.createCell((short)0);
	           cell.setCellValue(i+1);
	           cell=row.createCell((short)1);
	           cell.setCellValue(hotelOrderList.get(i).getName());
	           cell=row.createCell((short)2);
	           cell.setCellValue(hotelOrderList.get(i).getEmail());
	           cell=row.createCell((short)3);
	           cell.setCellValue(hotelOrderList.get(i).getRoomId());
		       cell=row.createCell((short)4);
		       cell.setCellValue(hotelOrderList.get(i).getBeginTime());
		       cell=row.createCell((short)5);
		       cell.setCellValue(hotelOrderList.get(i).getEndTime());
		       cell=row.createCell((short)6);
		       cell.setCellValue(hotelOrderList.get(i).getTotalPrice());
		       cell=row.createCell((short)7);
		       cell.setCellValue(hotelOrderList.get(i).getBuyerMessage());
	       }
	       ByteArrayOutputStream os=new ByteArrayOutputStream();
	       try {
	           wb.write(os);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       byte[] content=os.toByteArray();
	       InputStream is=new ByteArrayInputStream(content);
	       return is;
	}

	@Override
	public InputStream getInputStream() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook();
	       HSSFSheet sheet=wb.createSheet("sheet1");
	       HSSFRow row = sheet.createRow(0);
	       HSSFCell cell=row.createCell((short)0);
	       cell.setCellValue("序号");
	       cell=row.createCell((short)1);
	       cell.setCellValue("姓名");
	       cell=row.createCell((short)2);;
	       cell.setCellValue("邮箱");
	       cell=row.createCell((short)3);
	       cell.setCellValue("旅店编号");
	       cell=row.createCell((short)4);
	       cell.setCellValue("房间编号");
	       cell=row.createCell((short)5);
	       cell.setCellValue("入住时间");
	       cell=row.createCell((short)6);
	       cell.setCellValue("退房时间");
	       cell=row.createCell((short)7);
	       cell.setCellValue("消费金额");
	       cell=row.createCell((short)8);
	       cell.setCellValue("留言");
	       List<OrderItems> orderList=allOrder();
	       for(int i=0;i<orderList.size();i++)
	       {
	    	   row=sheet.createRow(i+1);
	           cell=row.createCell((short)0);
	           cell.setCellValue(i+1);
	           cell=row.createCell((short)1);
	           cell.setCellValue(orderList.get(i).getName());
	           cell=row.createCell((short)2);
	           cell.setCellValue(orderList.get(i).getEmail());
	           cell=row.createCell((short)3);
	           cell.setCellValue(orderList.get(i).getHotelId());
		       cell=row.createCell((short)4);
		       cell.setCellValue(orderList.get(i).getRoomId());
		       cell=row.createCell((short)5);
		       cell.setCellValue(orderList.get(i).getBeginTime());
		       cell=row.createCell((short)6);
		       cell.setCellValue(orderList.get(i).getEndTime());
		       cell=row.createCell((short)7);
		       cell.setCellValue(orderList.get(i).getTotalPrice());
		       cell=row.createCell((short)8);
		       cell.setCellValue(orderList.get(i).getBuyerMessage());
	       }
	       ByteArrayOutputStream os=new ByteArrayOutputStream();
	       try {
	           wb.write(os);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       byte[] content=os.toByteArray();
	       InputStream is=new ByteArrayInputStream(content);
	       return is;
	}
}
