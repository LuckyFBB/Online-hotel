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
            <s:iterator value="#session.findManager">
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
                <s:form action="managerUpdateHotel.action">
                <s:iterator value="#session.updateHotel">
					<div class="form-group">
    					<label for="name">旅店编号</label>
    					<s:textfield name="updateHotel.hotelId" value="%{hotelId}" class="form-control" readonly="true"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">旅店名字</label>
    					<s:textfield name="updateHotel.hotelName" value="%{hotelName}" class="form-control" placeholder="请输入房间类型"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">旅店所在地</label>
    					<s:textfield name="updateHotel.city" value="%{city}" class="form-control" placeholder="请输入房间价格"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">旅店简介</label>
    					<s:textfield name="updateHotel.intro" value="%{intro}" class="form-control" placeholder="请输入房间简介"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">旅店图片</label>
    					<s:file name="updateHotel.image" value="%{image}" class="form-control" placeholder="请上传房间图片"></s:file>		
    				</div>
    				<div class="form-group"><s:submit class="btn btn-default" value="更新旅店信息"></s:submit></div>
    			</s:iterator>
				</s:form>
            </div>
        </div>
    </div>
</body>
</html>