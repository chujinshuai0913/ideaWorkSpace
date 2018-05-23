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
                <label onclick="$(this).next().focus();">ISBN</label> <input
                    name="isbn" type="text" class="form-control" placeholder="ISBN"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">书名</label> <input
                    name="bookName" type="text" class="form-control" placeholder="书名模糊查询"/>
            </div>
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
                <input type="text" name="professionalTypeName1"  class="form-control" placeholder="学院"/>

            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">专业</label>
                <input type="text" name="professionalTypeName2"  class="form-control" placeholder="专业"/>

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
        <table  id="mainTable"></table>
    </div>
</div>
<div id="modal_detailTable" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="900px" style="width:900px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" id="modalTitle">店家</h4>
                <form id="form_sell_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
                      onkeydown="if(event.keyCode==13){return false;}">
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();">姓名</label>
                        <input  name="sellerUser" type="text" class="form-control" placeholder="姓名查询"/>
                        <input  name="importUser" type="text" value="1" hidden="hidden"/>
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
                <h5 class="modal-title">售卖</h5>
                <table id="detailTable1"></table>
            </div>
            <div class="modal-body">
                <h5 class="modal-title">租借</h5>
                <table id="detailTable2"></table>
            </div>
            <div class="modal-body">
                <h5 class="modal-title">赠予</h5>
                <table id="detailTable3"></table>
            </div>
            <div class="modal-body">
                <h5 class="modal-title">竞拍</h5>
                <table id="detailTable4"></table>
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
        toolbar: "#toolbar_book",
        url: '/ideaWorkSpace/book/bookListData',
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
                field: 'userableNum',
                title: 'userableNum',
                align: "center",
                visible:false,

            },  {
                field: 'preNum',
                title: 'preNum',
                align: "center",
                visible:false,

            },
            {
                field: 'bookName',
                title: '书名',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'phoneNumber',
                title: 'ISBN',
                align: "center",
                formatter: formatterToValue

            }
            ,
            {
                field: 'author',
                title: '作者',
                align: "center",
            },
            {
                field: 'press',
                title: '出版社',
                align: "center",
                formatter: formatterToValue

            }, {
                field: 'pTime',
                title: '出版日期',
                align: "center",
                formatter: formatterToValue

            }, {
                field: 'pageNumber',
                title: '页数',
                formatter: formatterToValue

            }, {
                field: 'pricing',
                title: '定价',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.price){
                        return  row.pricing + ' ' + row.pricingunit;
                    }
                    else{
                        return '-';
                    }

                }
            }, {
                field: 'sellerNumber',
                title: '店家数量',
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
                field: 'professionalTypeName1',
                title: '学院',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'professionalTypeName2',
                title: '专业',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'bookTypeName1',
                title: '图书一级分类',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'bookTypeName2',
                title: '图书二级分类',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'introduce',
                title: '简介',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'num',
                title: '库存量',
                align: "center",
                formatter :function(value, row, index) {
                        return row.userableNum+row.preNum;
                }

            },{
                field: 'useNum',
                title: '出货量',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'eUser',
                title: '导出人',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'eTime',
                title: '导出时间',
                align: "center",
                formatter: formatterToValue

            }
        ]
    });
    $("#detailTable1").bootstrapTable(
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
                var idParam={ skuId:skuId};
                var userParams=convertSerializeArrayToObject($("#form_sell_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'sellerName',
                    title : '卖书人',
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
                    field : 'num',
                    title : '库存',
                    formatter :function(value, row, index) {
                        return row.useableNum+row.preNum;
                    }
                },
                {
                    align: "center",
                    field : 'unit',
                    title : '售价',
                    formatter: function (value, row, index) {
                        if(row.price){
                            return  row.price + ' ' + row.pricingunit;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'useNum',
                    title : '交易量',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'dTime',
                    title : '上一次交易时间',
                    formatter: formatterToValue
                }]
        });
    $("#detailTable2").bootstrapTable(
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
                var idParam={ skuId:skuId};
                var userParams=convertSerializeArrayToObject($("#form_sell_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'sellerName',
                    title : '出租人',
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
                    field : 'num',
                    title : '库存',
                    formatter :function(value, row, index) {
                        return row.useableNum+row.preNum;;
                    }
                },
                {
                    align: "center",
                    field : 'unit',
                    title : '租金',
                    formatter: function (value, row, index) {
                        if(row.price){
                            return  row.price + ' ' + row.pricingunit;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'unit',
                    title : '押金',
                    formatter: function (value, row, index) {
                        if(row.price){
                            return  row.depositPrice + '' + row.pricingunit;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'unit',
                    title : '逾期租金',
                    formatter: function (value, row, index) {
                        if(row.price){
                            return  row.beyondPrice +' ' + row.pricingunit;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'useNum',
                    title : '出借量',
                    formatter: formatterToValue
                }]
        });
    $("#detailTable3").bootstrapTable(
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
                var idParam={ skuId:skuId};
                var userParams=convertSerializeArrayToObject($("#form_sell_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'sellerName',
                    title : '赠书人',
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
                    field : 'num',
                    title : '库存',
                    formatter :function(value, row, index) {
                    return row.useableNum+row.preNum;
                }
                },
                {
                    align: "center",
                    field : 'useNum',
                    title : '送出量',
                    formatter: formatterToValue
                }
             ]
        });
    $("#detailTable4").bootstrapTable(
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
                var idParam={ bookId:bookId};
                var userParams=convertSerializeArrayToObject($("#form_sell_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'sellerName',
                    title : '出拍人',
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
                    field : 'auctionName',
                    title : '场次名称',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'unit',
                    title : '起拍价',
                    formatter: function (value, row, index) {
                        if(row.price){
                            return  row.price +' ' + row.pricingunit;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'sTime',
                    title : '开始时间',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'eTime',
                    title : '结束时间',
                    formatter: formatterToValue
                }]
        });
    //弹出层
    var skuId=0;
    var bookId=0;
    function detailTableDialog(e, value, row, index){
        $('#modal_detailTable').modal("show");
        skuId=row.id;
        bookId=row.id;
        userName=$('#userName').val();
        $('#detailTable1').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookselling',
            query:{
                skuId:skuId
            }
        });
        $('#detailTable2').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookborrow',
            query:{
                skuId:skuId
            }
        });
        $('#detailTable3').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookgift',
            query:{
                skuId:skuId
            }
        });

        $('#detailTable4').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookauction',
            query:{
                bookId:bookId
            }
        });
    }

    $('#formSellSearchBtn').on('click', function () {
        $('#detailTable1').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookselling',
            query:{
                skuId:skuId
            }
        });
        $('#detailTable2').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookborrow',
            query:{
                skuId:skuId
            }
        });
        $('#detailTable3').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookgift',
            query:{
                skuId:skuId
            }
        });

        $('#detailTable4').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/book/bookauction',
            query:{
                bookId:bookId
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

</script>
</body>
</html>