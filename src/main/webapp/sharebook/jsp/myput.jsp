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
			</div>
			<c:if test='${sessionScope.userLogin.userName!= null}'>
				<div class="headPagehead_text_two" style="margin-right: 200px;">
					<font color="grey"><a href="${basePath}/login/mybookshare" style="cursor:pointer">${sessionScope.userLogin.userName}</a><input id="userId" type="text" type="text" style="display: none" value="${sessionScope.userLogin.userId}"> 你好，欢迎访问燕鸣书屋 !</font>
					<input id="studentCode" type="text" type="text" style="display: none" value="${sessionScope.userLogin.studentCode}">
				</div>
			</c:if>
			<c:if test='${sessionScope.userLogin.userName== null}'>
				<div class="headPagehead_text_two">
					<a href="${basePath}/sso/sharebook/login.jsp"><span style="color: red; cursor:pointer">请登录</span></a>
					<a href="${basePath}/sso/sharebook/sign.jsp"><span style="cursor:pointer">，免费注册</span></a>
				</div>
			</c:if>
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
						<li><a href="${basePath}/bookshare/auctionresult">书籍竞拍</a></li>
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
										<div class="form-group" style="margin-left: 50px;">
											<label onclick="$(this).next().focus();">书名</label> <input
												name="bookName" type="text" class="form-control" placeholder="书名模糊查询"/>
										</div>
										<div class="form-group" style="margin-left: 50px;">
											<label onclick="$(this).next().focus();">状态</label>
											<select type="text" name="status"  class="form-control" >
												<option value="">全部</option>
												<option value="1">未审核</option>
												<option value="2">已审核</option>
												<option value="3">禁卖</option>
											</select>
										</div>
										<div class="form-group" style="margin-left: 250px;">
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
                                    <div class="form-group" style="margin-left: 50px;">
                                        <label onclick="$(this).next().focus();">书名</label> <input
                                            name="bookName" type="text" class="form-control" placeholder="书名模糊查询"/>
                                    </div>
                                    <div class="form-group" style="margin-left: 50px;">
                                        <label onclick="$(this).next().focus();">状态</label>
                                        <select type="text" name="status"  class="form-control" >
                                            <option value="">全部</option>
                                            <option value="1">未审核</option>
                                            <option value="2">已审核</option>
                                            <option value="3">禁卖</option>
                                        </select>
                                    </div>
                                    <div class="form-group" style="margin-left: 250px;">
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
                                    <div class="form-group" style="margin-left: 50px;">
                                        <label onclick="$(this).next().focus();">书名</label> <input
                                            name="bookName" type="text" class="form-control" placeholder="书名模糊查询"/>
                                    </div>
                                    <div class="form-group" style="margin-left: 50px;">
                                        <label onclick="$(this).next().focus();">状态</label>
                                        <select type="text" name="status"  class="form-control" >
                                            <option value="">全部</option>
                                            <option value="1">未审核</option>
                                            <option value="2">已审核</option>
                                            <option value="3">禁卖</option>
                                        </select>
                                    </div>
									<div class="form-group" style="margin-left: 250px;">
										<label></label>
                                        <button type="button" id="formGiftSearchBtn" class="btn btn-primary"  data-style="zoom-in"
                                                style="width: 100px;height: 33px;"	formaction="javascript:void(0);">查询
                                        </button>&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" id="insertGiftSearchBtn" class="btn btn-primary"  data-style="zoom-in"
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
                                    <div class="form-group" style="margin-left: 50px;">
                                        <label onclick="$(this).next().focus();">书名</label> <input
                                            name="auctionName" type="text" class="form-control" placeholder="书名模糊查询"/>
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
									<div class="form-group" style="margin-left: 250px;">
										<label></label>
                                        <button type="button" id="formAuctionSearchBtn" class="btn btn-primary"  data-style="zoom-in"
                                                style="width: 100px;height: 33px;"	formaction="javascript:void(0);">查询
                                        </button>&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="button"  id="insertAuctionSearchBtn" class="btn btn-primary"  data-style="zoom-in"
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
				<div id="modal_detailTable1" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
					<div class="modal-dialog" dialog-width="900px" style="width:900px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
								<h4 class="modal-title" id="modalTitle1">买书人</h4>
								<form id="form_sell_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<div class="form-group" style="margin-left: 50px;">
										<label onclick="$(this).next().focus();">姓名</label>
										<input  name="buyerName" type="text" class="form-control" placeholder="姓名查询"/>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button" id="formSellSearchBtn1" class="btn btn-primary" data-style="zoom-in"
												formaction="javascript:void(0);">查询
										</button>&nbsp;&nbsp;
										<button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
									</div>
								</form>
							</div>
							<div class="modal-body">
								<table id="detailTable1"></table>
							</div>

						</div>
					</div>
				</div>
				<div id="modal_detailTable2" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
					<div class="modal-dialog" dialog-width="900px" style="width:900px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
								<h4 class="modal-title" id="modalTitle2">借书人</h4>
								<form id="form_borrow_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<div class="form-group" style="margin-left: 50px;">
										<input id="auctionId" name="auctionId" style="display: none">
										<label onclick="$(this).next().focus();">姓名</label>
										<input  name="userName" type="text" class="form-control" placeholder="姓名查询"/>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button" id="formSellSearchBtn2" class="btn btn-primary" data-style="zoom-in"
												formaction="javascript:void(0);">查询
										</button>&nbsp;&nbsp;
										<button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
									</div>
								</form>
							</div>
							<div class="modal-body">
								<table id="detailTable2"></table>
							</div>
						</div>
					</div>
					<div id="modal_detailTableB" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
						<div class="modal-dialog" dialog-width="400px" style="width:400px">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
									<h4 class="modal-title" id="modalTitleB">归还图书</h4>
									<form id="form_blackborrow_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
										  onkeydown="if(event.keyCode==13){return false;}">
										<div class="form-group" style="margin-left: 50px;margin-top: 30px;">
											<input  id="recordBookBorrow" style="display: none" />
											<label onclick="$(this).next().focus();">归还数量</label>
											<input  id="returnNum" name="returnNum" type="text" class="form-control" placeholder="归还数量"/>
										</div>
										<div class="form-group" style="margin-left: 50px;margin-top: 30px;">
											<label></label>
											<button type="button" id="blackBookBorrow" class="btn btn-primary" data-style="zoom-in"
													formaction="javascript:void(0);">归还图书
											</button>&nbsp;&nbsp;
											<button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="modal_detailTable3" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
					<div class="modal-dialog" dialog-width="900px" style="width:900px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
								<h4 class="modal-title" id="modalTitle3">受赠人</h4>
								<form id="form_gift_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<div class="form-group" style="margin-left: 50px;">
										<label onclick="$(this).next().focus();">姓名</label>
										<input  name="buyerName" type="text" class="form-control" placeholder="姓名查询"/>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button" id="formSellSearchBtn3" class="btn btn-primary" data-style="zoom-in"
												formaction="javascript:void(0);">查询
										</button>&nbsp;&nbsp;
										<button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
									</div>
								</form>
							</div>
							<div class="modal-body">
								<table id="detailTable3"></table>
							</div>

						</div>
					</div>

				</div>
				<div id="modal_detailTable4" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
					<div class="modal-dialog" dialog-width="900px" style="width:900px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
								<h4 class="modal-title" id="modalTitle4">出价人</h4>
								<form id="form_auction_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<div class="form-group" style="margin-left: 50px;">
										<label onclick="$(this).next().focus();">姓名</label>
										<input  name="buyerName" type="text" class="form-control" placeholder="姓名查询"/>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button" id="formSellSearchBtn4" class="btn btn-primary" data-style="zoom-in"
												formaction="javascript:void(0);">查询
										</button>&nbsp;&nbsp;
										<button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
									</div>
								</form>
							</div>
							<div class="modal-body">
								<table id="detailTable4"></table>
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
    $('#formBorrowSearchBtn').on('click', function () {
        $('#mainTable2').bootstrapTable('refresh');
    });
    $('#formGiftSearchBtn').on('click', function () {
        $('#mainTable3').bootstrapTable('refresh');
    });
    $('#formAuctionSearchBtn').on('click', function () {
        $('#mainTable4').bootstrapTable('refresh');
    });
    $('#insertSellBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        if($("#studentCode").val()==""){
            alert("您还未认证不可以上传书籍!");
            return;
        }else{
            $('#modal_detailTable').modal("show");
            $('#status').val(1);
        }
    });
    $('#insertBorrowSearchBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        if($("#studentCode").val()==""){
            alert("您还未认证不可以上传书籍!");
            return;
        }else{
            $('#modal_detailTable').modal("show");
            $('#status').val(2);
		}
    });
    $('#insertGiftSearchBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        if($("#studentCode").val()==""){
            alert("您还未认证不可以上传书籍!");
            return;
        }else{
            $('#modal_detailTable').modal("show");
            $('#status').val(3);
        }
    });
    $('#insertAuctionSearchBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        if($("#studentCode").val()==""){
            alert("您还未认证不可以上传书籍!");
            return;
        }else{
            $('#modal_detailTable').modal("show");
            $('#status').val(4);
        }
    });
    $('#insertSearchBtn').on('click', function () {
        /*判断用户是否认正未认证不可上传并转发到认证页面*/
        var isbn=$('#isbn').val();
        var status=$('#status').val();
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
        url: '${basePath}/bookshare/bookselling',
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
            },
            {
                field: 'bookName',
                title: '书名',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'price',
                title: '售价',
                align: "center",
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
                field: 'num',
                title: '库存量',
                align: "center",
                formatter :function(value, row, index) {
                    if(!row.useableNum){
                        return  row.preNum;
                    }
                    if(!row.preNum) {
                        return row.useableNum;
                    }else if(row.preNum&&row.useableNum){
                        return row.preNum+row.useableNum;
                    }else {
                        return 0;
                    }
                }

            },{
                field: 'useNum',
                title: '出货量',
                align: "center",
                formatter :function(value, row, index) {
                    if(value>0){
                        return [ "<a style='cursor:pointer;color: blue;'  class='record-detail'>",''+value+'','</a>' ].join('');
                    }else{
                        return value;
                    }
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog1(e, value, row, index);
                    }
                }

            },{
                field: 'num',
                title: '销售额',
                align: "center",
                formatter :function(value, row, index) {
                    return row.useNum*row.price+'  元';
                }

            },{
                field: 'uTime',
                title: '上传时间',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'statusStr',
                title: '状态',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'status',
                title: '状态',
                align: "center",
                visible:false,
                formatter: formatterToValue

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
        url: '${basePath}/bookshare/bookborrow',
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

            },
            {
                field: 'bookName',
                title: '书名',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'price',
                title: '租金',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.price){
                        return  row.price +  ' 元/天';
                    }
                    else{
                        return '-';
                    }

                }
            },
            {
                field: 'depositPrice',
                title: '押金',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.depositPrice){
                        return  row.depositPrice +  ' 元/本';
                    }
                    else{
                        return '-';
                    }

                }
            },
            {
                field: 'beyondPrice',
                title: '逾期租金',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.beyondPrice){
                        return  row.beyondPrice + ' 元/天 ';
                    }
                    else{
                        return '-';
                    }

                }
            },
            {
                field: 'num',
                title: '库存量',
                align: "center",
                formatter :function(value, row, index) {
                    if(!row.useableNum){
                        return  row.preNum;
                    }
                    if(!row.preNum) {
                        return row.useableNum;
                    }else if(row.preNum&&row.useableNum){
                        return row.preNum+row.useableNum;
                    }else {
                        return 0;
                    }
                }

            },{
                field: 'useNum',
                title: '出借量',
                align: "center",
                formatter :function(value, row, index) {
                    if(value>0){
                        return [ "<a style='cursor:pointer;color: blue;' class='record-detail'>",''+value+'','</a>' ].join('');
                    }else{
                        return value;
                    }
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog2(e, value, row, index);
                    }
                }

            },{
                field: 'uTime',
                title: '上传时间',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'statusStr',
                title: '状态',
                align: "center",
                formatter: formatterToValue
            },
            {
                field: 'status',
                title: '状态',
                align: "center",
                visible:false,
                formatter: formatterToValue

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
        url: '${basePath}/bookshare/bookgift',
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

            },
            {
                field: 'bookName',
                title: '书名',
                align: "center",
                formatter: formatterToValue

            },{
                field: 'num',
                title: '库存量',
                align: "center",
                formatter :function(value, row, index) {
                    if(!row.useableNum){
                        return  row.preNum;
                    }
                    if(!row.preNum) {
                        return row.useableNum;
                    }else if(row.preNum&&row.useableNum){
                        return row.preNum+row.useableNum;
                    }else {
                        return 0;
                    }
                }

            },{
                field: 'useNum',
                title: '赠出量',
                align: "center",
                formatter :function(value, row, index) {
                    if(value>0){
                        return [ "<a style='cursor:pointer;color: blue;' class='record-detail'>",''+value+'','</a>' ].join('');
                    }else{
                        return value;
                    }
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog3(e, value, row, index);
                    }
                }

            },{
                field: 'uTime',
                title: '上传时间',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'statusStr',
                title: '状态',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'flagStr',
                title: '是否回收',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'status',
                title: '状态',
                align: "center",
                visible:false,
                formatter: formatterToValue

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
        url: '${basePath}/bookshare/bookauction',
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
        columns: [
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,

            },
            {
                field: 'auctionName',
                title: '书名',
                align: "center",
                formatter: formatterToValue

            },{
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
            },
            {
                field: 'status',
                title: '状态',
                align: "center",
                formatter :function(value, row, index) {
                    if(value==4||value==5||value==6){
                        return [ "<a style='cursor:pointer;color: blue' class='record-detail'>",''+switch_status(value)+'','</a>' ].join('');
                    }else{
                        return switch_status(value);
                    }
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailTableDialog4(e, value, row, index);
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
        location.replace("${basePath}/bookshare/bookselldetail?id="+row.id+"");
    }
    function detailBorrowBook(e, value, row, index) {

        location.replace("${basePath}/bookshare/bookborrowdetail?id="+row.id+"");
    }
    function detailBorrowBookBlack(e, value, row, index) {
        $("#modal_detailTableB").modal("show");
        $("#recordBookBorrow").val(row.id);
	}
   $("#blackBookBorrow").on('click',function () {
        $.ajax({
            type : "post",
            async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "${basePath}/bookshare/updatebookborrowblack",    //请求发送到TestServlet处
            data: JSON.stringify($.extend(true, {}, {id:$("#recordBookBorrow").val(),auctionId:$("#auctionId").val(),returnNum:$("#returnNum").val()})),
            contentType:"text/html;charset=utf-8",
            dataType: "json",   //返回格式为json
            success : function(data) {
                try {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data.resultMassage == 'ok'){
                        alert("归还成功！");
                        $("#modal_detailTableB").modal("hide");
                         var auctionId= $("#auctionId").val();
                        $('#detailTable2').bootstrapTable('refresh',{
                            url: '/ideaWorkSpace/bookshare/recordborrow',
                            query:{
                                auctionId:auctionId
                            }
                        });
                        $('#mainTable2').bootstrapTable('refresh');
                    }else {
                        alert(data.resultMassage);
                    }
                } catch (e){
                    console.log(e.message);
                }

            },
            complete: function() {
            },
            error: function(error) {
                console.log(error);
            }})
    })
    function detailGiftBook(e, value, row, index) {

        location.replace("${basePath}/bookshare/bookgiftdetail?id="+row.id+"");
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
                var idParam={auctionId:auctionId};
                var userParams=convertSerializeArrayToObject($("#form_auction_q").serializeArray());
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
    function detailTableDialog4(e, value, row, index){
        $('#modal_detailTable4').modal("show");
        auctionId=row.id;
        $('#detailTable4').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordauction',
            query:{
                auctionId:auctionId
            }
        });
    }

    $('#formSellSearchBtn4').on('click', function () {
        $('#detailTable').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordauction',
            query:{
                auctionId:auctionId
            }
        });
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
                var idParam={sellingId:sellingId};
                var userParams=convertSerializeArrayToObject($("#form_gift_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'buyerName',
                    title : '受赠人',
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
                    field : 'total',
                    title : '受赠数量',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'oTime',
                    title : '受赠时间',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'statusStr',
                    title : '交易状态',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'cTime',
                    title : '交易时间',
                    formatter: formatterToValue
                }]
        });
    //弹出层
    var sellingId=0;
    function detailTableDialog3(e, value, row, index){
        $('#modal_detailTable3').modal("show");
        sellingId=row.id;
        $('#detailTable3').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordgift',
            query:{
                sellingId:sellingId
            }
        });

    }

    $('#formSellSearchBtn3').on('click', function () {
        $('#detailTable3').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordgift',
            query:{
                sellingId:sellingId
            }
        });
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
                var idParam={auctionId:auctionId};
                var userParams=convertSerializeArrayToObject($("#form_borrow_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'userName',
                    title : '借书人',
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
                    title : '借书数量',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'returnNum',
                    title : '还书数量',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'sTime',
                    title : '借书时间',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'eTime',
                    title : '最晚还书时间',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'rTime',
                    title : '实际还书时间',
                    formatter: formatterToValue
                },{
                    align: "center",
                    field : 'totalDeposit',
                    title : '总押金',
                    formatter: function (value, row, index) {
                        if(row.totalDeposit){
                            return  row.totalDeposit + '  /元' ;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'returnDeposit',
                    title : '所退押金',
                    formatter: function (value, row, index) {
                        if(row.returnDeposit){
                            return  row.returnDeposit + '  /元' ;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'totalPrice',
                    title : '总费用',
                    formatter: function (value, row, index) {
                        if(row.totalPrice){
                            return  row.totalPrice + '  /元' ;
                        }
                        else{
                            return '-';
                        }

                    }
                },{
                    field: '操作',
                    title: '操作',
                    align: "center",
                    formatter :function(value, row, index) {
                        if(row.totalPrice>0){
                           return "-";
                        }else{
                            return [ "<a style='cursor:pointer;' class='black-detail'>归还图书</a>" ].join('');
						}
                    },
                    events: {
                        'click .black-detail': function (e, value, row, index) {
                            detailBorrowBookBlack(e, value, row, index);
                        }
                    }

                }]
        });
    //弹出层
    var auctionId=0;
    function detailTableDialog2(e, value, row, index){
        $('#modal_detailTable2').modal("show");
        $("#auctionId").val(row.id);
        auctionId=row.id;
        $('#detailTable2').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordborrow',
            query:{
                auctionId:auctionId
            }
        });
    }

    $('#formSellSearchBtn2').on('click', function () {
        $('#detailTable2').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordborrow',
            query:{
                auctionId:auctionId
            }
        });
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
                var idParam={sellingId:sellingId};
                var userParams=convertSerializeArrayToObject($("#form_sell_q").serializeArray());
                var oldParams = $.extend(true,{},params,idParam);
                var newParams = $.extend(true,{},oldParams,userParams);
                return newParams;
            },
            columns : [
                {
                    align: "center",
                    field : 'buyerName',
                    title : '买书人',
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
                    field : 'total',
                    title : '买书数量',
                    formatter: formatterToValue
                },
                {
                    align: "center",
                    field : 'numPrice',
                    title : '总价',
                    formatter: function (value, row, index) {
                        if(row.totalPrice){
                            return  row.totalPrice + '  /元' ;
                        }
                        else{
                            return '-';
                        }

                    }
                },
                {
                    align: "center",
                    field : 'oTime',
                    title : '下单时间',
                    formatter:formatterToValue
                },
                {
                    align: "center",
                    field : 'statusStr',
                    title : '交易状态',
                    formatter: formatterToValue
                }]
        });
    //弹出层
    var sellingId=0;
    function detailTableDialog1(e, value, row, index){
        $('#modal_detailTable1').modal("show");
        sellingId=row.id;
        $('#detailTable1').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordselling',
            query:{
                sellingId:sellingId
            }
        });
    }

    $('#formSellSearchBtn1').on('click', function () {
        $('#detailTable1').bootstrapTable('refresh',{
            url: '/ideaWorkSpace/bookshare/recordselling',
            query:{
                sellingId:sellingId
            }
        });
    });

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
