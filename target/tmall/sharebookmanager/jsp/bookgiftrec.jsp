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
                <label for="gTime" style="width:60px;">回收时间</label>
                <div class="input-group date">
                    <input type="text" class="form-control" style="width: 147px;"
                           id="gTime" name="gTime"
                           placeholder="回收时间"> <span class="input-group-addon"><i
                        class="glyphicon glyphicon-th"></i></span>
                </div>
            </div>
            <div class="form-group" style="margin-left: 30px;">
                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>

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
                <h4 class="modal-title" id="modalTitle">回收书籍处理</h4>
            </div>
            <form id="form_inserPer_q" >
                <div class="modal-body">
                    <input id="recnum"style="display: none"/>
                    <input id="recId" name="id" style="display: none"/>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">处理数量</label>
                        <input id="success" name="success" type="text" style="margin-left:20px;display: inline;" class="form-control" placeholder="处理数量"/>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;display: inline;">去向说明</label>
                        <input name="remark" type="text" style="margin-left:20px;display: inline;" class="form-control" placeholder="去向说明"/>
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
</div>
<script type="text/javascript">

    $('#gTime').val(getNowDate());
    $('#gTime').datepicker({
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
        toolbar: "#toolbar_book",
        url: '/ideaWorkSpace/book/bookgiftrec',
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
        }, {
            field: 'id',
            title: 'id',
            align: "center",
            visible:false,
        }, {
                field: 'bookName',
                title: '书名',
                align: "center",
            },{
                field: 'sellerName',
                title: '赠书人',
                align: "center",
                formatter: formatterToValue
            },{
                field: 'phoneNumber',
                title: '电话',
                align: "center",
               formatter: formatterToValue
            },
            {
                field: 'gTime',
                title: '回收时间',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'num',
                title: '回收数量',
                align: "center",
            },{
                field: 'success',
                title: '赠出数量',
                align: "center",
                formatter :formatterToValue

            },{
                field: 'remark',
                title: '去向说明',
                align: "center",
                formatter :formatterToValue

            },{
                field: 'cName',
                title: '处理人',
                align: "center",
                formatter :formatterToValue

            },{
                field: 'cTime',
                title: '处理时间',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'cTime',
                title: '处理时间',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: '操作',
                title: '处理时间',
                align: "center",
                formatter :function(value, row, index) {
                    if(row.num!=row.success){
                        return [ "<a style='cursor: pointer;' class='record-detail'>待处理</a>"].join('');
                    }
                    else {
                        return "已完成";
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
        $('#modal_detailTable').modal("show");
        var recnum=row.num-row.success;
        $("#recnum").val(recnum);
        $("#recId").val(row.id);

    }
    $("#insertPermission").on('click',function () {
         if($("#recnum").val()<$("#success").val()){
             alert("处理量大于剩余量了");
             return;
         }

        $.ajax({
            url: "/ideaWorkSpace/book/resolveBook",    //请求的url地址
            dataType: "json",   //返回格式为json
            data: JSON.stringify(convertSerializeArrayToObject($("#form_inserPer_q").serializeArray())),    //参数值
            type: "POST",   //请求方式
            contentType:"text/html;charset=utf-8",
            beforeSend: function() {
            },
            success: function(data) {
                try {
                    if(data){
                        var jsonData = JSON.parse(JSON.stringify(data));
                        if(jsonData.resultMassage == 'ok'){
                            alert("处理成功!");
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
    })

</script>
</body>
</html>