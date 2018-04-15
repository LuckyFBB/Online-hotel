<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>个人中心</title>
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
                <s:form action="findHotelForAddRoom.action">
                <div class="form-group">
    					<label for="name">房间编号</label>
    					<s:iterator value="#session.findHotelForAddRoom">
    					<s:textfield value="%{hotelId}" class="form-control" readonly="true"></s:textfield>
    					</s:iterator>				
    				</div>
					<div class="form-group">
    					<label for="name">房间编号</label>
    					<s:textfield name="addRoom.roomId" class="form-control" placeholder="请输入房间编号(旅店编号+房间号)"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">房间类型</label>
    					<s:textfield name="addRoom.roomType" class="form-control" placeholder="请输入房间类型"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">房间价格</label>
    					<s:textfield name="addRoom.price" class="form-control" placeholder="请输入房间价格"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">房间简介</label>
    					<s:textfield name="addRoom.roomIntro" class="form-control" placeholder="请输入房间简介"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">房间图片</label>
    					<s:file name="addRoom.image" class="form-control" placeholder="请上传房间图片"></s:file>		
    				</div>
    				<div class="form-group"><s:submit class="btn btn-default" value="添加房间"></s:submit></div>
				</s:form>
            </div>
        </div>
    </div>
</body>
</html>