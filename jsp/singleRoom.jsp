<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房间详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> 
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/home-register-login.css">
<script src="js/jquery-3.2.1.js"></script>
<script>
jQuery(document).ready(function($) {
    $('.theme-shopCart').click(function(){
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover-shopcart').slideDown(100);
    })
    $('.theme-poptit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-shopcart').slideUp(100);
    })
    $('.theme-popover-mask').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-shopcart').slideUp(100);
    })
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
</head>
<body>
<div id="email" style="display:none">
    <s:iterator value="#session.user">
        <s:property value="email"/>
    </s:iterator>
</div>
<div class="banner1">
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
	</div>
</div>
<div class="single">
	<div class="container">
		<div class="blog-pag page">
		<s:iterator value="#session.searchRoom">
			<div class="blog-page-grids">
				<div class="blog-page-grid">
					<h3><s:property value="roomIntro"/></h3>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="blog-page-grids-bottom">
					<div class="blog-page-grids-bot">
						<img src="<s:property value="image"/>" alt=" " class="img-responsive" />
					</div>
					<div class="blog-page-grids-bot1">
						<h4 class="media-heading">价格：<span><s:property value="price"/></span></h4>
						<p>类别：<span><s:property value="roomType"/></span></p>
						<ul>
							<li><button class="theme-shopCart"><i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i>预订房间</button></li>
						</ul>
					</div>
			</div>
			</s:iterator>
		</div>
		<div class="com">
			<h3>顾客评价</h3>
			<ul class="media-list">
			<s:iterator value="#session.roomMessageList">
				<li class="media">
					<div class="media-body">
						<h4 class="media-heading"><s:property value="name"/></h4>
				  		<s:property value="buyerMessage"/>
					</div>
				</li>
			</s:iterator>
			</ul>
		</div>
	</div>
</div>
<div class="theme-popover-shopcart">
	<div class="theme-poptit">
		<a href="javascript:;" title="关闭" class="close">×</a>
		<h3>预订房间</h3>
	</div>
    <div class="theme-popbod dform">
    	<s:form action="addOrder.action" method="post">
			<div class="register_input_outer">
				<span class="register_user"></span>
				<s:textfield class="register-text" name="addOrder.name" placeholder="请输入姓名" style="color:#FFFFFF"></s:textfield>
			</div>
			<div class="register_input_outer">
				<span class="register_email"></span>
				<s:textfield class="register-text" name="addOrder.email" placeholder="请输入邮箱" style="color: #FFFFFF"></s:textfield>
			</div>
			<div class="register_input_outer">
				<span class="register_nick"></span>
				<input type="date" class="register-text" name="addOrder.beginTime" placeholder="请输入入住时间" style="color: #FFFFFF">
			</div>
			<div class="register_input_outer">
				<span class="register_nick"></span>
				<input type="date" class="register-text" name="addOrder.endTime" placeholder="请输入退房时间" style="color: #FFFFFF">
			</div>
			<div class="mb2"><s:submit value="添加到购物车" name="addOrderNoPay" method="addOrderNoPay" class="act-but submit" style="color: #FFFFFF"></s:submit></div>
			<div class="mb2"><s:submit value="立即付款" name="addOrderPay" method="addOrderPay" class="act-but submit" style="color: #FFFFFF"></s:submit></div>
		</s:form>
    </div>
</div>
<div class="theme-popover-mask"></div>
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
<script src="js/bootstrap.js"> </script>
</body>
</html>