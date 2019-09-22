<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
</head>
<body>
	<form action="AddUserServlet" method="post">
		用户名<input type="text" name="username" /><br /> 
		密码<input type="password" name="userpwd" /><br /> 
		真实姓名<input type="text" name="realname" /><br /> 
		性别<input type="radio" name="sex" value="male" checked="checked"/>男 
		    <input type="radio" name="sex" value="female" />女<br />
		职务<input type="text" name="job" /><br /> 
		备注<input type="text" name="remark" /><br /> 
		状态<input type="radio" name="status" value="1" checked="checked"/>启用
		    <input type="radio" name="status" value="0" />禁用<br /> 
	    <input type="submit" value="添加用户">

	</form>
</body>
</html>