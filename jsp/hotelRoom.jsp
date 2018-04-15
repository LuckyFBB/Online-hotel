<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅店房间展示</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> 
    addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/home-register-login.css">
<script src="js/jquery-3.2.1.js"></script>
<script>
jQuery(document).ready(function($) {
    var email=$("#email").text();
    var tag='@';;
    if(email.indexOf(tag)!=-1)
    {
        $(".not-login").css("display","none");
        $(".user").css("display","block");
    }
    $('.theme-register').click(function(){
        $('.theme-popover-login').slideUp(200);
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover-register').slideDown(200);
    })
    $('.theme-poptit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-register').slideUp(200);
    })
    $('.theme-login').click(function(){
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover-login').slideDown(200);
    })
    $('.theme-poptit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-login').slideUp(200);
    })
    $('.login-register').click(function(){
        $('.theme-popover-login').slideUp(200);
        $('.theme-popover-register').fadeIn(100);
    })
    $('.theme-popover-mask').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-register').slideUp(100);
        $('.theme-popover-login').slideUp(100);
    })
})
</script>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="email" style="display:none">
    <s:iterator value="#session.user">
        <s:property value="email"/>
    </s:iterator>
</div>
<div class="banner">
    <div class="container">
        <div class="header-nav">
            <nav class="navbar navbar-default">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="logo">
                        <a class="navbar-brand" href="home.jsp">香香<span>旅店预订</span></a>
                    </div>
                </div>
                <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="home.jsp">首页</a></li>
                        <li><a href="hotelList.action">所有酒店</a></li>
                        <li><a href="#">关于我们</a></li>
                    </ul>
                    <div class="search">
                        <s:a href="showUser.action"><button class="user"><i class="glyphicon glyphicon-user"></i>个人中心</button></s:a>
                        <s:form action="cityHotel.action">
                            <i class="glyphicon glyphicon-search"></i><s:textfield name="city" value="城市名字..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '城市名字...';}" ></s:textfield>
                        </s:form>
                        <div class="not-login">
                            <button class="theme-login">登录</button>
                            <button class="theme-register">注册</button>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <div class="banner-info">
            <h1>欢迎光临本旅店，愿你能够找到你满意的房间。</h1>
            <p>期待您的每一次的到来，我们将抱有最大的热情来为您提供服务，祝您的旅行快乐</p>
        </div>
    </div>
</div>
<div class="banner-bottom">
	<div class="container">
    	<div class="banner-bottom-grids">
       		<s:iterator value="#session.roomListByHotelId" status="status">
            	<div class="col-md-3 banner-bottom-grid">
                	<img src="<s:property value="image"/>" alt=" " class="img-responsive" />
                	<div class="banner-bottom-grid-info">
                    	<div class="col-xs-4 banner-bottom-grid-infol">
                        	<p>0.0<s:property value="#status.count"/></p>
                    	</div>
                    	<div class="col-xs-8 banner-bottom-grid-infor">
                        	<h3>价格<s:property value="price"/></h3>
                    	</div>
                    	<div class="clearfix"></div>
                    	<p class="vel"><s:property value="roomType"/></p>
                    	<div class="more m1"><s:a href="getRoomMessage.action?roomId=%{roomId}">查看详情</s:a></div>
                	</div>
            	</div>
        	</s:iterator>
        <div class="clearfix"></div>
    	</div>
    </div>
</div>
<div class="footer-bottom">
    <div class="container">     
        <p>Copyright &copy; 2017 香香旅店预订</p>         
    </div>
</div>
<div class="theme-popover-register">
    <div class="theme-poptit">
        <a href="javascript:;" title="关闭" class="close">×</a>
        <h3>注册</h3>
    </div>
    <div class="theme-popbod dform">
        <form action="userRegister.action" method="post">
            <div class="register_input_outer">
                <span class="register_user"></span>
                <s:textfield class="register-text" style="color: #FFFFFF" placeholder="请输入姓名" name="registerUser.name"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_email"></span>
                <s:textfield class="register-text" style="color: #FFFFFF" placeholder="请输入邮箱" name="registerUser.email"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_tel"></span>
                <s:textfield class="register-text" style="color: #FFFFFF" placeholder="请输入电话" name="registerUser.telphone"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_nick"></span>
                <s:textfield class="register-text" style="color: #FFFFFF" placeholder="请输入昵称" name="registerUser.nickName"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_pass"></span>
                <s:password class="register-text" style="color: #FFFFFF" placeholder="请输入密码" name="registerUser.password"></s:password>
            </div>
            <div class="register_input_outer">
                <span class="register_pass"></span>
                <s:password class="register-text" style="color: #FFFFFF" placeholder="请确定密码" name="password"></s:password>
            </div>
            <div class="mb2"><s:submit value="注册" class="act-but register_submit" style="color: #FFFFFF"></s:submit></div>
        </form>
    </div>
</div>
<div class="theme-popover-login">
    <div class="theme-poptit">
        <a href="javascript:;" title="关闭" class="close">×</a>
        <h3>登录</h3>
    </div>
    <div class="theme-popbod dform">
        <s:form action="userLogin.action" method="post">
            <div class="register_input_outer">
                <span class="register_user"></span>
                <s:textfield class="register-text" name="loginUser.email" placeholder="请输入账户" style="color:#FFFFFF"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_pass"></span>
                <s:password class="register-text" name="loginUser.password" placeholder="请输入密码" style="color: #FFFFFF; z-index:100;"></s:password>
            </div>
            <div class="mb2"><s:submit value="登录" class="act-but submit" style="color: #FFFFFF"></s:submit></div>
            <div class="mb2"><input type="button" value="注册" class="act-but submit theme-register" style="color: #FFFFFF"></div>
        </s:form>
    </div>
</div>
<div class="theme-popover-mask"></div>
<script src="js/bootstrap.js"></script>
</body>
</html>