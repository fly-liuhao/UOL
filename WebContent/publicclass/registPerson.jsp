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
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>公开课人员登记</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script src="js/laydate/laydate.js"></script> 
    
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });
        });
    </script>
    
    <!-- 多级联动 -->
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
        <li><a href="SchoolManagementServlet?pageTag=registPerson">公开课人员登记</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>人员信息</span></div>
    <form action="AddCourseMemberServlet" method="post">
        <ul class="forminfo">
            <li><label>日期</label><input name="date" id="date" type="text"  placeholder="公开课日期" class="dfinput" /><i></i></li>
            <li><label>姓名</label><input name="realname" id="realname" type="text"  placeholder="请输入姓名" class="dfinput" /><i>2-4个汉字</i></li>
            <li><label>学号</label><input name="memberid" id="memberid" type="text"  placeholder="请输入学号" class="dfinput" /><i>9位数字</i></li>
            <li><label>性别</label><cite><input name="sex" type="radio" value="男" checked="checked" />男
                &nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" type="radio" value="女" />女</cite></li>
            <li>
                <label>学校</label>
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
                <label>院系</label>
                <div class="vocation">
                    <select class="select1" name="department" id="department">
                        <option value="" selected="selected">请选择</option>
                    </select>
                </div>
            </li>
            <li>
                <label>年级</label>
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
            
            <li><label>电话</label><input name="mobile" type="text" class="dfinput"  placeholder="请输入电话"/><i>11位数字</i></li>
            <li><label>邮箱</label><input name="email" type="text" class="dfinput"  placeholder="请输入邮箱"/><i></i></li>

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="登记"/></li>
        </ul>
    </form>

</div>

<script>    
    //执行一个laydate(日期)实例
    laydate.render({
         elem: '#date'//指定元素
        ,type: 'datetime'
    });
</script>

</body>
</html>
