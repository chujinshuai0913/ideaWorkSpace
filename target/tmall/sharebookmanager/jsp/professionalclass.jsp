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
            width:120px !important;
        }
    </style>


</head>
<body>
<div id="sharebookuserList" class="panel panel-default" style="padding-right: 0px;">
    <div>
        <form id="form_sharebookuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
              onkeydown="if(event.keyCode==13){return false;}">
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">学院名称</label> <input
                    name="className1" type="text" class="form-control" placeholder="学院模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">状态</label>
                <select type="text" name="status"  class="form-control" >
                    <option value="">全部</option>
                    <option value="1">可用</option>
                    <option value="2">禁用</option>
                </select>
            </div>
            <div class="form-group" style="margin-left: 30px;">
                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                <button type="button" id="insertSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">新增学院
                </button>
            </div>
            <div class="form-group" style="margin-left: 30px;">
                <button type="button" class="btn btn-success" onclick="audited()">启用</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" onclick="reject()">禁用</button>
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
                <h4 class="modal-title" id="modalTitle">专业</h4>
                <form id="form_sell_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
                      onkeydown="if(event.keyCode==13){return false;}">
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();">专业名称</label> <input
                            name="className2" type="text" class="form-control" placeholder="专业模糊查询"/>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();">状态</label>
                        <select type="text" name="status"  class="form-control" >
                            <option value="">全部</option>
                            <option value="1">可用</option>
                            <option value="2">禁用</option>
                        </select>
                    </div>
                    <input name="classId1" id="classId2" type="text" class="form-control" style="display: none" />
                    <div class="form-group" style="margin-left: 30px;">
                        <label></label>
                        <button type="button" id="formClass2SearchBtn" class="btn btn-primary" data-style="zoom-in"
                                formaction="javascript:void(0);">查询
                        </button>&nbsp;&nbsp;
                        <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                        <button type="button" id="insertClass2" class="btn btn-primary" data-style="zoom-in"
                                formaction="javascript:void(0);">新增专业
                        </button>
                    </div>
                    <div class="form-group" style="margin-left: 30px;">
                        <button type="button" class="btn btn-success" onclick="auditedClass2()">启用</button>&nbsp;&nbsp;
                        <button type="button" class="btn btn-success" onclick="rejectClass2()">禁用</button>
                    </div>
                </form>
            </div>
            <div class="modal-body">
                <table id="detailTable"></table>
            </div>

        </div>
    </div>
