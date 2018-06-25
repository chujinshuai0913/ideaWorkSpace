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
            <div class="form-group" style="margin-left: 500px;">
                <label></label>
                <button type="button" id="insertRole" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">新增角色
                </button>&nbsp;&nbsp;
            </div>
        </form>
    </div>
    <div id="panel-body" style="width: 98%;margin: auto;">
        <table  id="mainTable"></table>
    </div>
</div>
<div id="modal_detailTable" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="400px" style="width:400px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle">添加角色</h4>
            </div>
            <form id="form_updateRole_q" >
            <div class="modal-body">
                <div class="form-group" style="margin-left: 50px;">
                    <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">名称</label>
                    <input name="role" type="text" style="margin-left:20px;display: inline;" class="form-control" placeholder="名称"/>
                </div>
             </div>
            <div class="form-group" style="margin-left: 250px;">
                <label></label>
                <button type="button" id="updatRole" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">确认
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
            </div>
            </form>
        </div>
    </div>
</div>
<div id="modal_detailTable1" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="900px" style="width:900px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle1">权限</h4>
                <form id="form_insertPer_q" >
                    <input id="roleId" name="roleId" type="text" style="display: none;" >
                    <div class="form-group" style="margin-left: 550px;">
                        <label></label>
                        <button type="button" id="insertPerSet" class="btn btn-primary" data-style="zoom-in"
                                formaction="javascript:void(0);">添加新权限
                        </button>&nbsp;&nbsp;
                    </div>
                </form>
            </div>
            <div class="modal-body">
                <table id="detailTable"></table>
            </div>
        </div>
    </div>
</div>
<div id="modal_detailTable2" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="900px" style="width:900px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle2">权限</h4>
                <form id="form_insertPer_q2" >
                    <input id="roleId2" name="roleId" type="text" style="display: none;" >
                    <div class="form-group" style="margin-left: 550px;">
                        <label></label>
                        <button type="button" id="deletePerSet" class="btn btn-primary" data-style="zoom-in"
                                formaction="javascript:void(0);">解除权限
                        </button>&nbsp;&nbsp;
                    </div>
                </form>
            </div>
            <div class="modal-body">
                <table id="detailTable2"></table>
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
        url: '/ideaWorkSpace/usersharemanager/rolelistData',
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
        columns: [
            {
                field: 'id',
                title: 'id',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'role',
                title: '角色',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: '操作',
                title: '操作',
                align: "center",
                formatter :function(value, row, index) {
                    return [ "[<a  class='record-detail'>授予权限</a>]  [<a class='delete-detail'>解除权限</a>]" ].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog(e, value, row, index);
                    },
                    'click .delete-detail': function (e, value, row, index) {
                        detailTableDialog1(e, value, row, index);
                    }
                }


            }
        ]
    });
$("#insertRole").on('click',function () {
    $('#modal_detailTable').modal("show");
 })
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
    $('#updatRole').on('click', function () {
          var params = convertSerializeArrayToObject($("#form_updateRole_q").serializeArray());
            $.ajax({
                url: "/ideaWorkSpace/usersharemanager/insertrole",    //请求的url地址
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
                                $('#modal_detailTable').modal("hide");
                                $('#mainTable').bootstrapTable('refresh');
                            }else{
                                alert(data.resultMassage);
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
    function detailTableDialog(e, value, row, index){
        $('#modal_detailTable1').modal("show");
        $('#roleId').val(row.id);
        $('#detailTable').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/usersharemanager/getpermissionurlno'
        });
    }
    function detailTableDialog1(e, value, row, index){
        $('#modal_detailTable2').modal("show");
        $('#roleId2').val(row.id);
        $('#detailTable2').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/usersharemanager/getpermissionurl'
        });
    }
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
                var newParams = $.extend(true,{},convertSerializeArrayToObject($("#form_insertPer_q").serializeArray()));
                newParams = $.extend(true, {}, params, newParams);
                return newParams;
            },
            columns : [
                {
                    checkbox: true
                },
                {
                    align: "center",
                    field : 'url',
                    title : 'url',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'urlName',
                    title : '路径名称',
                    formatter: formatterToValue
                }]
        });
    $("#detailTable2").bootstrapTable(
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
                var newParams = $.extend(true,{},convertSerializeArrayToObject($("#form_insertPer_q2").serializeArray()));
                newParams = $.extend(true, {}, params, newParams);
                return newParams;
            },
            columns : [
                {
                    checkbox: true
                },
                {
                    align: "center",
                    field : 'url',
                    title : 'url',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'urlName',
                    title : '路径名称',
                    formatter: formatterToValue
                }]
        });

    //添加权限
    $("#insertPerSet").on('click',function () {
        var roleId=$("#roleId").val();
        var selected = $('#detailTable').bootstrapTable("getSelections");
        var dataNum=$('#detailTable').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
                ids[index] = item.id;
        });
        if(flag){
            if(ids.length == 0){
                alert("最少要有一条数据！")
                flag = false;
                return false;
            }
            var params = {roleId:roleId,ids:ids};
            $.ajax({
                url: "/ideaWorkSpace/usersharemanager/insertperset",    //请求的url地址
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
                                $('#detailTable').bootstrapTable('refresh');
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



    //解除权限
    $("#deletePerSet").on('click',function () {
        var roleId=$("#roleId2").val();
        var selected = $('#detailTable2').bootstrapTable("getSelections");
        var dataNum=$('#detailTable2').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
            ids[index] = item.id;
        });
        if(flag){
            if(ids.length == 0){
                alert("最少要有一条数据！")
                flag = false;
                return false;
            }
            var params = {roleId:roleId,ids:ids};
            $.ajax({
                url: "/ideaWorkSpace/usersharemanager/deleteperset",    //请求的url地址
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
                                $('#detailTable2').bootstrapTable('refresh');
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