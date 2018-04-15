<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/register.css">
<script src="js/jquery-3.2.1.js"></script>
<script>
jQuery(document).ready(function($) {
	$('.theme-login').click(function(){
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	})
	$('.theme-poptit .close').click(function(){
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	})
})
</script>
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>香香酒店预订系统，欢迎你</h3>
					<s:form action="userLogin.action" method="post">
						<div class="input_outer">
							<span class="u_user"></span>
							<s:textfield class="text" name="loginUser.email" placeholder="请输入账户" style="color:#FFFFFF"></s:textfield>
						</div>
						<div class="input_outer">
							<span class="us_uer"></span>
							<s:password class="text" name="loginUser.password" placeholder="请输入密码" style="color: #FFFFFF; position:absolute; z-index:100;"></s:password>
						</div>
						<div class="mb2"><s:submit value="登录" class="act-but submit" style="color: #FFFFFF"></s:submit></div>
						<div class="mb2"><input type="button" value="注册" class="act-but submit theme-login" style="color: #FFFFFF"></div>
					</s:form>
				</div>
			</div>
		</div>
	</div><!-- /container -->
	<div class="theme-popover">
     	<div class="theme-poptit">
       		<a href="javascript:;" title="关闭" class="close">×</a>
			<h3>注册</h3>
		</div>
		<div class="theme-popbod dform">
			<s:form action="userRegister.action" method="post">
				<div class="register_input_outer">
					<span class="register_user"></span>
					<s:textfield class="register-text" style="color: #FFFFFF" name="registerUser.name" placeholder="请输入姓名"></s:textfield>
				</div>
				<div class="register_input_outer">
					<span class="register_email"></span>
					<s:textfield class="register-text" style="color: #FFFFFF" name="registerUser.email" placeholder="请输入邮箱"></s:textfield>
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
			</s:form>
     	</div>
	</div>
	<div class="theme-popover-mask"></div>
	<script src="js/TweenLite.min.js"></script>
	<script src="js/EasePack.min.js"></script>
	<script src="js/rAF.js"></script>
	<script src="js/demo-1.js"></script>
	</body>
</html>