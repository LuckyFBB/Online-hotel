<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>旅店订单</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<style type="text/css">
    a{color: #B4976F;}
</style>
</head>
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
                	<caption>订单信息</caption>
                	<thead>
						<tr>
							<th>订家姓名</th>
							<th>房间编号</th>
							<th>入住时间</th>
							<th>退房时间</th>
							<th>交易价格</th>
							<th>订家留言</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="#session.hotelOrderList">
						<tr>
							<td><s:property value="name"/></td>
							<td><s:property value="roomId"/></td>
							<td><s:property value="beginTime"/></td>
							<td><s:property value="endTime"/></td>
							<td><s:property value="totalPrice"/></td>
							<td><s:property value="buyerMessage"/></td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
				<div class="form-group"><s:a href="showExcel.action" class="btn btn-default">产生订单报表</s:a></div>
            </div>
        </div>
    </div>
</body>
</html>