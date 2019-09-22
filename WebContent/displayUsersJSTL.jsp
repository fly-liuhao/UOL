<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" align="center">
		<tr>
			<th>用户名</th>
			<th>用户密码</th>
			<th>真实姓名</th>
			<th>性别</th>
			<th>工作</th>
			<th>备注</th>
			<th>状态</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.getUserName()}</td>
				<td>${user.getUserPwd()}</td>
				<td>${user.getRealName()}</td>
				<td>${user.getSex()}</td>
				<td>${user.getJob()}</td>
				<td>${user.getRemark()}</td>
				<td>${user.getStatus()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>