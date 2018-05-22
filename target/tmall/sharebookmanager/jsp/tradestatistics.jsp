<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/heanesUI/js/resource/jquery.2.2.4.min.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/jquery-2.1.4/jquery.min.js" ></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-datepicker-1.5.0/js/bootstrap-datepicker.js" ></script>
    <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-3.3.5/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-datepicker-1.5.0/css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/css/bootstrap-table.css" />
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="${basePath}/sharebookmanager/js/echarts.js"></script>
    <script src="${basePath}/sharebookmanager/js/vintage.js"></script>
    <script src="${basePath}/sharebookmanager/js/customed.js"></script>
    <style type="text/css">
        body > div {
            margin: 0px;
            padding: 0px;
        }
        .form-group {
            margin-top: 20px;
            margin-left: 20px;
            margin-right: -5px;
        }
        body > div > form > .form-group > label {
            width: 90px;
            text-align: center;
        }

        .form-control, .select2-selection--single {
            min-width: 160px;
            max-width: 160px;
        }
        a{
            text-decoration:none;
            cursor:pointer
        }
        .W30 .th-inner {
            width:120px !important;
        }
    </style>


</head>
<body>
   <div id="main" style="width: 600px;height:400px;"></div>
   <div id="main1" style="width: 600px;height:400px;"></div>
</body>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'), 'customed');

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '折线图堆叠'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件营销',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟广告',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频广告',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接访问',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索引擎',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };



        // 使用刚指定的配置项和数据显示图表。
         myChart.setOption(option);
        //
        //     //初始化echarts
        //     function chushihua(myChart){
        //         var option = {
        //             title:{
        //                 text:'交易数据统计'
        //             },
        //             series:[{
        //                 name:'访问量',
        //                 type:'pie',
        //                 radius:'90%',
        //                 data:[
        //                     {value:0,name:'无'},
        //                 ]
        //             }]
        //         };
        //
        //         myChart.setOption(option);
        //     }
        //
        // //从数据库读取数据赋值给echarts
        // function fuzhi(myChart){
        //     $.ajax({
        //         contentType : "application/json",
        //         type : "GET",
        //         url : "info.html",
        //         dataType : "json",
        //         success : function(data) {
        //             //创建一个数组，用来装对象传给series.data，因为series.data里面不能直接鞋for循环
        //             var servicedata=[];
        //
        //             for(var i=0;i<data.length;i++){
        //                 var obj=new Object();
        //                 obj.name=data[i].username;
        //                 obj.value=data[i].age;
        //                 servicedata[i]=obj;
        //             }
        //
        //             myChart.setOption({
        //                 title:{
        //                     text:'ECharts 数据统计'
        //                 },
        //                 series:[{
        //                     name:'访问量',
        //                     type:'pie',
        //                     radius:'60%',
        //                     data:servicedata,
        //                 }]
        //
        //             });
        //
        //         }
        //     });
        // }
        //
        // //初始化echarts实例
        // var myChart = echarts.init(document.getElementById('main1'));
        // chushihua(myChart);
        // fuzhi(myChart);

    </script>
</html>