</div>
    <div id="modal_insertSearchBtn" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
        <div class="modal-dialog" dialog-width="300px" style="width:400px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                    <h4 class="modal-title" >学院</h4>
                    <form id="form_insertClass1_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
                          onkeydown="if(event.keyCode==13){return false;}">
                        <div class="form-group" style="margin-left: 50px;">
                            <label onclick="$(this).next().focus();">学院</label>
                            <input name="className1" type="text" class="form-control" placeholder="学院"/>
                        </div>
                            <div class="form-group" style="margin-left: 30px; display: inherit">
                                <label></label>
                            <button type="button" style="margin-left: 100px; " id="insert1" class="btn btn-primary" data-style="zoom-in"
                                    formaction="javascript:void(0);">确认新增
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</div>
<div id="modal_insertClass2" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="300px" style="width:400px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" >专业</h4>
                <form id="form_insertClass2_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
                      onkeydown="if(event.keyCode==13){return false;}">
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();">专业</label>
                        <input name="classId1" id="classId1" type="text" class="form-control" style="display: none" />
                        <input name="className2" type="text" class="form-control" placeholder="专业"/>
                    </div>
                    <div class="form-group" style="margin-left: 30px; display: inherit">
                        <label></label>
                        <button type="button" style="margin-left: 100px; " id="insert2" class="btn btn-primary" data-style="zoom-in"
                                formaction="javascript:void(0);">确认新增
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    $('#formSearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    $('#insertSearchBtn').on('click', function () {
        $('#modal_insertSearchBtn').modal("show");
    });
    $('#insertClass2').on('click', function (){
        $('#modal_insertClass2').modal("show");
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_book",
        url: '/ideaWorkSpace/book/bookpro1',
        showColumns: false,
        method:'post',
        dataType: "json",
        sidePagination : "server",
        pagination : true,
        sortOrder:"desc",
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
            },{
                field: 'className1',
                title: '学院',
                align: "center",
                formatter: formatterToValue
            }, {
                field: 'status',
                title: '状态',
                align: "center",
                visible:false,

            },
            {
                field: '专业',
                title: '专业',
                align: "center",
                formatter :function(value, row, index) {
                        return [ "<a  class='record-detail'>详情</a>" ].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog(e, value, row, index);
                    }
                }
            },
            {
                field: 'cUser',
                title: '操作人',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'cTime',
                title: '操作时间',
                align: "center",
                formatter: formatterToValue
            }
        ]
    });
    $("#detailTable").bootstrapTable(
        {
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
                var userParams=convertSerializeArrayToObject($("#form_sell_q").serializeArray());
                var newParams = $.extend(true,{},params,userParams);
                return newParams;
            },
            columns : [
                {
                    checkbox: true
                },
                {
                    field: 'id',
                    title: 'id',
                    align: "center",
                    visible:false,
                },{
                    field: 'className2',
                    title: '专业',
                    align: "center",
                    formatter: formatterToValue
                }, {
                    field: 'status',
                    title: '状态',
                    align: "center",
                    visible:false,

                },
                {
                    field: 'cUser',
                    title: '操作人',
                    align: "center",
                    formatter: formatterToValue

                },
                {
                    field: 'cTime',
                    title: '操作时间',
                    align: "center",
                    formatter: formatterToValue
                }]
        });



    //弹出层
    var id=0;
    function detailTableDialog(e, value, row, index){
        $('#modal_detailTable').modal("show");
        id=row.id;
        $('#classId1').val(id);
        $('#classId2').val(id);
        $('#detailTable').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookpro2',
            query:{
                classId1:id
            }
        });
    }

    $('#formClass2SearchBtn').on('click', function () {
        $('#detailTable').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookpro2'
        });
    });
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
    //审核通过
    function audited(){
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
                url: "/ideaWorkSpace/book/auditpro1",    //请求的url地址
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
    }

    //驳回
    function reject(){
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
                alert("只能操作已经启用的数据！")
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
                url: "/ideaWorkSpace/book/auditNotpro1",    //请求的url地址
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
    }
    //审核通过
    function auditedClass2(){
        var selected = $('#detailTable').bootstrapTable("getSelections");
        var dataNum=$('#detailTable').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
            if(item.status != 2){
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
                url: "/ideaWorkSpace/book/auditpro2",    //请求的url地址
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
    }

    //驳回
    function rejectClass2(){
        var selected = $('#detailTable').bootstrapTable("getSelections");
        var dataNum=$('#detailTable').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
            if(item.status != 1){
                alert("只能操作已经启用的数据！")
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
                url: "/ideaWorkSpace/book/auditNotpro2",    //请求的url地址
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
    }
    /*新建*/

    $('#insert1').on('click',function(){
        $.ajax({
            url: "/ideaWorkSpace/book/insertpro1",    //请求的url地址
            dataType: "json",   //返回格式为json
            data: JSON.stringify($.extend(true, {},convertSerializeArrayToObject($("#form_insertClass1_q").serializeArray()))),
            type: "POST",   //请求方式
            contentType:"text/html;charset=utf-8",
            beforeSend: function() {
            },
            success: function(data) {
                try {
                    if(data){
                        console.log(JSON.stringify(data));
                        var jsonData = JSON.parse(JSON.stringify(data));
                        console.log(jsonData.resultMassage );
                        if(jsonData.resultMassage == 'ok'){
                            alert("插入成功!")
                            $("#form_insertClass1_q")[0].reset();
                            $('#modal_insertSearchBtn').modal("hide");
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
    });
    $('#insert2').on('click',function(){
        $.ajax({
            url: "/ideaWorkSpace/book/insertpro2",    //请求的url地址
            dataType: "json",   //返回格式为json
            data: JSON.stringify($.extend(true, {},convertSerializeArrayToObject($("#form_insertClass2_q").serializeArray()))),
            type: "POST",   //请求方式
            contentType:"text/html;charset=utf-8",
            beforeSend: function() {
            },
            success: function(data) {
                try {
                    if(data){
                        console.log(JSON.stringify(data));
                        var jsonData = JSON.parse(JSON.stringify(data));
                        console.log(jsonData.resultMassage );
                        if(jsonData.resultMassage == 'ok'){
                            alert("插入成功!")
                            $("#form_insertClass2_q")[0].reset();
                            $('#modal_insertClass2').modal("hide");
                            $('#detailTable').bootstrapTable('refresh',{
                                url: '/ideaWorkSpace/book/bookpro2'
                            });
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
    });
</script>
</body>
</html>