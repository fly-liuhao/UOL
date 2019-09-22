<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加学校</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    
	<script type="text/javascript" src="../editor/kindeditor.js"></script>
    <script type="text/javascript">
    KE.show({
        id : 'content1',
        cssPath : './index.css'
    });
</script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="../index.jsp">首页</a></li>
        <li><a href="addSchool.jsp">添加学校</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>学校信息</span></div>
    <form action="../AddSchoolServlet" method="post">
        <ul class="forminfo">
            <li><label>学校名称</label><input name="schoolname" id="schoolname" placeholder="请输入学校名称" type="text" class="dfinput" /><i>2-10个汉字</i></li>
            <li><label>备注</label><textarea name="remark" cols="" rows="" class="textinput" id="content1" style="width: 700px; height: 250px; visibility: hidden;"></textarea></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>

</div>



</body>
</html>
