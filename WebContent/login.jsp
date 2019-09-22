<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录UOL联合开放实验室管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});
</script> 

<!-- 实现自动登陆 -->
<script type="text/javascript">

    // 获取指定cookie的值
    function getCookie(cname){
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i].trim();
            if (c.indexOf(name)==0) {
                return c.substring(name.length,c.length);
            }
        }
        return "";
    }

    // 获得cookie中存放的密码实现自动登陆
    function checkCookie()
    {  
        var username=getCookie("username");
        var userpwd=getCookie("userpwd");
        $("#username").val(username);
        $("#userpwd").val(userpwd);
        // alert("username："+ username);
        // alert("userpwd："+ userpwd);
        
    	if (username!="" && userpwd!="") {    	    
            //location.href="AutoLoginServlet?username="+username+"&userpwd="+userpwd;                
        } else {
          //alert("Please login !");
        }

    } 
</script>

</head>

<body onload="checkCookie()" style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="mainBody">
  <div id="cloud1" class="cloud"></div>
  <div id="cloud2" class="cloud"></div>
</div>  

<div class="logintop">    
    <span>欢迎登录UOL联合开放实验室管理平台</span>    
    <ul>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form action="LoginServlet?status=login" method="post">
	    <ul>
	    <li><input name="username" id="username" type="text" class="loginuser" style="color: gray" value=""  placeholder="请输入用户名" onclick="JavaScript:this.value=''"/></li>
	    <li><input name="userpwd" id="userpwd" type="password" class="loginpwd" style="color: gray" value="" placeholder="请输入密码" onclick="JavaScript:this.value=''"/></li>
	    <li>
	       <input name="" type="submit" class="loginbtn" value="登录" />
	       <label><input name="isRemember" type="checkbox" value="true" checked="checked" /><input name="isRemember" type="hidden" value="false"/>记住密码</label>
	       <label><a href="#">忘记密码？</a></label>
       </li>
	    </ul>
    </form>
    
    </div>
    
    </div>
    
   
    <div class="loginbm">版权所有  @2019  太原工业学院计算机工程系-liuhao</div>
	
    
</body>
</html>
