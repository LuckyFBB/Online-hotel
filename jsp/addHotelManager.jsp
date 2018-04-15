<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>管理员页面</title>
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
                    <li><s:a href=""></s:a></li>
                </ul>  
            </s:iterator>
            </div>
            <div class="col-md-9">
                <h2>信息展示</h2>
                <s:form action="addHotelManager.action">
					<div class="form-group">
    					<label for="name">旅店管理员编号</label>
    					<s:textfield name="addHotelManager.staffId" class="form-control" placeholder="请输入旅店管理员编号"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">旅店管理员名字</label>
    					<s:textfield name="addHotelManager.staffName" class="form-control" placeholder="请输入旅店管理员名字"></s:textfield>				
    				</div>
    				<div class="form-group">
    					<label for="name">旅店编号</label>
    					<s:select name="addManagerHotelId" class="form-control" list="#session.managerHotelList" listKey="hotelId" listValue="hotelId"></s:select>			
    				</div>
    				<div class="form-group">
    					<label for="name">密码</label>
    					<s:textfield name="addHotelManager.password" class="form-control" placeholder="请输入旅店管理员密码"></s:textfield>				
    				</div>
    				<div class="form-group"><s:submit class="btn btn-default" value="添加旅店管理员"></s:submit></div>
				</s:form>
            </div>
        </div>
    </div>
</body>
</html>