<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%
	    String path = request.getContextPath();
	            String basePath = request.getScheme() + "://" 
	                    + request.getServerName() + ":" 
	                    + request.getServerPort() + path + "/";
	%>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加公开课</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script src="js/laydate/laydate.js"></script> 
    
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    
    <script type="text/javascript">
        KE.show({
            id : 'content1',
            cssPath : './index.css'
        });
        KE.show({
            id : 'content2',
            cssPath : './index.css'
        });
    </script>
    
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });
        });
    </script>
    
    <script type="text/javascript">
	    function getDept() {
	        clearDept();
	        var param = {
	            'schoolId' : $("#school").val()
	        };
	        $.getJSON("FindDeptBySchoolServlet", param, function(data) {
	            // console.log(data.length);
	            $.each(data, function(index, item) {
	                var op = $("<option>").val(item.deptId).text(item.deptName);
	                $("#department").append(op);
	            });
	        });
	    }
	    function clearDept() {
	        $("#department").html("");
	        var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
	        $("#department").append(pleaseOption);
	    }
	</script>
       
    
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="index.jsp">首页</a></li>
        <li><a href="SchoolManagementServlet?pageTag=addPublicClass">添加公开课</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>公开课信息</span></div>
    <form action="AddOpenCourseServlet" method="post">
        <ul class="forminfo">
            <li><label>日期</label><input name="courseDate" id="courseDate" placeholder="请选择日期" type="text" class="dfinput" /></li>
            <li><label>技术专题</label><input name="courseName" id="courseName" placeholder="请输入技术专题" type="text" class="dfinput" /><i>字母和汉字的组合，1-50个字符</i></li>
            <li><label>主讲人</label><input name="speakerName" id="speakerName" type="text"  placeholder="请输入主讲人" class="dfinput" /><i>2-4个汉字</i></li>
            <li><label>组织人</label><input name="organizerName" id="organizerName" type="text"  placeholder="请输入组织人" class="dfinput" /><i>2-4个汉字</i></li>
            <li><label>地点</label><input name="address" id="address" type="text" class="dfinput"  placeholder="请输入地点"/><i>数字、字母和汉字的组合，2-20个字符</i></li>
            <li>
                <label>所属学校</label>
                <div class="vocation">
                    <select class="select1"  name="school" id="school" onchange="getDept()">
                        <option value="" selected="selected">请选择</option>
                        <c:forEach items="${schoolList}" var="school">
                            <option value="${school.schoolId}">${school.schoolName}</option>
                        </c:forEach>
                    </select>
                </div>
            </li>
            <li>
                <label>所属院系</label>
                <div class="vocation">
                    <select class="select1" name="department" id="department">
                        <option value="" selected="selected">请选择</option>
                    </select>
                </div>
            </li>
            <li>
                <label>所属年级</label>
                <div class="vocation">
                    <select class="select1" name="grade">
                        <option value="" selected="selected">请选择</option>
                        <option>大一</option>
                        <option>大二</option>
                        <option>大三</option>
                        <option>大四</option>
                    </select>
                </div>
            </li>
            <li><label>群体说明</label><textarea name="explain"id="content1" cols="" rows="" class="textinput"></textarea></li>
            <li><label>备注</label><textarea name="remark" id="content2" cols="" rows="" class="textinput"></textarea></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>

</div>

<script>	
	//执行一个laydate(日期)实例
	laydate.render({
		 elem: '#courseDate'//指定元素
	    ,type: 'datetime'
	});
</script>

</body>
</html>
