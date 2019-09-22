<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>注册实验室成员</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script src="js/laydate/laydate.js"></script>

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
           var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
           $("#department").append(pleaseOption);
       }
       function clearMajor() {
           $("#major").html("");
           var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
           $("#major").append(pleaseOption);
       }
   </script> 
    
 
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="index.jsp">首页</a></li>
        <li><a href="SchoolManagementServlet?pageTag=addMember">注册实验室成员</a></li>
    </ul>
</div>

<div class="formbody">


    <div id="usual1" class="usual">


        <div id="tab1" class="tabson">
	        <form action="AddLabMemberServlet" method="post">
	            <ul class="forminfo">
	                <li><label>姓名<b>*</b></label><input name="studentName" type="text" class="dfinput" placeholder="请输入姓名"  style="width:342px;"/></li>
	                <li><label>学号<b>*</b></label><input name="studentId" type="text" class="dfinput" placeholder="请输入学号"  style="width:342px;"/></li>
	                <li><label>性别</label><cite><input name="sex" type="radio" value="男" checked="checked" />男
	                    &nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" type="radio" value="女" />女</cite></li>
	                <li><label>年级<b>*</b></label><input name="grade" type="text" class="dfinput" placeholder="请输入年级"  style="width:342px;"/></li>
	                <li><label>籍贯<b>*</b></label><input name="nation" type="text" class="dfinput" placeholder="请输入籍贯"  style="width:342px;"/></li>
	                <li><label>电话<b>*</b></label><input name="mobile" type="text" class="dfinput" placeholder="请输入电话"  style="width:342px;"/></li>
	                <li><label>邮箱<b>*</b></label><input name="email" type="text" class="dfinput" placeholder="请输入邮箱"  style="width:342px;"/></li>
	
	                <li><label>学校<b>*</b></label>
	                <div class="vocation">
	                    <select class="select1" name="school" id="school" onchange="getDept()">
	                        <option value="" selected="selected">请选择</option>
	                        <c:forEach items="${schoolList}" var="school">
                                 <option value="${school.schoolId}">${school.schoolName}</option>
                            </c:forEach>
	                    </select>
	                </div>
	               </li>
	
	                <li><label>院系<b>*</b></label>
	                    <div class="vocation">
	                        <select class="select1" name="department" id="department" onchange="getMajor()">
	                             <option value="" selected="selected">请选择</option>
	                        </select>
	                    </div>
	                </li>
	
	                <li><label>专业<b>*</b></label>
	                    <div class="vocation">
	                        <select class="select1" name="major" id="major">
	                            <option value="" selected="selected">请选择</option>
	                        </select>
	                    </div>
	                </li>
	
	                <li><label>校内职务<b>*</b></label>
	                    <div class="vocation">
	                        <select class="select1" name="job">
	                            <option value="" selected="selected">请选择</option>
	                            <option>无</option>
	                            <option>班干部</option>
	                            <option>学生会干部</option>
	                            <option>社团干部</option>
	                        </select>
	                    </div>
	                </li>
	
	                <li><label>加入日期<b>*</b></label><input name="joinDate" id="joinDate" type="text" class="dfinput" placeholder="请输入加入日期"  style="width:342px;"/></li>
	
	                <li><label>证件</label><cite><input name="card" type="radio" value="已领取" checked="checked" />已领取
	                    &nbsp;&nbsp;&nbsp;&nbsp;<input name="card" type="radio" value="未领取" />未领取</cite></li>
	                <li><label>状态<b>*</b></label>
	                    <div class="vocation">
	                        <select class="select1" name="state">
	                            <option value="" selected="selected">请选择</option>
	                            <option>正常</option>
	                            <option>退出</option>
	                            <option>毕业</option>
	                        </select>
	                    </div>
	                </li>
	                <li><label>实验室职务</label><cite><input name="role" type="radio" value="无" checked="checked" />无
	                    &nbsp;&nbsp;&nbsp;&nbsp;<input name="role" type="radio" value="管理人员" />管理人员</cite></li>
	                <li><label>培训经历</label><cite><input name="trainning" type="radio" value="无" checked="checked" />无
	                    &nbsp;&nbsp;&nbsp;&nbsp;<input name="trainning" type="radio" value="有" />有</cite></li>
	
	                <li><label>技术专长<b>*</b></label><input name="intrest" type="text" class="dfinput" placeholder="请输入技术专长"  style="width:342px;"/></li>
	
	
	                <li><label>备注<b>*</b></label>
	                    <textarea id="content7" name="remark" style="width:700px;height:250px;visibility:hidden;"></textarea>
	
	                </li>
	                <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="注册"/></li>
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
    
    <script>    
	    //执行一个laydate(日期)实例
	    laydate.render({
	      elem: '#joinDate' //指定元素
	    });
	</script>

</div>



</body>
</html>
