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
                <label onclick="$(this).next().focus();">学号/工号</label> <input
                    name="workId" type="text" class="form-control" placeholder="学号/工号"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">角色</label>
                <select  name="roleId" type="text" class="form-control">
                    <option value="">全部</option>
                    <option value="1"> 超级管理员</option>
                    <option value="2"> 运营管理员</option>
                    <option value="3"> 业务管理员</option>
                </select>
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
        <table  id="mainTable"></table>
    </div>
</div>
<div id="modal_detailTable" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="400px" style="width:400px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle">修改角色</h4>
            </div>
            <form id="form_updateRole_q" >
            <div class="modal-body">

                        <table class="table table-add-or-update" style="margin-top: 30px;" border="0">
                            <input type="text" id="userId" name="id" value="" hidden="hidden"/>
                            <tbody>
                              <tr class="has-success">
                                <td class="control-label" style="width: 100px;border: 0;">角色</td>
                                <td class="control-label" style="border: 0;">
                                    <select id="roleId" name="roleId" type="text" class="form-control">
                                        <option value="">全部</option>
                                        <option value="1"> 超级管理员</option>
                                        <option value="2"> 运营管理员</option>
                                        <option value="3"> 业务管理员</option>
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
</div>
<script type="text/javascript">

    $('#formSearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_sharebookuser",
        url: '/ideaWorkSpace/usersharemanager/userRolelistData',
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
                field: 'roleId',
                title: 'roleId',
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
                field: 'workId',
                title: '学号/工号',
                align: "center",
                formatter :function(value, row, index) {
                    if(value>0){
                        return value
                    }else{
                        return '-';
                    }
                }

            },
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
                        detailTableDialog(e, value, row, index);
                    }
                }

            }
        ]
    });
    //弹出层

    function detailTableDialog(e, value, row, index){
        $('#modal_detailTable').modal("show");
        $('#userId').val(row.id);
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
    //导出
    $('#exportBtn').on('click', function () {
        // 1. 未勾选时导出全部
        var selectedRecords = $('#mainTable').bootstrapTable("getSelections");
        var dataNum=$('#mainTable').bootstrapTable("getOptions").data.length;
        if(dataNum===0){
            return true;
        }else{
            if (selectedRecords.length === 0) {
                $.confirm({
                    title: '导出确认',
                    confirmButton: "确认",
                    cancelButton: "取消",
                    content: '你未勾选记录，将会导出全部?',
                    confirm: function(){
                        var $form = $('#form_sharebookuser_q').clone();
                        $form.attr({'action':'/usershare/exportShareUserAll',"method":"post"});
                        $('body').append($form);
                        $form.hide();
                        $form.submit();
                        $form.remove();
                        return true;
                    }
                });
                return true;
            }else{
                // 勾选时按勾选的导出
                var $exportForm = $("<form></form>");
                $exportForm.attr({
                    "style":"display:none",
                    "action":"/usershare/exportShareUser",
                    "method":"post",
                });
                var reportJson = JSON.stringify($table.bootstrapTable('getSelections'));
                var $idCheckbox = $("<input type='text' name='reportJson' value='"+reportJson+"'/>")
                $idCheckbox.appendTo($exportForm);
                console.log($exportForm);
                $(document.body).append($exportForm);
                $exportForm.submit();
                $exportForm.remove();
            }
        }
    });
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
                                $('#modal_detailTable').modal("hide");
                                $('#mainTable').bootstrapTable('refresh');
                            }else{
                                alert("修改失败！");
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