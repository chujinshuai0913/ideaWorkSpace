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
                <label onclick="$(this).next().focus();">书名</label> <input
                    name="bookName" type="text" class="form-control" placeholder="书名模糊查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">出拍人</label> <input
                    name="sellerUser" type="text" class="form-control" placeholder="卖书人查询"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">学院</label>
                <input type="text" name="professionalType1"  class="form-control" placeholder="学院"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">专业</label>
                <input type="text" name="professionalType2"  class="form-control" placeholder="专业"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">状态</label>
                <select type="text" name="status"  class="form-control" >
                    <option value="">全部</option>
                    <option value="1">未审核</option>
                    <option value="2">已审核</option>
                    <option value="3">禁卖</option>
                    <option value="4">竞拍中</option>
                    <option value="5">已成交</option>
                    <option value="6">流拍</option>
                </select>
            </div>
            <div class="form-group" style="margin-left: 30px;">
                <label></label>
                <button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
                        formaction="javascript:void(0);">查询
                </button>&nbsp;&nbsp;
                <button type="reset" class="btn btn-warning">重置</button>

            </div>
            <div class="form-group" style="margin-left: 30px;">
                <button type="button" class="btn btn-success" onclick="audited()">审核</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" onclick="reject()">禁卖</button>
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
                <h4 class="modal-title" id="modalTitle">竞拍记录</h4>
                <form id="form_sell_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
                      onkeydown="if(event.keyCode==13){return false;}">
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();">姓名</label>
                        <input  name="userName" type="text" class="form-control" placeholder="姓名查询"/>
                    </div>
                    <div class="form-group" style="margin-left: 30px;">
                        <label></label>
                        <button type="button" id="formSellSearchBtn" class="btn btn-primary" data-style="zoom-in"
                                formaction="javascript:void(0);">查询
                        </button>&nbsp;&nbsp;
                        <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                    </div>
                </form>
            </div>
            <div class="modal-body">
                <table id="detailTable"></table>
            </div>

        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    $('#formSearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_book",
        url: '/ideaWorkSpace/book/bookauction',
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
                field: 'sellerName',
                title: '出拍人',
                align: "center",
                formatter: formatterToValue
            },  {
                field: 'phoneNumber',
                title: '电话',
                align: "center",
                visible:false,

            },
            {
                field: 'auctionName',
                title: '书名',
                align: "center",
                formatter: formatterToValue

            }/*,
            {
                field: 'remark',
                title: '介绍',
                align: "center",
            }*/,{
                field: 'uTime',
                title: '上传时间',
                align: "center",
                formatter: formatterToValue

            }, {
                field: 'sTime',
                title: '起拍时间',
                formatter: formatterToValue

            }, {
                field: 'eTime',
                title: '结束时间',
                formatter: formatterToValue

            },
            {
                field: 'price',
                title: '起拍价',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.price){
                        return  row.price + ' 元';
                    }
                    else{
                        return '-';
                    }

                }
            }, {
                field: 'dealPrice',
                title: '成交价',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.dealPrice){
                        return  row.dealPrice + ' 元';
                    }
                    else{
                        return '-';
                    }

                }
            }, {
                field: 'buyerName',
                title: '成交人',
                align: "center",
                formatter:formatterToValue
            },{
                field: 'professionalTypeName1',
                title: '学院',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'professionalTypeName2',
                title: '专业',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'status',
                title: '状态',
                align: "center",
                formatter :function(value, row, index) {
                    if(value==4||value==5||value==6){
                        return [ "<a  class='record-detail'>",''+switch_status(value)+'','</a>' ].join('');
                    }else{
                        return switch_status(value);
                    }
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog(e, value, row, index);
                    }
                }
            },{
                field: 'cName',
                title: '操作人',
                align: "center",
                formatter: formatterToValue

            },{
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
                var idParam={auctionId:auctionId};
                var userParams=convertSerializeArrayToObject($("#form_sell_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'userName',
                    title : '出价人',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'phoneNumber',
                    title : '手机',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'price',
                    title : '出价',
                    formatter: function (value, row, index) {
                        if(row.price){
                            return  row.price + '  元' ;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'aTime',
                    title : '出价时间',
                    formatter:formatterToValue
                }]
        });
    //弹出层
    var auctionId=0;
    function detailTableDialog(e, value, row, index){
        $('#modal_detailTable').modal("show");
        auctionId=row.id;
        $('#detailTable').bootstrapTable('refresh',{

            url: '/ideaWorkSpace/book/recordauction',
            query:{
                auctionId:auctionId
            }
        });
    }

    $('#formSellSearchBtn').on('click', function () {
        $('#detailTable').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/recordauction',
            query:{
                auctionId:auctionId
            }
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
            if(item.status != 1){
                alert("只能操作待审批过的数据！")
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
                url: "/ideaWorkSpace/book/auditBookAuction",    //请求的url地址
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
                alert("只能操作待审批过的数据！")
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
                url: "/ideaWorkSpace/book/auditNotAuction",    //请求的url地址
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
    //<!--状态,1待审批2审批通过3：禁卖 4竞拍中 5 拍卖完成 6 流拍  -->
    function switch_status(status){
        var text = "";
        switch(status){
            case 1:
                text = '待审批';
                break;
            case 2:
                text = '已审批';
                break;
            case 3:
                text = '禁卖';
                break;
            case 4:
                text = '竞拍中';
                break;
            case 5:
                text = '已成交';
                break;
            case 6:
                text = '流拍';
                break;
            default:
        }
        return text;
    }

</script>
</body>
</html>