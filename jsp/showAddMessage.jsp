<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>添加评价</title>
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
            <s:iterator value="#session.showUser">
                <h1>个人中心</h1>
                <h2><s:property value="nickName"/>,你好</h2>
                <h3>功能</h3>
                <ul class="nav nav-tabs nav-stacked">
                    <li><s:a href="showUser.jsp">查看个人信息</s:a></li>
                    <li><s:a href="showUserShopCart.action">查看购物车</s:a></li>
                    <li><s:a href="showUserOrders.action">查看订单</s:a></li>
                    <li><s:a href="home.jsp">返回</s:a></li>
                </ul>  
            </s:iterator>
            </div>
            <div class="col-md-9">
                <h2>添加评价</h2>
                <s:form>
					<div class="form-group">
    					<s:textarea class="form-control" name="buyerMessage"></s:textarea>			
    				</div>
    				<div class="form-group"><s:a href="addMessage.action?orderItemId=%{orderItemId}" class="btn btn-default">添加评价</s:a></div>
				</s:form>
            </div>
        </div>
    </div>
</body>
</html>