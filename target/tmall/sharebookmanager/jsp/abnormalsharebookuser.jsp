<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <script type="text/javascript" src="../static/heanesUI/js/resource/jquery.2.2.4.min.js"></script>
    <script type="text/javascript" src="../static/jquery-2.1.4/jquery.min.js" ></script>
    <script type="text/javascript" src="../static/bootstrap-table-1.9.1/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="../static/bootstrap-table-1.9.1/js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="../static/bootstrap-datepicker-1.5.0/js/bootstrap-datepicker.js" ></script>
    <link rel="stylesheet" href="../static/bootstrap-3.3.5/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../static/bootstrap-datepicker-1.5.0/css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="../static/bootstrap-table-1.9.1/css/bootstrap-table.css" />
    <script type="text/javascript" src="../static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
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
            width:80px !important;
        }
    </style>


</head>
<body>
<div id="sharebookuserList" class="panel panel-default" style="padding-right: 0px;">
    <div>
        <form id="form_sharebookuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
              onkeydown="if(event.keyCode==13){return false;}">


            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">昵称</label> <input
                    name="userName" type="text" class="form-control" placeholder="姓名模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">手机号</label> <input
                    name="phoneNumber" type="text" class="form-control" placeholder="手机号"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">学号</label> <input
                    name="schoolCode" type="text" class="form-control" placeholder="学号"/>
            </div>
            <div class="form-group" style="margin-left: 30px;">

                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="stopUse">禁号</button>
                <button type="button" class="btn btn-success" id="startUse">启用</button>
            </div>
        </form>
    </div>
    <div id="panel-body" style="width: 98%;margin: auto;">
        <table  id="mainTable"></table>
    </div>
</div>
<div id="modal_detailTable" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="900px" style="width:900px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle">学生信息</h4>
            </div>
            <div class="modal-body">
                <table id="detailTable"></table>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">

    $('#formSearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_sharebookuser",
        url: '/ideaWorkSpace/usershare/abnormaluser',
        showColumns: false,
        method:'post',
        dataType: "json",
        sidePagination : "server",
        pagination : true,
        sortOrder:"asc",
        pageList : [10,15,25,50,100,'all'],
        pageNumber:1,
        pageSize :10,
        totalField : "total_records",
        dataField: 'data',
        queryParamsType : "page",
        queryParams: function (params) {
            var newParams = convertSerializeArrayToObject($("#form_sharebookuser_q").serializeArray());
            newParams = $.extend(true, {}, params, newParams);
            return newParams;
        },
        columns: [ {
            checkbox: true
        },
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,

            },
            {
                field: 'userName',
                title: '昵称',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'phoneNumber',
                title: '电话',
                align: "center",
                formatter: formatterToValue

            }
            ,
            {
                field: 'schoolCode',
                title: '学号/工号',
                align: "center",
                formatter :function(value, row, index) {
                    if(value>0){
                        return [ "<a  class='record-detail'>",''+value+'','</a>' ].join('');
                    }else{
                        return value;
                    }
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog(e, value, row, index);
                    }
                }

            },{
                field: 'lTime',
                title: '上次登录时间',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'num',
                title: '购买图书数量',
                align: "center",
                formatter: formatterToValue

            }
        ]
    });
    $("#detailTable").bootstrapTable(
        {
            toolbar: "#toolbar_sharebookuserDetail",
            method:'post',
            dataType: "json",
            sidePagination : "server",
            pagination : true,
            queryParamsType : "page",
            pageList : [5,10,15,20,'all'],
            pageNumber:1,
            pageSize :5,
            totalField : "total_records",
            dataField: 'data',
            queryParams: function (params) {
                var idParam={schoolCode:schoolCode};
                var newParams = $.extend(true,{},params,idParam);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'idNumber',
                    title : '学号/工号',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'stName',
                    title : '姓名',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'professional1Name',
                    title : '学院',
                },
                {
                    align: "center",
                    field : 'professional2Name',
                    title : '专业',
                },
                {
                    align: "center",
                    field : 'grade',
                    title : '年级',
                },
                {
                    align: "center",
                    field : 'time',
                    title : '认证时间',
                    formatter :function(value, row, index) {
                        if(value>0){
                            return new Date(parseInt(value) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ")
                        }else{
                            return value;
                        }
                    }
                }]
        });

    //弹出层
    var schoolCode=0;
    function detailTableDialog(e, value, row, index){

        $('#modal_detailTable').modal("show");
        schoolCode=row.schoolCode;
        $('#detailTable').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/usershare/userlistDetail',
            query:{
                schoolCode:schoolCode
            }
        });
    }
    function convertSerializeArrayToObject(array) {
        var obj = {};
        for(var i = 0, length = array.length; i<length; i++){
            obj[array[i]['name']] =array[i]['value'];
        }
        return obj;
    }
    function formatterToValue(value, row, index) {
        if(value && value!=null && value !="1970"){

        }else{
            value="-";
        }
        return value;
    }
    //禁号
    $("#stopUse").on('click',function () {
        var selected = $('#mainTable').bootstrapTable("getSelections");
        var dataNum=$('#mainTable').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
            if(item.status != 1){
                alert("只能操作未禁用的数据！")
                flag = false;
                return false;
            }else{
                ids[index] = item.id;
            }
        });
        if(flag){
            if(ids.length == 0){
                alert("最少要有一条数据！")
                flag = false;
                return false;
            }
            var params = {ids:ids};
            $.ajax({
                url: "/ideaWorkSpace/usershare/stopuse",    //请求的url地址
                dataType: "json",   //返回格式为json
                data: JSON.stringify(params),    //参数值
                type: "POST",   //请求方式
                contentType:"text/html;charset=utf-8",
                beforeSend: function() {
                },
                success: function(data) {
                    try {
                        console.log(JSON.stringify(data));
                        if(data){
                            var jsonData = JSON.parse(JSON.stringify(data));
                            if(jsonData.resultMassage == 'ok'){
                                alert("操作成功!");
                                $('#mainTable').bootstrapTable('refresh');
                            }else{
                                alert(jsonData.resultMassage);
                            }
                        }
                    } catch (e){
                        console.log(e.message);
                    }
                },
                complete: function() {
                },
                error: function(error) {
                    console.log(error);
                }
            });
        }
    })
    //启用
    $("#startUse").on('click',function () {
        var selected = $('#mainTable').bootstrapTable("getSelections");
        var dataNum=$('#mainTable').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
            if(item.status != 2){
                alert()
                alert("只能操作禁用的数据！")
                flag = false;
                return false;
            }else{
                ids[index] = item.id;
            }
        });
        if(flag){
            if(ids.length == 0){
                alert("最少要有一条数据！")
                flag = false;
                return false;
            }
            var params = {ids:ids};
            $.ajax({
                url: "/ideaWorkSpace/usershare/startuse",    //请求的url地址
                dataType: "json",   //返回格式为json
                data: JSON.stringify(params),    //参数值
                type: "POST",   //请求方式
                contentType:"text/html;charset=utf-8",
                beforeSend: function() {
                },
                success: function(data) {
                    try {
                        console.log(JSON.stringify(data));
                        if(data){
                            var jsonData = JSON.parse(JSON.stringify(data));
                            if(jsonData.resultMassage == 'ok'){
                                alert("操作成功!");
                                $('#mainTable').bootstrapTable('refresh');
                            }else{
                                alert(jsonData.resultMassage);
                            }
                        }
                    } catch (e){
                        console.log(e.message);
                    }
                },
                complete: function() {
                },
                error: function(error) {
                    console.log(error);
                }
            });
        }
    })

</script>
</body>
</html>