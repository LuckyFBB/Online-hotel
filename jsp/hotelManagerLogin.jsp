<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>旅店管理员登录</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
    <div class="container demo-1">
        <div class="content">
            <div id="large-header" class="large-header">
                <canvas id="demo-canvas"></canvas>
                <div class="logo_box">
                    <h3>旅店管理员登录</h3>
                    <s:form action="hotelManagerLogin.action" validate="true" method="post">
                        <div class="input_outer">
                            <span class="u_user"></span>
                            <s:textfield class="text" name="loginHotelManager.staffId" placeholder="请输入管理员ID" style="color:#FFFFFF"></s:textfield>
                        </div>
                        <div class="input_outer">
                            <span class="us_uer"></span>
                            <s:password class="text" name="loginHotelManager.password" placeholder="请输入密码" style="color: #FFFFFF; position:absolute; z-index:100;"></s:password>
                        </div>
                        <div class="mb2"><s:submit class="act-but submit" value="登录" style="color: #FFFFFF"></s:submit></div>
                        <div class="mb2"><input type="reset" value="重置" class="act-but submit theme-login" style="color: #FFFFFF"></div>
                    </s:form>
                </div>
            </div>
        </div>
    </div><!-- /container -->
    <div class="theme-popover-mask"></div>
    <script src="js/TweenLite.min.js"></script>
    <script src="js/EasePack.min.js"></script>
    <script src="js/rAF.js"></script>
    <script src="js/demo-1.js"></script>
    </body>
</html>