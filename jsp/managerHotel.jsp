<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>旅店管理员页面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<style type="text/css">
    a{color: #B4976F;text-decoration: none;}
    a:hover {color: #23527c;text-decoration: none;}
</style>
</head>
<body>
    <div class="container">
        <div id="content" class="row-fluid">
            <div class="col-md-3">
            <<s:iterator value="#session.findManager">
                <h1>管理员</h1>
                <h2><s:property value="managerName"/>,你好</h2>
                <h3>功能</h3>
                <ul class="nav nav-tabs nav-stacked">
                    <li><s:a href="managerHotelList.action">查看所有旅店</s:a></li>
                    <li><s:a href="addHotel.jsp">添加旅店信息</s:a></li>
                    <li><s:a href="allHotelManager.action">查看所有管理员</s:a></li>
                    <li><s:a href="addHotelManager.jsp">添加管理员信息</s:a></li>
                    <li><s:a href="allUser.action">查看所有用户</s:a></li>
                    <li><s:a href="allOrder.action">查看所有订单</s:a></li>
                </ul>   
            </s:iterator>
            </div>
            <div class="col-md-9">
                <h2>信息展示</h2>
                <table class="table table-hover table-striped">
   	        	<caption>房间信息</caption>
   	        	<thead>
					<tr>
						<th>旅店编号</th>
						<th>旅店名字</th>
						<th>旅店所在地</th>
						<th>房间简介</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#session.managerHotelList">
						<tr>
						<td><s:property value="hotelId"/></td>
						<td><s:property value="hotelName"/></td>
						<td><s:property value="city"/></td>
						<td><s:property value="intro"/></td>
						<td><s:a href="findUpdateHotel.action?updateHotelId=%{hotelId}">修改信息</s:a></td>
						<td><s:a href="deleteHotel.action?deleteHotelId=%{hotelId}">删除</s:a>
					</tr>
					</s:iterator>
				</tbody>
			</table>
            </div>
        </div>
    </div>
</body>
</html>