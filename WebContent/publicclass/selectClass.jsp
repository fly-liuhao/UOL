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
    <title>查询公开课</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript" src="js/laydate/laydate.js"></script>

    <script type="text/javascript">
        KE.show({
            id : 'content7',
            cssPath : './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 135
            });
            $(".select2").uedSelect({
                width : 90                  //设置下拉类表框宽度
            });
        });
    </script>
    
    <!-- 学校、院系二级联动 -->
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
	    function clearDept() {
	        $("#department").html("");
	        var pleaseOption = $("<option>").val("").text("院系").prop('selected',true);
	        $("#department").append(pleaseOption);
	    }
	</script>
	
	<!-- 实现分页 -->
	<script  type="text/javascript">
	   function findPublicClass(page){
		   // 清除原来的内容
		   clearTbaby();
		   // 准备查询的参数
		   var param = {
		       'page':page,
               'courseName':$("#courseName").val(),
               'startDate':$("#startDate").val(),
               'endDate':$("#endDate").val(),
               'school':$("#school").val(),
               'department':$("#department").val(),
               'grade':$("#grade").val(),
		       'ram':Math.random()
		   };
		   // console.log(param);
		   // 调用Servlet进行查询,并将查询结果进行拼装
		   $.getJSON("SelectOpenCourseAjaxServlet?status=second", param, function(data) {
			   $.each(data,function(index,item){
				   var str = $("<tr>").append($("<td>").text(item.courseDate))
				                      .append($("<td>").text(item.courseName))
                                      .append($("<td>").text(item.speakerName))
                                      .append($("<td>").text(item.organizerName))
                                      .append($("<td>").text(item.place))
                                      .append($("<td>").append($("<a>").text("显示人员")));
				   $("#tbaby").append(str);
			   });
		   });
		   
		   // 首页
		   var firstPage = $("<a href='javascript:void(0)'>首页</a>").click(function(){
			   findPublicClass(1);
		   });
		   // 上一页
		   var prePage = $("<a href='javascript:void(0)'>上一页</a>").click(function(){
               findPublicClass(page - 1);
           });  
		   // 下一页
		   var nextPage = $("<a href='javascript:void(0)'>下一页</a>").click(function(){
               findPublicClass(page + 1);
           });
		   // 尾页
		   var endPage = $("<a href='javascript:void(0)'>尾页</a>").click(function(){
               findPublicClass(${pageNum});
           });
	       // 提示标签
	       var span = $("<span>").text("当前第"+ page + "页 共" + ${pageNum} + "页");

		   
           $("#pagediv").html("");
		   if(page == 1){
			   $("#pagediv").append(nextPage).append(endPage).append(span);
		   }
           if(page != 1 && page != ${pageNum}){
               $("#pagediv").append(firstPage).append(prePage).append(nextPage).append(endPage).append(span);
           }
           if(page == ${pageNum}){
               $("#pagediv").append(firstPage).append(prePage).append(span);
           }
	   }
	
	   function clearTbaby(){
		   $("#tbaby").html("");
	   }
	
	
	</script>	
	
</head>

<body onload="findPublicClass(1)"><!-- onload="findPublicClass(1)" -->
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="index.jsp">首页</a></li>
        <li><a href="SelectOpenCourseAjaxServlet?status=first">查询公开课</a></li>
    </ul>
</div>

<div class="formbody">
    <div id="usual1" class="usual">
        <!--tab个数定义开始 -->
        <div class="itab">
            <ul>
                <li><a href="#tab2">公开课组合条件查询</a></li>
            </ul>
        </div><!--tab定义结束-->

        <div id="tab1" class="tabson">
            <ul class="forminfo">
                <li>
                    <div class="usercity">
	                    <form action="SelectOpenCourseServlet" method="post">
	                        <div class="cityleft">
                                <input name="courseName" id="courseName" type="text" class="dfinput" placeholder="专题名称"  style="width:200px"/>
                            </div>
	                        <div class="cityleft">
	                            <input name="startDate" id="startDate" type="text" class="dfinput" placeholder="开始日期"  style="width:90px"/>
	                        </div>
	                        <div class="cityleft">
	                            <input name="endDate" id="endDate" type="text" class="dfinput" placeholder="结束日期"  style="width:90px"/>
	                        </div>
	                        
	                        <div class="cityleft">
                                <select class="select1" name="school" id="school" onchange="getDept()">
                                    <option value="" selected="selected">学校</option>
                                    <c:forEach items="${schoolList}" var="school">
                                        <option value="${school.schoolId}">${school.schoolName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="cityleft">
                                <select class="select1" name="department" id="department">
                                    <option value="" selected="selected">院系</option>
                                </select>
                            </div>
    
                            <div class="cityleft">
                               <select class="select2" name="grade" id="grade">
                                    <option value="">年级</option>
                                    <option>大一</option>
                                    <option>大二</option>
                                    <option>大三</option>
                                    <option>大四</option>
                                </select>
                            </div>
	
	                        <div class="cityleft">
	                            <!-- <input name="" type="submit" class="scbtn" value="查询"/> -->
	                            <input name="" type="button" class="scbtn" value="查询" onclick="findPublicClass(1)"/>
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

                    <th>日期<i class="sort"><img src="images/px.gif" /></i></th>
                    <th>技术专题</th>
                    <th>主讲人</th>
                    <th>组织人</th>
                    <th>地点</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbaby">
	                <c:forEach items="${openCourseList}" var="course">
		                <tr>
		                    <td>${course.courseDate}</td>
		                    <td>${course.courseName}</td>
		                    <td>${course.speakerName}</td>
		                    <td>${course.organizerName}</td>
		                    <td>${course.place}</td>
		                    <td><a href="#" class="tablelink">显示人员</a></td>
		                </tr>
	                </c:forEach>
                </tbody>
            </table>

        </div>
        <div id="pagediv">
            <a>【下标】</a>
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
	      elem: '#startDate' //指定元素
	    });
        //执行一个laydate(日期)实例
        laydate.render({
          elem: '#endDate' //指定元素
        });
	</script>
</div>

</body>
</html>
