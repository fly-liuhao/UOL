<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%
	    String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ path + "/";
	%>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查询创新学分</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	
	<script type="text/javascript">
		KE.show({
			id : 'content7',
			cssPath : './index.css'
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select1").uedSelect({
				width : 345
			});
			$(".select2").uedSelect({
				width : 90
			//设置下拉类表框宽度
			});
			$(".select3").uedSelect({
				width : 100
			});
		});
	</script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="DisplayCreditServlet">查询创新学分</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div id="usual1" class="usual">
			<!--tab个数定义开始 -->
			<div class="itab">
				<ul>
					<li><a href="#tab2">查询创新学分</a></li>
				</ul>
			</div>
			<!--tab定义结束-->

			<div id="tab1" class="tabson">
				<form action="SelectCreditServlet" method="post">
					<ul class="forminfo">
						<li>
							<div class="usercity">
								<div class="cityleft">
									<input name="studentName" type="text" class="dfinput"
										placeholder="姓名" style="width: 90px" />
								</div>

								<div class="cityleft">
									<input name="studentId" type="text" class="dfinput"
										placeholder="学号" style="width: 90px" />
								</div>



								<div class="cityleft">
									<input name="" type="submit" class="scbtn" value="查询" />
								</div>

							</div>
						</li>
					</ul>
				</form>
			</div>


			<div id="tab2" class="tabson">
				<table class="tablelist">
					<thead>
						<tr>
							<th>姓名</th>
							<th>学号</th>
							<th>分值</th>
							<th>日期<i class="sort"><img src="images/px.gif" /></i></th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${creditList}" var="credit">
							<tr>
								<td>${credit.stuName}</td>
								<td>${credit.stuId}</td>
								<td>${credit.score}</td>
								<td>2018-8-8</td>
								<td>${credit.remark}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

		<script type="text/javascript">
			$("#usual1 ul").idTabs();
		</script>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</div>


</body>
</html>
