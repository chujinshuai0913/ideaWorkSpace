<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
	<title>我的闲置书</title>
	<meta charset="utf-8" />
	<title>燕鸣书屋</title>
	<script src="${basePath}/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>

	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-datepicker-1.5.0/js/bootstrap-datepicker.js" ></script>
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/css/bootstrap-table.css" />
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-3.3.5/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/tab_div.css">
</head>
<style>

</style>
<body>
<div class="homePage">
	<div class="headPage">
		<div class="headPagehead">
			<div class="headPagehead_text_one">
				<%--	${requestScope.user.id}--%>
				<font color="grey">你好 <span>楚金帅</span><input id="userId" type="text" type="text" style="display: none" value="1">，欢迎访问燕鸣书屋 !</font>
			</div>
			<div class="headPagehead_text_two">
				<span style="color: red; cursor:pointer">请登录</span>
				<span style="cursor:pointer">，免费注册</span>
				<span style="padding-left: 2px;font-size: 14px; ">|</span>
				<span style=" cursor:pointer">微信小程序</span>
			</div>
		</div>
		<div class="headPagebody">
			<div class="headPagebody_left">
				<img src="${basePath}/sharebook/img/燕鸣书屋.png" style="width:250px;height: 100px;padding-top: 10px; cursor:pointer"  alt="燕鸣书屋 " />
			</div>
			<div class="headPagebody_none ">
				<form action="/ideaWorkSpace/bookshare/searchresult1"  name="myform" method="post" >
					<div class="headPagebody_none_search " style="height: 48px" >
						<input class="headPagebody_none_search_text "  name="bookName1" type="text"  placeholder="书名" value="${requestScope.bookName1}"/>
						<button class="headPagebody_none_search_icon"  type="submit">搜索</button>
						<select name="classType1" name="searchSelect "  class="headPagebody_none_search_select">
							<option value="" <c:if test='${requestScope.classType1== ""}'>  selected='selected'  </c:if>>全部</option>
							<option value="1" <c:if test='${requestScope.classType1== "1"}'>  selected='selected'  </c:if>>买卖</option>
							<option value="2" <c:if test='${requestScope.classType1== "2"}'>  selected='selected'  </c:if>>租借</option>
							<option value="3" <c:if test='${requestScope.classType1== "3"}'>  selected='selected'  </c:if>>赠予</option>
						</select>
					</div>
				</form>
			</div>
			<div class="headPagebody_right ">
				<div class="headPagebody_right_text ">
					<div class="headPagebody_right_text_one ">
						<img src="${basePath}/sharebook/img/购物车.png " />
					</div>
					<div class="headPagebody_right_text_two ">
						<a href="${basePath}/sharebook/jsp/mycat.jsp"><p>我的书箱</p></a>
						<a href="${basePath}/sharebook/jsp/myput.jsp"><p>我的闲置书</p></a>
					</div>
				</div>
			</div>
		</div>

		<div class="navwrap ">
			<div class="navwrap_text ">
				<div class="navLeft ">
					<a style="color: white; " href="${basePath}/sharebook/jsp/bookClassification.jsp">全部图书分类</a><span><img src="${basePath}/sharebook/img/向下.png " alt="向下 " style="position:relative;top:5px;width: 20px;height: 20px; "/></span>
				</div>
				<div class="navwrap_text_right ">
					<ul>
						<li><a href="${basePath}/sharebook/jsp/shareindex.jsp">首页</a></li>
						<li><a href="${basePath}/sharebook/jsp/bookClassification.jsp">普通分类</a></li>
						<li><a href="${basePath}/sharebook/jsp/bookProification.jsp">按专业分类</a></li>
						<li><a href="# ">书籍竞拍</a></li>
						<li><a href="# ">资料共享</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="bodyPage">
		<div class="bodyPage_body">
			<div class="bodyPage_body_bookdetail_up">
				<div class="bodyPage_body_bookdetail_up_left" style="margin: auto">
					<ul class="tabs group">
						<li>
							<a class="active" href="#/one">售卖书籍</a>
						</li>
						<li>
							<a href="#/two">租借书籍</a>
						</li>
						<li>
							<a href="#/three">赠予书籍</a>
						</li>
						<li>
							<a href="#/four">竞拍书籍</a>
						</li>
					</ul>
					<div id="content">
						<div id="one" class="tab_div">
							<div class="panel panel-default" style="padding-right: 0px;">
								<div>
									<form id="form_bookselluser_q" class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px;"
										  onkeydown="if(event.keyCode==13){return false;}">
										<input type="text" name="id" style="display: none" value="${requestScope.bookVo.id}"/>
										<div class="form-group" style="margin-left: 10px;">
											<label onclick="$(this).next().focus();" style="font-size: 20px;">卖书</label>
										</div>
										<div class="form-group" style="margin-left: 30px;">
											<label></label>
											<button type="button" id="formSellSearchBtn" class="btn btn-primary"  data-style="zoom-in"
													style="width: 100px;height: 33px;"	formaction="javascript:void(0);">查询
											</button>&nbsp;&nbsp;&nbsp;&nbsp;
											<button type="button" id="insertSellBtn" class="btn btn-primary"  data-style="zoom-in"
													style="width: 100px;height: 33px;width: 200px;"	formaction="javascript:void(0);">还有要卖的书籍
											</button>
										</div>
									</form>
								</div>
								<div class="modal-body" style="width: 98%;margin: auto;">
									<table  id="mainTable1"></table>
								</div>
							</div>
					    </div>
						<div id="two" style="display: none;" class="tab_div">
						<div class="panel panel-default" style="padding-right: 0px;">
							<div>
								<form id="form_bookborrowuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<input type="text" name="id" style="display: none" value="${requestScope.bookVo.id}"/>
									<div class="form-group" style="margin-left: 10px;">
										<label onclick="$(this).next().focus();" style="font-size: 20px; ">出租书籍</label>
									</div>
                                    <div class="form-group" style="margin-left: 30px;">
                                            <label></label>
                                            <button type="button" id="formBorrowSearchBtn" class="btn btn-primary"  data-style="zoom-in"
                                                    style="width: 100px;height: 33px;"	formaction="javascript:void(0);">查询
                                            </button>&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" id="insertBorrowSearchBtn" class="btn btn-primary"  data-style="zoom-in"
												style="width: 100px;height: 33px;width: 200px;"	formaction="javascript:void(0);">还有书籍出租
										</button>
                                        </div>
								</form>
							</div>
							<div class="modal-body" style="width: 98%;margin: auto;">
								<table  id="mainTable2"></table>
							</div>
						</div>
					</div>
						<div id="three" style="display: none;" class="tab_div">
						<div class="panel panel-default" style="padding-right: 0px;">
							<div>
								<form id="form_bookgiftuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<input type="text" name="id" style="display: none" value="${requestScope.bookVo.id}"/>
									<div class="form-group" style="margin-left: 10px;">
										<label onclick="$(this).next().focus();" style="font-size: 20px; ">赠予书籍</label>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button" id="formGiftSearchBtn" class="btn btn-primary"  data-style="zoom-in"
												style="width: 100px;height: 33px;width: 200px"	formaction="javascript:void(0);">还有书籍赠予
										</button>
									</div>
								</form>
							</div>
							<div class="modal-body" style="width: 98%;margin: auto;">
								<table  id="mainTable3"></table>
							</div>
						</div>
					</div>
						<div id="four" style="display: none;" class="tab_div">
						<div class="panel panel-default" style="padding-right: 0px;">
							<div>
								<form id="form_bookauctionuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<input type="text" name="id" style="display: none" value="${requestScope.bookVo.id}"/>
									<div class="form-group" style="margin-left: 10px;">
										<label onclick="$(this).next().focus();" style="font-size: 20px; ">竞价书籍</label>
									</div>
									<div class="form-group" style="margin-left: 60%">
										<label onclick="$(this).next().focus();">竞价状态</label>
										<select type="text" name="state"  class="form-control" >
											<option value="">全部</option>
										</select>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button"  id="formAuctionSearchBtn" class="btn btn-primary"  data-style="zoom-in"
												style="width: 100px;height: 33px;width: 200px"	formaction="javascript:void(0);">添加要竞拍的书籍
										</button>
									</div>
								</form>
							</div>
							<div class="modal-body" style="width: 98%;margin: auto;">
								<table  id="mainTable4"></table>
							</div>
						</div>
					</div>

			    	</div>
				<%--<div class="bodyPage_body_bookdetail_up_right">
					<div class="bodyPagefirst_right_title ">
						<img src="${basePath}/sharebook/img/勋章.png " /><p>猜你喜欢</p>
					</div>
					<div class="bodyPagefirst_right_content ">
					</div>
				</div>--%>
			</div>

				<div id="modal_detailTable" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
					<div class="modal-dialog"  dialog-width="400px" style="width:400px;margin-top: 400px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
								 <h4 class="modal-title" id="modalTitle">输入书籍ISBN</h4>
								<form id="isbnIn"  class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px"
									  onkeydown="if(event.keyCode==13){return false;}">
								     <div class="form-group" style="margin-left: 30px;">
										<label onclick="$(this).next().focus();">ISBN</label>
										<input id="isbn" style="margin-left: 20px" name="isbn" type="text" class="form-control" placeholder="ISBN"/>
										<input id="status" name="status" type="text" style="display: none"/>
									</div>
									<div class="form-group" style="margin-left: 100px;margin-top: 20px">
										<label></label>
										<button type="button" id="insertSearchBtn" class="btn btn-primary" data-style="zoom-in"
												formaction="javascript:void(0);">确定
										</button>&nbsp;&nbsp;
										<button type="button" id="insertNotSearchBtn" class="btn btn-warning">没有ISBN</button>&nbsp;&nbsp;
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
		</div>
	</div>
