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
            <%--<div class="form-group" style="margin-left: 50px;">
                <label for="strTime" style="width:60px;">认证日期</label>
                <div class="input-group date">
                    <input type="text" class="form-control" style="width: 147px;"
                           id="strTime" name="strTime"
                           placeholder="认证日期"> <span class="input-group-addon"><i
                        class="glyphicon glyphicon-th"></i></span>
                </div>
            </div>--%>
            <div class="form-group" style="margin-left: 50px;">

                <label onclick="$(this).next().focus();">姓名</label> <input
                    name="stName" type="text" class="form-control" placeholder="姓名模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">学号/工号</label> <input
                    name="idNumber" type="text" class="form-control" placeholder="学号/工号"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">

                <label onclick="$(this).next().focus();">学院</label> <input
                    name="professional1Name" type="text" class="form-control" placeholder="学院模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">

                <label onclick="$(this).next().focus();">专业</label> <input
                    name="professional2Name" type="text" class="form-control" placeholder="专业模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 30px;">
                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                &nbsp;&nbsp;
                <button type="button" id="importExcel" class="btn btn-success">导入</button>

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
                <h4 class="modal-title" id="modalTitle">导入</h4>
            </div>
            <form id="formId" enctype="multipart/form-data">

                   <input type="file" id="uploadEventFile" name="upfile" style="margin-top: 40px;margin-left: 100px;" size="50" />
                    <br />
                <div class="form-group" style="margin-left: 100px;">
                    <button type="button" id="importExcelSure" class="btn btn-primary" data-style="zoom-in"
                            formaction="javascript:void(0);">确认
                    </button>&nbsp;&nbsp;
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    $("#importExcel").on('click',function () {
        $('#modal_detailTable').modal("show");
    })

    $('#importExcelSure').on('click', function () {
        var uploadEventFile = $("#uploadEventFile").val();
        if (uploadEventFile == '') {
            alert("请选择excel,再上传");
        } else if (uploadEventFile.lastIndexOf(".xls") < 0) {//可判断以.xls和.xlsx结尾的excel
            alert("只能上传Excel文件");importExcelSure
        } else {
            var formData = new FormData($('#formId')[0]);
            $.ajax({
                url: "/ideaWorkSpace/usersharemanager/importStudent",    //请求的url地址
                dataType: "json",   //返回格式为json
                data: formData,    //参数值
                type: "POST",   //请求方式
                contentType:false ,
                cache: false,
                processData: false,
                beforeSend: function () {
                },
                success: function (data) {
                    try {
                        console.log(JSON.stringify(data));
                        if (data) {
                            $('#modal_detailTable').modal("hide");
                            $('#mainTable').bootstrapTable('refresh');
                            alert(data.resultMassage)
                        }
                    } catch (e) {
                        console.log(e.message);
                    }
                },
                complete: function () {
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }
    })
    $('#strTime').val(getNowDate());
    $('#strTime').datepicker({
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
        url: '/ideaWorkSpace/usersharemanager/studenteacherlist',
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
                field: 'stName',
                title: '姓名',
                align: "center",
                class:'W30',
                formatter: formatterToValue

            }
            ,
            {
                field: 'idNumber',
                title: '学号/工号',
                align: "center",
                class:'W30',
                formatter :formatterToValue,
            }, {
                field: 'professional1Name',
                title: '学院',
                align: "center",
                class:'W30',
                formatter: formatterToValue

            },{
                field: 'professional2Name',
                title: '专业',
                align: "center",
                class:'W30',
                formatter: formatterToValue

            },
            {
                field: 'strT',
                title: '认证时间',
                align: "center",
                class:'W30',
                formatter: formatterToValue

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

</script>
</body>
</html>