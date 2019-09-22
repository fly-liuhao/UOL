<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript" src="../editor/kindeditor.js"></script>
<script type="text/javascript" src="../js/echarts.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345		        //此处代码设置下拉列表框的宽度
	});
	$(".select2").uedSelect({
		width : 167            //此处代码设置下拉列表框的宽度
	});
	$(".select3").uedSelect({
		width : 100            //此处代码设置下拉列表框的宽度
	});
});
</script>

</head>

<body>
    <!--顶部区域代码开始-->
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">成员统计</a></li>
    </ul>
    </div><!--顶部区域代码结束-->
    
    <div class="formbody">
      <div id="usual1" class="usual">
          <!--tab个数定义开始 -->
         <div class="itab">
  	       <ul>
               <li><a href="#tab2">实验室成员统计图表</a></li>
  	       </ul>
    </div><!--tab定义结束-->
    
    <!-- -------------------------图标显示区-------------------------------->
    <!-- 定义一个用于存放图表的div -->
    <div id="main" style="width: 600px;height:400px; float: left;"></div>
    <div id="main2" style="width: 600px;height:400px; float: left;"></div>
    
    <!-- 准备图表JS代码 -->
    <script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var weatherIcons = {
            'Sunny': './data/asset/img/weather/sunny_128.png',
            'Cloudy': './data/asset/img/weather/cloudy_128.png',
            'Showers': './data/asset/img/weather/showers_128.png'
        };

        option = {
            title: {
                text: '各院校实验室成员人数统计',
                subtext: '详细数据',
                left: 'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                // orient: 'vertical',
                // top: 'middle',
                bottom: 10,
                left: 'center',
                data: ['西凉', '益州','兖州','荆州','幽州']
            },
            series : [
                {
                    type: 'pie',
                    radius : '65%',
                    center: ['50%', '50%'],
                    selectedMode: 'single',
                    data:[
                        {
                            value:1548,
                            name: '太原工业学院',
                            label: {
                                normal: {
                                    formatter: [
                                        '{title|{b}}{abg|}',
                                        '  {weatherHead|实验室人数}{rateHead|占比}',
                                        '{hr|}',
                                        '  {Sunny|128}{rate|55.3%}',
                                        '  {Cloudy|96}{rate|38.9%}',
                                        '  {Showers|38}{rate|5.8%}'
                                    ].join('\n'),
                                    backgroundColor: '#eee',
                                    borderColor: '#777',
                                    borderWidth: 1,
                                    borderRadius: 4,
                                    rich: {
                                        title: {
                                            color: '#eee',
                                            align: 'center'
                                        },
                                        abg: {
                                            backgroundColor: '#333',
                                            width: '100%',
                                            align: 'right',
                                            height: 25,
                                            borderRadius: [4, 4, 0, 0]
                                        },
                                        Sunny: {
                                            height: 30,
                                            align: 'left',
                                            backgroundColor: {
                                                image: weatherIcons.Sunny
                                            }
                                        },
                                        Cloudy: {
                                            height: 30,
                                            align: 'left',
                                            backgroundColor: {
                                                image: weatherIcons.Cloudy
                                            }
                                        },
                                        Showers: {
                                            height: 30,
                                            align: 'left',
                                            backgroundColor: {
                                                image: weatherIcons.Showers
                                            }
                                        },
                                        weatherHead: {
                                            color: '#333',
                                            height: 24,
                                            align: 'left'
                                        },
                                        hr: {
                                            borderColor: '#777',
                                            width: '100%',
                                            borderWidth: 0.5,
                                            height: 0
                                        },
                                        value: {
                                            width: 20,
                                            padding: [0, 20, 0, 30],
                                            align: 'left'
                                        },
                                        valueHead: {
                                            color: '#333',
                                            width: 20,
                                            padding: [0, 20, 0, 30],
                                            align: 'center'
                                        },
                                        rate: {
                                            width: 40,
                                            align: 'right',
                                            padding: [0, 10, 0, 0]
                                        },
                                        rateHead: {
                                            color: '#333',
                                            width: 40,
                                            align: 'center',
                                            padding: [0, 10, 0, 0]
                                        }
                                    }
                                }
                            }
                        },
                        {value:535, name: '太原师范学院'},
                        {value:510, name: '太原理工大学'},
                        {value:634, name: '太原科技大学'},
                        {value:735, name: '中北大学'}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
    <script type="text/javascript">
        var myChart2 = echarts.init(document.getElementById('main2'));
        
        // 指定图表的配置项和数据
        var option2 = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
   
        myChart2.setOption(option2);     
    </script>
    
    <!-------------------以下代码不能删除------------------------->
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    </div>
</body>
</html>
