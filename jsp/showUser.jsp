<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>用户信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="css/home-register-login.css">
<style type="text/css">
    a{color: #B4976F;}
</style>
<script src="js/jquery-3.2.1.js"></script>
<script>
jQuery(document).ready(function($) {
    $('.theme-update').click(function(){
        $('.theme-popover-mask').fadeIn(100);
        $('.theme-popover-update').slideDown(100);
    })
    $('.theme-poptit .close').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-update').slideUp(100);
    })
    $('.theme-popover-mask').click(function(){
        $('.theme-popover-mask').fadeOut(100);
        $('.theme-popover-update').slideUp(100);
    })
})
</script>
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
            <h2>信息展示</h2>
            <table class="table table-hover table-striped">
                <s:iterator value="#session.showUser">
                    <tr>
                        <td class="col-md-2">邮箱：</td>
                        <td class="col-md-6"><s:property value="email"/></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><s:property value="name"/></td>
                    </tr>
                    <tr>
                        <td>昵称：</td>
                        <td><s:property value="nickName"/></td>
                    </tr>
                    <tr>
                        <td>电话：</td>
                        <td><s:property value="telphone"/></td>
                    </tr>
                </s:iterator>
            </table>
            <div class="form-group"><input type="button" class="btn btn-default theme-update" value="修改信息"></div>
        </div>
    </div>
</div>
<div class="theme-popover-update">
    <div class="theme-poptit">
        <a href="javascript:;" title="关闭" class="close">×</a>
        <h3>修改个人信息</h3>
    </div>
    <div class="theme-popbod dform">
        <s:form action="updateUser.action" method="post">
            <s:iterator value="#session.showUser">
            <div class="register_input_outer">
                <span class="register_email"></span>
                <s:textfield class="register-text" value="%{email}" name="updateUser.email" readonly="true" style="color: #FFFFFF;"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_user"></span>
                <s:textfield class="register-text" value="%{name}" name="updateUser.name" style="color:#FFFFFF"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_nick"></span>
                <s:textfield class="register-text" value="%{telphone}" name="updateUser.telphone" style="color:#FFFFFF"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_nick"></span>
                <s:textfield class="register-text" value="%{nickName}" name="updateUser.nickName" style="color:#FFFFFF"></s:textfield>
            </div>
            <div class="register_input_outer">
                <span class="register_nick"></span>
                <s:textfield class="register-text" value="%{password}" name="updateUser.password" style="color:#FFFFFF"></s:textfield>
            </div>
            </s:iterator>
            <div class="mb2"><s:submit value="修改" class="act-but submit" style="color: #FFFFFF"></s:submit></div>
        </s:form>
    </div>
</div>
<div class="theme-popover-mask"></div>
</body>
</html>