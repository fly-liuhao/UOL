<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查询成员</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
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
	        //设置下拉类表框宽度
			$(".select1").uedSelect({
				width : 90
			});
			$(".select2").uedSelect({
				width : 135
			});
		});
	</script>
	
	   
   <script type="text/javascript">  
	   function getDept() {
	       clearDept();
	       var param = {
	           'schoolId' : $("#school").val(),
	           'ram' : Math.random()
	       };
	       $.getJSON("FindDeptBySchoolServlet", param, function(data) {
	           $.each(data, function(index, item) {
	               var op = $("<option>").val(item.deptId).text(item.deptName);
	               $("#department").append(op);
	           });
	       });
	   }
	   function getMajor() {
	       clearMajor();
	       var param = {
               'schoolId' : $("#school").val(),
               'deptId' : $("#department").val(),
               'ram' : Math.random()
	       };
	       $.getJSON("FindMajorByDeptServlet", param, function(data) {
	           $.each(data, function(index, item) {
	               var op = $("<option>").val(item.majorId).text(item.majorName);
	               $("#major").append(op);
	           });
	       });
	   }
	   function clearDept() {
	       $("#department").html("");
	       var pleaseOption = $("<option>").val("").text("院系").prop('selected',true);
	       $("#department").append(pleaseOption);
	   }
       function clearMajor() {
           $("#major").html("");
           var pleaseOption = $("<option>").val("").text("专业").prop('selected',true);
           $("#major").append(pleaseOption);
       }
   </script> 
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="DisplayLabMemberServlet?pageTag=select">查询成员</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div id="usual1" class="usual">
			<!--tab个数定义开始 -->
			<div class="itab">
				<ul>
					<li><a href="#tab2">多条件组合查询</a></li>
				</ul>
			</div>
			<!--tab定义结束-->

			<div id="tab1" class="tabson">
				<ul class="forminfo">
					<li>
						<div class="usercity">
							<form action="SelectLabMemberServlet" method="post">
								<div class="cityleft">
									<input name="memberName" type="text" class="dfinput"
										placeholder="姓名" style="width: 90px" />
								</div>

								<div class="cityleft">
									<input name="phoneNumber" type="text" class="dfinput"
										placeholder="电话" style="width: 90px" />
								</div>

								<div class="cityleft">
									<select class="select2" name="school" id="school" onchange="getDept()">
										<option value="" selected="selected">学校</option>
										<c:forEach items="${schoolList}" var="school">
									        <option value="${school.schoolId}">${school.schoolName}</option>
										</c:forEach>
									</select>
								</div>

								<div class="cityleft">
									<select class="select2" name="department" id="department" onchange="getMajor()">
										<option value="" selected="selected">院系</option>
									</select>
								</div>
								<div class="cityleft">
									<select class="select2" name="major" id="major">
										<option value="" selected="selected">专业</option>
									</select>
								</div>
				                <div class="cityleft">
                                   <select class="select1" name="grade">
                                        <option value="">年级</option>
                                        <option>大一</option>
                                        <option>大二</option>
                                        <option>大三</option>
                                        <option>大四</option>
                                    </select>
                                </div>
								<div class="cityleft">
									<select class="select1" name="status">
										<option value="">状态</option>
										<option>正常</option>
										<option>退出</option>
										<option>毕业</option>
									</select>
								</div>
								<div class="cityleft">
									<select class="select1" name="labJob">
										<option value="">职务</option>
										<option>无</option>
										<option>管理人员</option>
									</select>
								</div>
								<div class="cityleft">
									<select class="select1" name="certificate">
										<option value="">证件</option>
										<option>已领取</option>
										<option>未领取</option>
									</select>
								</div>
								<div class="cityleft">
									<input name="" type="submit" class="scbtn" value="查询" />
								</div>
							</form>
						</div>
					</li>
				</ul>
			</div>


			<div id="tab2" class="tabson">
				<table class="tablelist">
					<thead>
						<tr>

							<th>姓名<i class="sort"><img src="images/px.gif" /></i></th>
							<th>学号</th>
							<th>性别</th>
							<th>年级</th>
							<th>电话</th>
							<th>学校</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${labMemberList}" var="member">
							<tr>
								<td>${member.memberName}</td>
								<td>${member.memberId}</td>
								<td>${member.sex}</td>
								<td>${member.grade}</td>
								<td>${member.phoneNumber}</td>
								<td>${member.schoolName}</td>
								<td><a href="SelectLabMemberByIdServlet?pageTag=display&memberId=${member.memberId}" class="tablelink">详情</a></td>
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
