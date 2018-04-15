<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>旅店房间</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<script src="js/jquery-3.2.1.js"></script>
<style type="text/css">
    a{color: #B4976F;text-decoration: none;}
    a:hover {color: #23527c;text-decoration: none;}
</style>
<body>
<div class="container">
    <div id="content" class="row-fluid">
        <div class="col-md-3">
        <s:iterator value="#session.hotelManager">
            <h1>管理员</h1>
            <h2><s:property value="staffName"/>,你好</h2>
            <h3>功能</h3>
            <ul class="nav nav-tabs nav-stacked">
                <li><s:a href="hotelManagerFindHotel.action">查看旅店信息</s:a></li>
                <li><s:a href="hotelManagerFindRoom.action">查看旅店房间</s:a></li>
                <li><s:a href="hotelManagerAddRoom.jsp">添加旅店房间</s:a></li>
                <li><s:a href="showHotelOrder.action">查看旅店订单</s:a></li>
            </ul>  
        </s:iterator>
        </div>
   	    <div class="col-md-9">
   	        <h2>信息展示</h2>
   	        <table class="table table-hover table-striped">
   	        	<caption>房间信息</caption>
   	        	<thead>
					<tr>
						<th>房间编号</th>
						<th>房间类型</th>
						<th>房间销量</th>
						<th>房间简介</th>
						<th>房间价格</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#session.roomListByHotelManager">
						<tr>
						<td><s:property value="roomId"/></td>
						<td><s:property value="roomType"/></td>
						<td><s:property value="saleVolumn"/></td>
						<td><s:property value="roomIntro"/></td>
						<td><s:property value="price"/></td>
						<td><s:a href="findUpdateRoom.action?updateRoomId=%{roomId}">修改信息</s:a></td>
						<td><s:a href="deleteRoom.action?deleteRoomId=%{roomId}">删除</s:a>
					</tr>
					</s:iterator>
				</tbody>
			</table>
        </div>
    </div>
</div>
</body>
</html>