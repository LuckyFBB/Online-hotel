<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
~~~~~
	<s:form action="login.action" validate="true" mothed="post">
		<table>
			<s:textfield name="name" label="用户名"></s:textfield>
			<s:password name="password" label="密 码"></s:password>
			<s:textfield name="email" label="电子邮件"></s:textfield>
			<s:submit value="登录" align="center"></s:submit>
		</table>
	</s:form>
</body>
</html>