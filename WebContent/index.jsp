<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	
	<script>
	    $.("#systemdate").val(setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000));
	</script>
	
	<script type="text/javascript">
	/**
	*实时显示系统时间
	*/
	function getLangDate(){
		var dateObj = new Date(); //表示当前系统时间的Date对象 
		var year = dateObj.getFullYear(); //当前系统时间的完整年份值
		var month = dateObj.getMonth()+1; //当前系统时间的月份值 
		var date = dateObj.getDate(); //当前系统时间的月份中的日
		var day = dateObj.getDay(); //当前系统时间中的星期值
		var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
		var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串 
		var hour = dateObj.getHours(); //当前系统时间的小时值 
		var minute = dateObj.getMinutes(); //当前系统时间的分钟值
		var second = dateObj.getSeconds(); //当前系统时间的秒钟值
		//如果月、日、小时、分、秒的值小于10，在前面补0
		if(month<10){
		month = "0"+month;
		}
		if(date<10){
		date = "0"+date;
		}
		if(hour<10){
		hour = "0"+hour;
		}
		if(minute<10){
		minute = "0"+minute;
		}
		if(second<10){
		second = "0"+second;
		}
		var newDate = year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minute+":"+second;
		document.getElementById("systemdate").innerHTML = "系统公告：[ "+newDate+" ]";
		setTimeout("getLangDate()",1000);//每隔1秒重新调用一次该函数 
	}
	</script>

</head>


<body onload="getLangDate()">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>${sessionScope.username} 早上好，欢迎使用联合开放实验室信息管理平台</b>
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <span id="systemdate">系统时间</span><br/>
    <i>您上次登录的时间：2019-08-06 16:55</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>

    </div>

</body>
</html>