</div>

</div>
</body>
<script>
    var userId=1;
    $('#formSellSearchBtn').on('click', function () {
        $('#mainTable1').bootstrapTable('refresh');
    });
    $('#insertSellBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        $('#modal_detailTable').modal("show");
        $('#status').val(1);
    });
    $('#insertSearchBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        var isbn=$('#isbn').val();
        var status=  $('#status').val();
        location.href="${basePath}/bookshare/uploadbook?isbn="+isbn+"&status="+status+"";
        $('#modal_detailTable').modal('hide');
        $('#isbnIn')[0].reset();
    });
    $('#insertNotSearchBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        var status=  $('#status').val();
        var isbn='';
        location.href="${basePath}/bookshare/uploadbook?isbn="+isbn+"&status="+status+"";
        $('#modal_detailTable').modal('hide')
		$('#isbnIn')[0].reset();
    });
    $('#formBorrowSearchBtn').on('click', function () {
        $('#mainTable2').bootstrapTable('refresh');
    });
    $('#formGiftSearchBtn').on('click', function () {
        $('#mainTable3').bootstrapTable('refresh');
    });
    $('#formAuctionSearchBtn').on('click', function () {
        $('#mainTable4').bootstrapTable('refresh');
    });
    $("#mainTable1").bootstrapTable({
        toolbar: "#toolbar_book",
        url: '${basePath}/bookshare/mycatselldetail',
        showColumns: false,
        method:'post',
        dataType: "json",
        sidePagination : "server",
        pagination : true,
        sortOrder:"desc",
        pageList : [5,10,15,25,50,'all'],
        pageNumber:1,
        pageSize :5,
        totalField : "total_records",
        dataField: 'data',
        queryParamsType : "page",
        queryParams: function (params) {
            var newParams = convertSerializeArrayToObject($("#form_bookselluser_q").serializeArray());
            newParams = $.extend(true, {}, params, newParams);
            return newParams;
        },
        columns: [
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,

            },{
                field: 'bookName',
                title: '书名',
                align: "center"
            },{
                field: 'sellName',
                title: '店家',
                align: "center"
            },{
                field: 'sellPhoneNumber',
                title: '电话',
                align: "center"
            },{
                field: 'total',
                title: '数量',
                align: "center"
            }
            ,{
                field: 'price',
                title: '售价',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.price){
                        return  row.price + '元 '
                    }
                    else{
                        return '-';
                    }

                }
            },{
                field: 'oTime',
                title: '下单时间',
                align: "center",
                formatter: function (value, row, index) {
                    if (row.oTime) {
                        return row.oTime;
                    }
                    else {
                        return '-';
                    }
                }
            },{
                field: '查看图书',
                title: '查看图书',
                align: "center",
                formatter :function(value, row, index) {
                    return [ "<a style='cursor:pointer;' class='record-detail'>详细</a>" ].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailSellBook(e, value, row, index);
                    }
                }
            }
        ]
    });

    $("#mainTable2").bootstrapTable({
        toolbar: "#toolbar_book",
        url: '${basePath}/bookshare/mycatborrowdetail',
        showColumns: false,
        method:'post',
        dataType: "json",
        sidePagination : "server",
        pagination : true,
        sortOrder:"desc",
        pageList : [5,10,15,25,50,'all'],
        pageNumber:1,
        pageSize :5,
        totalField : "total_records",
        dataField: 'data',
        queryParamsType : "page",
        queryParams: function (params) {
            var newParams = convertSerializeArrayToObject($("#form_bookborrowuser_q").serializeArray());
            newParams = $.extend(true, {}, params, newParams);
            return newParams;
        },
        columns: [
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,

            },{
                field: 'bookName',
                title: '书名',
                align: "center"
            },{
                field: 'sellName',
                title: '店家',
                align: "center"
            },{
                field: 'sellPhoneNumber',
                title: '电话',
                align: "center"
            },{
                field: 'num',
                title: '借书数量',
                align: "center"
            },{
                field: 'price',
                title: '租金',
                align: "center",
                formatter: function (value, row, index) {
                    if (row.price) {
                        return row.price+"元/天";
                    }
                    else {
                        return '-';
                    }
                }
            },{
                field: 'beyondPrice',
                title: '逾期租金',
                align: "center",
                formatter: function (value, row, index) {
                    if (row.beyondPrice) {
                        return row.beyondPrice+"元/天";
                    }
                    else {
                        return '-';
                    }
                }
            },{
                field: 'depositPricer',
                title: '押金',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.depositPricer){
                        return  row.depositPricer + '元/本';
                    }
                    else{
                        return '-';
                    }

                }
            },
            {
                field: 'totalDeposit',
                title: '总押金',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.totalDeposit){
                        return  row.totalDeposit + '元';
                    }
                    else{
                        return '-';
                    }

                }
            },{
                field: '查看图书',
                title: '查看图书',
                align: "center",
                formatter :function(value, row, index) {
                    return [ "<a style='cursor:pointer;' class='record-detail'>详细</a>" ].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailBorrowBook(e, value, row, index);
                    }
                }

            }
        ]
    });
    $("#mainTable3").bootstrapTable({
        toolbar: "#toolbar_book",
        url: '${basePath}/bookshare/mycatgiftdetail',
        showColumns: false,
        method:'post',
        dataType: "json",
        sidePagination : "server",
        pagination : true,
        sortOrder:"desc",
        pageList : [5,10,15,25,50,'all'],
        pageNumber:1,
        pageSize :5,
        totalField : "total_records",
        dataField: 'data',
        queryParamsType : "page",
        queryParams: function (params) {
            var newParams = convertSerializeArrayToObject($("#form_bookgiftuser_q").serializeArray());
            newParams = $.extend(true, {}, params, newParams);
            return newParams;
        },
        columns: [
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,

            },{
                field: 'bookName',
                title: '书名',
                align: "center"
            },{
                field: 'sellName',
                title: '店家',
                align: "center"
            },{
                field: 'sellPhoneNumber',
                title: '电话',
                align: "center",
                formatter: function (value, row, index) {
                    if (row.sellPhoneNumber) {
                        return row.sellPhoneNumber;
                    }
                    else {
                        return '-';
                    }
                }
            },{
                field: 'total',
                title: '数量',
                align: "center",
                formatter: function (value, row, index) {
                    if (row.total) {
                        return row.total;
                    }
                    else {
                        return '-';
                    }
                }
            },{
                field: 'oTime',
                title: '下单时间',
                align: "center",
                formatter: function (value, row, index) {
                    if (row.oTime) {
                        return row.oTime;
                    }
                    else {
                        return '-';
                    }
                }
            },{
                field: '查看图书',
                title: '查看图书',
                align: "center",
                formatter :function(value, row, index) {
                    return [ "<a style='cursor:pointer;' class='record-detail'>详细</a>" ].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailGiftBook(e, value, row, index);
                    }
                }

            }
        ]
    });
    $("#mainTable4").bootstrapTable({
        toolbar: "#toolbar_book",
        url: '${basePath}/bookshare/mycatauctiondetail',
        showColumns: false,
        method:'post',
        dataType: "json",
        sidePagination : "server",
        pagination : true,
        sortOrder:"desc",
        pageList : [5,10,15,25,50,'all'],
        pageNumber:1,
        pageSize :5,
        totalField : "total_records",
        dataField: 'data',
        queryParamsType : "page",
        queryParams: function (params) {
            var newParams = convertSerializeArrayToObject($("#form_bookauctionuser_q").serializeArray());
            newParams = $.extend(true, {}, params, newParams);
            return newParams;
        },
        columns: [ /*{
            checkbox: true
            },*/
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,

            },{
                field: 'auctionName',
                title: '书名',
                align: "center"
            },{
                field: 'sellerName',
                title: '店家',
                align: "center"
            },{
                field: 'phoneNumber',
                title: '电话',
                align: "center",
                formatter: function (value, row, index) {
                    if (row.phoneNumber) {
                        return row.phoneNumber;
                    }
                    else {
                        return '-';
                    }
                }
            },{
                field: 'price',
                title: '起拍价',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.price){
                        return  row.price + '元 ';
                    }
                    else{
                        return '-';
                    }
                }
            },{
                field: 'sTime',
                title: '起拍时间',
                formatter: formatterToValue

            }, {
                field: 'eTime',
                title: '结束时间',
                formatter: formatterToValue

            },{
                field: 'status',
                title: '书籍状态',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.status){
                        return  switch_status(row.status);
                    }
                    else{
                        return '-';
                    }
                }

            },{
                field: '查看图书',
                title: '查看图书',
                align: "center",
                formatter :function(value, row, index) {
                    return [ "<a style='cursor:pointer;' class='record-detail'>详细</a>" ].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailAuctionBook(e, value, row, index);
                    }
                }

            }
        ]
    });
    function detailSellBook(e, value, row, index) {
        location.replace("${basePath}/bookshare/bookselldetail?id="+row.sellingId+"");
    }
    function detailBorrowBook(e, value, row, index) {

        location.replace("${basePath}/bookshare/bookborrowdetail?id="+row.auctionId+"");
    }
    function detailGiftBook(e, value, row, index) {

        location.replace("${basePath}/bookshare/bookgiftdetail?id="+row.sellingId+"");
    }
    function detailAuctionBook(e, value, row, index) {
        location.replace("${basePath}/bookshare/bookauctiondetail?id="+row.id+"");
    }
    function formatterToValue(value, row, index) {
        if(value && value!=null && value !="1970"){

        }else{
            value="-";
        }
        return value;
    }
    function convertSerializeArrayToObject(array) {
        var obj = {};
        for(var i = 0, length = array.length; i<length; i++){
            obj[array[i]['name']] =array[i]['value'];
        }
        return obj;
    }
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


    (function($) {

        var tabs = $(".tabs li a");
        tabs.click(function() {
            var content = this.hash.replace('/', '');
            tabs.removeClass("active");
            $(this).addClass("active");
            $("#content").find('.tab_div').hide();
            $(content).fadeIn(200);
        });

    })(jQuery);
</script>
</html>
