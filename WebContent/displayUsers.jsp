<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.ychs.uol.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 写java代码，tomcat解析 -->
	<%
	    //JSP的语法，写Java代码
	    List<User> userList = (List<User>) request.getAttribute("userList");
	%>
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

		<%
		    for (User user : userList) {
		%>
		<tr>
			<td><%=user.getUserName()%></td>
			<td><%=user.getUserPwd()%></td>
			<td><%=user.getRealName()%></td>
			<td><%=user.getSex()%></td>
			<td><%=user.getJob()%></td>
			<td><%=user.getRemark()%></td>
			<td><%=user.getStatus()%></td>
		</tr>
		<%
		    }
		%>
	</table>
</body>
</html>