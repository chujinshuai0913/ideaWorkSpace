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
                <label onclick="$(this).next().focus();">姓名</label> <input
                    name="username" type="text" class="form-control" placeholder="姓名模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">手机号</label>
                <input name="phoneNumber" type="text" class="form-control" placeholder="手机号"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">学号/工号</label> <input
                    name="workId" type="text" class="form-control" placeholder="学号/工号"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">角色</label>
                <select  id="roleId" name="roleId" type="text" class="form-control">
                    <option value="">全部</option>
                </select>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label for="startSignDate" style="width:60px;">注册日期</label>
                <div class="input-group date">
                    <input type="text" class="form-control" style="width: 147px;"
                           id="startSignDate" name="startSignDate"
                           placeholder="注册日期(开始)"> <span class="input-group-addon"><i
                        class="glyphicon glyphicon-th"></i></span>
                </div>
            </div>
            <div class="form-group">
                <label for="endSignDate" style="width: 30px;">至</label>
                <div class="input-group date">
                    <input type="text" class="form-control" style="width: 147px;"
                           id="endSignDate" name="endSignDate" placeholder="注册日期(结束)">
                    <span class="input-group-addon"><i
                            class="glyphicon glyphicon-th"></i></span>
                </div>
            </div>
            <div class="form-group" style="margin-left: 30px;">

                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                <button type="button" id="insertUserManager" class="btn btn-success" data-style="zoom-in"
                        formaction="javascript:void(0);">注册新用户
                </button>&nbsp;&nbsp;
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
                <h4 class="modal-title" id="modalTitle">认证信息</h4>
            </div>
            <div class="modal-body">
                <table id="detailTable"></table>
            </div>
        </div>
    </div>
</div>
</div>
<div id="modal_detailTable1" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="400px" style="width:400px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle1">授予角色</h4>
            </div>
            <form id="form_updateRole_q" >
                <div class="modal-body">

                    <table class="table table-add-or-update" style="margin-top: 30px;" border="0">
                        <input type="text" id="userId" name="id" value="" hidden="hidden"/>
                        <tbody>
                        <tr class="has-success">
                            <td class="control-label" style="width: 100px;border: 0;">角色</td>
                            <td class="control-label" style="border: 0;">
                                <select id="roleId1" name="roleId" type="text" class="form-control">
                                </select>
                            </td>
                        </tr>
                        </tbody>
                    </table>

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

<div id="modal_detailTable2" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="400px" style="width:400px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle2">注册新用户</h4>
            </div>
            <form id="form_insertUser_q" >
                <div class="modal-body">
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">姓名</label>
                        <input name="username" type="text" style="margin-left:30px;display: inline;" class="form-control" placeholder="姓名"/>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">手机号</label>
                        <input name="phoneNumber" type="text" style="margin-left:20px;display: inline;" class="form-control" placeholder="手机号"/>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">学号</label>
                        <input name="workId" type="text" style="margin-left:30px;display: inline;" class="form-control" placeholder="学号"/>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 250px;">
                    <label></label>
                    <button type="button" id="insertUser" class="btn btn-primary" data-style="zoom-in"
                            formaction="javascript:void(0);">确认
                    </button>&nbsp;&nbsp;
                    <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    $('#startSignDate').val(getNowDate());
    $('#endSignDate').val(getNowDate(1));
    $('#startSignDate').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        language: "zh-CN"
    });
    $('#endSignDate').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        language: "zh-CN"
    });

    //初始化配送日期
    function getNowDate(isNext) {
        var d = new Date();
        var timestamp = d.getTime();
        console.log("timestamp:" + timestamp);
        var hour = d.getHours();
        if (hour >= 12) {
            d = new Date(timestamp);
        }
        if (isNext && hour > 12) {
            timestamp += 86400000;
            console.log("timestamp2:" + timestamp);
            d = new Date(timestamp);
        }
        var year = d.getFullYear() + "";
        var month = d.getMonth() + 1 + "";
        var day = d.getDate() + "";
        return year + "-" + ((month.length == 1) ? ("0" + month) : month)
            + "-" + ((day.length == 1) ? ("0" + day) : day);
    }




    $('#formSearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_sharebookuser",
        url: '/ideaWorkSpace/usersharemanager/userlistData',
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

            },
            {
                field: 'username',
                title: '姓名',
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
                field: 'workId',
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

            }, {
                field: 'lTime',
                title: '上次登录时间',
                align: "center",
                formatter: formatterToValue

            }/*,{
                field: 'loginNum',
                title: '登录次数',
                align: "center",
                class:'W30',
                formatter: formatterToValue

            }*/,
            {
                field: 'role',
                title: '角色',
                align: "center",
                formatter :function(value, row, index) {
                    if(row.roleId>0){
                        return [ "<a  class='record-detail'>",''+value+'','</a>' ].join('');
                    }else{
                        return value;
                    }
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog1(e, value, row, index);
                    }
                }


            },
            {
                field: 'sTime',
                title: '注册时间',
                align: "center",
                formatter: formatterToValue

            }/*,{
                field: 'dTime',
                title: '注销时间',
                align: "center",
                class:'W30',
                formatter: formatterToValue

            }*/
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
                var idParam={workId:workId};
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
    var workId=0;
    function detailTableDialog(e, value, row, index){

        $('#modal_detailTable').modal("show");
        workId=row.workId;
        $('#detailTable').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/usershare/userlistDetail',
            query:{
                workId:workId
            }
        });
    }
    function detailTableDialog1(e, value, row, index){
        $('#modal_detailTable1').modal("show");
        $('#userId').val(row.id);
    }
   $("#insertUserManager").on('click',function () {
       $('#modal_detailTable2').modal("show");
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
            url: "/ideaWorkSpace/usersharemanager/updaterole",    //请求的url地址
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
                            $('#modal_detailTable1').modal("hide");
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
    $.ajax({
        url: "/ideaWorkSpace/usersharemanager/rolelistData",    //请求的url地址
        dataType: "json",   //返回格式为json
        data: JSON.stringify({id:1}),    //参数值
        type: "POST",   //请求方式
        contentType:"text/html;charset=utf-8",
        beforeSend: function() {
        },
        success: function(data) {
            try {
                if (data.error_code == 0){
                    list = JSON.parse(JSON.stringify(data.data));
                    if(list.length>0){
                        list.forEach(function (item) {
                            $("#roleId").append("<option value='"+item.id+"'>"+item.role+"</option>");
                            $("#roleId1").append("<option value='"+item.id+"'>"+item.role+"</option>");
                        })
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

    $("#insertUser").on('click',function () {
        var params = convertSerializeArrayToObject($("#form_insertUser_q").serializeArray());
        $.ajax({
            url: "/ideaWorkSpace/usersharemanager/insertusermanager",    //请求的url地址
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
                            alert("新建成功，默认权限业务管理员，默认密码1234567，请尽快修改密码！");
                            $('#modal_detailTable2').modal("hide");
                            $('#mainTable').bootstrapTable('refresh');
                            $("#form_insertUser_q")[0].reset();
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