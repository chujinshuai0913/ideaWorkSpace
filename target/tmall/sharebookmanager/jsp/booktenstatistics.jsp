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
    <script type="text/javascript"  src="${basePath}/sharebookmanager/static/echarts-2.2.7/chart/echarts.js"></script>
    <%-- <script type="text/javascript"  src="${basePath}/sharebookmanager/js/echarts.js"></script>--%>
    <script src="${basePath}/sharebookmanager/static/echarts-2.2.7/chart/line.js"></script>
    <script src="${basePath}/sharebookmanager/static/echarts-2.2.7/chart/macarons.js"></script>
    <script src="${basePath}/sharebookmanager/static/echarts-2.2.7/chart/pie.js"></script>
    <script src="${basePath}/sharebookmanager/static/echarts-2.2.7/chart/wordCloud.js"></script>
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
        .report{
            position: absolute;
            top: 200px;
            margin-left: 10%;
        }
    </style>


</head>
<body>
<div id="sharebookuserList" class="panel panel-default" style="padding-right: 0px;">
    <div>
        <form id="form_sharebookuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;margin-bottom: 20px;"
              onkeydown="if(event.keyCode==13){return false;}">

            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">作者</label> <input
                    name="author" type="text" class="form-control" placeholder="作者模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">出版社</label> <input
                    name="press" type="text" class="form-control" placeholder="出版社模糊查询"/>
            </div>

            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">学院</label>
                <input type="text" name="professionalType1"  class="form-control" placeholder="学院"/>

            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">专业</label>
                <input type="text" name="professionalType2"  class="form-control" placeholder="专业"/>

                <%-- <select  name="status" type="text" class="form-control" placeholder="专业">
                        <option value="">全部</option>
                        <option value="1"> 可用</option>
                        <option value="2"> 不可用</option>
                    </select>--%>
            </div>

            <div class="form-group" style="margin-left: 30px;">

                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="exportBtn">导出</button>
            </div>
        </form>
    </div>
    <div id="panel-body" style="width: 98%;margin: auto;">
        <div  id="main" class="report" style="width: 80%;height:400px;"></div>
    </div>
</div>

   <%--<div id="main1" style="width: 600px;height:400px;"></div>--%>
</body>
    <script type="text/javascript">
        $(function () {
            $('#formSearchBtn').click();
        })
        // 基于准备好的dom，初始化echarts实例
        var list = {};
        var myChart = echarts.init(document.getElementById('main'),'macarons');
        // 显示标题，图例和空的坐标轴
       var option = {
            title : {
                text: '十大热销图书',
                subtext: '真实可靠'
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['销量']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : []
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'销量',
                    type:'bar',
                    data:[],
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        };
        myChart.setOption(option,true);
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

        var bookNames=[];    //类别数组（实际用来盛放X轴坐标值）
        var useNums=[];    //销量数组（实际用来盛放Y坐标值）
        $('#formSearchBtn').on('click', function () {

        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/ideaWorkSpace/dataReport/bookten",    //请求发送到TestServlet处
            data: JSON.stringify($.extend(true, {}, convertSerializeArrayToObject($("#form_sharebookuser_q").serializeArray()))),
            contentType:"text/html;charset=utf-8",
            dataType: "json",   //返回格式为json
            success : function(data) {
                try {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (data.error_code == 0){
                   // myChart = echarts.init(document.getElementById('main'),'macarons');
                    list = JSON.parse(JSON.stringify(data.data));
                    list.list.forEach(function (item) {
                        bookNames.push(item.bookName);
                        useNums.push(item.useNum);
                    })
                    myChart.hideLoading();    //隐藏加载动画
                    myChart.setOption({        //加载数据图表
                        xAxis: {
                            data: bookNames
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '销量',
                            data: useNums
                        }]
                    });

                }
                } catch (e){
                    console.log(e.message);
                }

            },
            complete: function() {
        },
        error: function(error) {
            console.log(error);
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
        })

        });

        function convertSerializeArrayToObject(array) {
            var obj = {};
            for(var i = 0, length = array.length; i<length; i++){
                obj[array[i]['name']] =array[i]['value'];
            }
            return obj;
        }
    </script>
</html>