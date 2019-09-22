<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>禁用用户</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="index.jsp">首页</a></li>
        <li><a href="DisplayUserServlet?pageTag=ban&currPage=1">禁用用户</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li><span><img src="images/t03.png" /></span>禁用</li>
            <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>


        <ul class="toolbar1">

        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="userid" type="checkbox" value=""/>&nbsp;全选</th>
            <th>姓名</th>
            <th>用户名</th>
            <th>性别</th>
            <th>职务</th>
            <th>禁用状态</th>
            <th>禁用</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
	        <tr>
	            <td><input name="" type="checkbox" value="" /></td>
	            <td>${user.realName}</td>
	            <td>${user.userName}</td>
	            <td>${user.sex}</td>
	            <td>${user.job}</td>
	            <td><c:if test="${user.status == '1'}">是</c:if> <c:if test="${user.status == '0'}">否</c:if></td>
	            <c:if test="${user.status == '1'}">
	               <td><a href="BanUserServlet?userId=${user.userId}&currPage=${currPage}" class="tablelink" style="color:red;">禁用</a></td>
	            </c:if>
                <c:if test="${user.status == '0'}">
                   <td><a href="BanUserServlet?userId=${user.userId}&currPage=${currPage}" class="tablelink">启用</a></td>
                </c:if>
	            
	        </tr>
        </c:forEach>  

        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">&nbsp;${recordNum}&nbsp;</i>条记录，当前显示第<i class="blue">&nbsp;${currPage}&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="DisplayUserServlet?pageTag=modify&currPage=${currPage-1}"><span class="pagepre"></span></a></li>
            <c:forEach begin="1" end="${pageNum}" var="idx">
                <c:if test="${currPage == idx}">
	               <li class="paginItem current"><a href="DisplayUserServlet?pageTag=ban&currPage=${idx}">${idx}</a></li>
	            </c:if>
	            <c:if test="${currPage != idx}">
	               <li class="paginItem"><a href="DisplayUserServlet?pageTag=ban&currPage=${idx}">${idx}</a></li>
	            </c:if>
            </c:forEach>
            <li class="paginItem"><a href="DisplayUserServlet?pageTag=modify&currPage=${currPage+1}"><span class="pagenxt"></span></a></li>
        </ul>
    </div>


    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>


</body>
</html>
