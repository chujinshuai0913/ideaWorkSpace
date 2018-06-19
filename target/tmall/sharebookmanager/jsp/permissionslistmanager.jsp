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
                <label onclick="$(this).next().focus();">权限路径</label>
                <input name="url" type="text" class="form-control" placeholder="权限路径"/>

            </div>
            <div class="form-group" style="margin-left: 30px;">
                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                &nbsp;&nbsp;
                <button type="button" id="insertPer" class="btn btn-success">添加权限</button>
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
                <h4 class="modal-title" id="modalTitle">添加权限</h4>
            </div>
            <form id="form_inserPer_q" >
                <div class="modal-body">
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">url</label>
                        <input name="url" type="text" style="margin-left:50px;display: inline;" class="form-control" placeholder="url"/>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">url名称</label>
                        <input name="urlName" type="text" style="margin-left:20px;display: inline;" class="form-control" placeholder="url名称"/>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;">
                    <label></label>
                    <button type="button" id="insertPermission" class="btn btn-primary" data-style="zoom-in"
                            formaction="javascript:void(0);">确认
                    </button>&nbsp;&nbsp;
                    <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                </div>
            </form>
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
        url: '/ideaWorkSpace/usersharemanager/getgroupname',
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
                visible:false,

            },
            {
                field: 'url',
                title: 'url',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'urlName',
                title: '路径名称',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'status',
                title: '状态',
                align: "center",
                formatter :function(value, row, index) {
                    if(value==1){
                        return [ "<a style='cursor: pointer;' class='record-detail'>启用</a>"].join('');
                    }
                    else if(value==2){
                        return [ "<a style='cursor: pointer;' class='record-detail'>未启用</a>"].join('');
                    }

                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog(e, value, row, index);
                    }
                }

            }
        ]
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

    //修改状态
    function detailTableDialog(e, value, row, index){
        $.ajax({
            url: "/ideaWorkSpace/usersharemanager/updateperstatus",    //请求的url地址
            dataType: "json",   //返回格式为json
            data: JSON.stringify({status:row.status,id:row.id}),    //参数值
            type: "POST",   //请求方式
            contentType:"text/html;charset=utf-8",
            beforeSend: function() {
            },
            success: function(data) {
                try {
                    if(data){
                        var jsonData = JSON.parse(JSON.stringify(data));
                        if(jsonData.resultMassage == 'ok'){
                           alert("修改成功!");
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
    }

    $("#insertPer").on('click',function () {
        $('#modal_detailTable').modal("show");
    })
    $("#insertPermission").on('click',function () {
        var params = convertSerializeArrayToObject($("#form_inserPer_q").serializeArray());
        $.ajax({
            url: "/ideaWorkSpace/usersharemanager/insertpermission",    //请求的url地址
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
                            $("#form_inserPer_q")[0].reset();
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


    })
</script>
</body>
</html>