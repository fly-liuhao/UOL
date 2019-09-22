<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>添加院系</title>
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
				width : 167
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
			<li><a href="SchoolManagementServlet?pageTag=addDepartment">添加院系</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div id="usual1" class="usual">
			<div id="tab1" class="tabson">
				<form action="AddDepartmentServlet" method="post">
					<ul class="forminfo">
						<li><label>学校名称<b>*</b></label>
							<div class="vocation">
								<select name="schoolId" class="select1">
								    <option value="" selected="selected">请选择</option>
                                    <c:forEach items="${schoolList}" var="school">
                                       <option value="${school.schoolId}">${school.schoolName}</option>
                                    </c:forEach>
								</select>
							</div></li>

						<li><label>院系名称<b>*</b></label><input name="departmentName"
							type="text" class="dfinput" placeholder="请输入院系名称"
							style="width: 342px;" /></li>


						<li><label>备注<b>*</b></label> <textarea id="content7"
								name="remark"
								style="width: 700px; height: 250px; visibility: hidden;"></textarea>

						</li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="确认添加" /></li>
					</ul>
				</form>
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
