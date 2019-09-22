<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>创新学分录入</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="../index.jsp">首页</a></li>
        <li><a href="addScore.jsp">创新学分录入</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>创新学分</span></div>
    <form action="../AddCreditServlet" method="post">
        <ul class="forminfo">

            <li><label>姓名</label><input name="stuName" id="stuName" type="text"  placeholder="请输入姓名" class="dfinput" /><i>2-4个汉字</i></li>

            <li><label>学号</label><input name="stuId" type="text" class="dfinput"  placeholder="请输入学号"/><i>数字</i></li>
          
            <li><label>分值</label><input name="score" type="text" class="dfinput"  placeholder="请输入分值"/><i>数字</i></li>

            <li><label>备注</label><textarea name="remark" cols="" rows="" class="textinput"></textarea></li>

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="登记"/></li>
        </ul>
    </form>

</div>


</body>
</html>
