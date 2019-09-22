<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加用户</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>  
    <script type="text/javascript">
        //定义JSON对象，获得用户输入框的值
        function checkUserName() {
            var param = {
                    'userName':$("#username").val()
            };
            
            // 通过JSON将得到的用户名传到Servlet,检测并返回结果
            $.getJSON("CheckUserNameServlet",param,function(data){
                // 处理服务器发来的数据，将返回的数据显示到输入框后，进行提示
                $("#usernameTip").text(data);               
            });
        }     
    </script> 
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="index.jsp">首页</a></li>
        <li><a href="user/addUser.jsp">添加用户</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>用户信息</span></div>
   <form action="AddUserServlet" method="post">
    <ul class="forminfo">
        <li><label>用户名</label><input name="username" id="username" placeholder="请输入用户名" type="text" class="dfinput" onblur="checkUserName()" /><span id="usernameTip" style="color:red;display:inline-block;padding-left:6px"></span><i>字母开头，可以是下划线、数字和字母，3-15个字符</i></li>
        <li><label>密码</label><input name="userpwd" id="userpsw" placeholder="请输入密码" type="password" class="dfinput" /><i>数字和字母组合，6-20个字符</i></li>
        <li><label>姓名</label><input name="realname" id="realname" type="text"  placeholder="请输入真实姓名" class="dfinput" /><i>2-4个汉字</i></li>
        <li><label>性别</label><cite><input name="sex" type="radio" value="男" checked="checked" />男
            &nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" type="radio" value="女" />女</cite></li>
        <li><label>职务</label><input name="job" type="text" class="dfinput"  placeholder="请输入职务"/><i>2-10个汉字</i></li>
        <li><label>备注</label><textarea name="remark" cols="" rows="" class="textinput"></textarea></li>        
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
   </form>

</div>


</body>
</html>
