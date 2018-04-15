<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>酒店信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="css/home-register-login.css">
<script src="js/jquery-3.2.1.js"></script>
<script>
jQuery(document).ready(function($) {
    $('.updatehotel').click(function(){
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover-updateHotel').slideDown(200);
    })
    $('.theme-poptit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-updateHotel').slideUp(200);
    })
    $('.theme-popover-mask').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-updateHotel').slideUp(100);
    })
})
</script>
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
                	<s:iterator value="#session.hotelManagerFindHotel">
						<caption>旅店信息</caption>
						<tr>
							<th>旅店名字</th>
							<td><s:property value="hotelName"/></td>
						</tr>
						<tr>
							<th>旅店所在地</th>
							<td><s:property value="city"/>
						</tr>
						<tr>
							<th>旅店简介</th>
							<td><s:property value="intro"/></td>
						</tr>
					</s:iterator>
				</table>
				<div class="form-group"><button class="btn btn-default updatehotel">修改旅店信息</button></div>
            </div>
        </div>
    </div>
    <div class="theme-popover-updateHotel">
    <div class="theme-poptit">
        <a href="javascript:;" title="关闭" class="close">×</a>
        <h3>修改信息</h3>
    </div>
    <div class="theme-popbod dform">
        <s:form action="updateHotel.action">
        <s:iterator value="#session.hotelManagerFindHotel">
            <div class="register_input_outer">
                <span class="register_user"></span>
                <s:textfield class="register-text" name="updateHotel.hotelName" value="%{hotelName}" style="color:#FFFFFF"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_pass"></span>
                <s:textfield class="register-text" name="updateHotel.city" value="%{city}" style="color: #FFFFFF; z-index:100;"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_pass"></span>
                <s:textfield class="register-text" name="updateHotel.intro" value="%{intro}" style="color: #FFFFFF; z-index:100;"></s:textfield>
            </div>
            <div class="register_input_outer">
                <s:file class="register-text" name="updateHotel.image" value="%{image}" style="color: #FFFFFF; z-index:100;"></s:file>
            </div>
            <div class="mb2"><s:submit value="修改" class="act-but submit" style="color: #FFFFFF"></s:submit></div>
        </s:iterator>    
        </s:form>
    </div>
</div>
<div class="theme-popover-mask"></div>
</body>
</html>