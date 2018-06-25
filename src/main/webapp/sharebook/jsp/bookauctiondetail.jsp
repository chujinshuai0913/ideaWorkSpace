<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
	<title>图书详情</title>
	<meta charset="utf-8" />
	<title>燕鸣书屋</title>
	<script src="${basePath}/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-datepicker-1.5.0/js/bootstrap-datepicker.js" ></script>
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/css/bootstrap-table.css" />
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-3.3.5/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${basePath}/sharebook/css/bookdetails.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/dl_b.css">
</head>
<style>
.input{
	display: inline;
	width: 100px;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}
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
						<input class="headPagebody_none_search_text " name="bookName1" type="text"  placeholder="书名" value="${requestScope.bookName1}"/>
						<button class="headPagebody_none_search_icon"  type="submit">搜索</button>
						<select name="classType1" name="searchSelect " class="headPagebody_none_search_select">
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
				<div class="bodyPage_body_bookdetail_up_up">
					<p><span>
					<c:if test='${requestScope.bookAuctionVo.selfStatus==1}'>  自营:${requestScope.bookAuctionVo.sellerName} </c:if>
					<c:if test='${requestScope.bookAuctionVo.selfStatus==0}'> 商家: ${requestScope.bookAuctionVo.sellerName}</c:if>
					</span>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;感谢您的到来！</p>
				</div>
				<div class="bodyPage_body_bookdetail_up_left">
					<div class="bodyPage_body_bookdetail_up_left_img">
						<div style="cursor:pointer;width: 100%;height: 80%">
							<img class="imgBookBig" style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookAuctionVo.src1}" alt="">
						</div>
						<div style="width: 100%;height: 20%;">
							<div style="border-top: 1px gainsboro solid;cursor:pointer;width: 25%;height: 100%;float: left">
								<img class="imgBook"  style="" src="${basePath}/sharebook/img/${requestScope.bookAuctionVo.src1}" alt="">
							</div>
							<div style="border-top: 1px gainsboro solid;border-left: 1px gainsboro solid;cursor:pointer;width: 25%;height: 100%;float: left">
								<img class="imgBook"  style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookAuctionVo.src2}" alt="">
							</div>
							<div  style="border-top: 1px gainsboro solid;border-left: 1px gainsboro solid;cursor:pointer;width: 25%;height: 100%;float: left">
								<img class="imgBook"  style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookAuctionVo.src3}" alt="">
							</div>
							<div  style="border-top: 1px gainsboro solid;border-left: 1px gainsboro solid;cursor:pointer;width: 24%;height: 100%;float: left">
								<img class="imgBook"  style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookAuctionVo.src4}" alt="">
							</div>
						</div>
					</div>
					<div class="bodyPage_body_bookdetail_up_left_text">
						<p class="bodyPage_body_bookdetail_up_left_text_title">${requestScope.bookAuctionVo.auctionName}</p>
						<p class="bodyPage_body_bookdetail_up_left_text_detail">
							<input id="bookId" type="text" type="text" style="display: none" value="${requestScope.bookAuctionVo.id}">
							<span class="span_1">出拍人:<a href="#"><span>${requestScope.bookAuctionVo.sellerName}</span></a> </span>
							<span class="span_1"> 开始时间： <span>${requestScope.bookAuctionVo.sTime} </span></span>
							<span class="span_1"> 结束时间：<span>${requestScope.bookAuctionVo.eTime} </span></span>
							<input type="text" id="priceN" style="display: none" value="${requestScope.bookAuctionVo.price}">
							<span class="span_1"> 起拍价：<span  style="color: red">${requestScope.bookAuctionVo.price}</span>￥</span><br />
						</p>
						<div class="bodyPage_body_bookdetail_up_left_text_ziying">
							介绍:<span class="span_2 zwjs" style="margin-left: 0px;height: 100px;width: 80%">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.bookAuctionVo.remark}
						       </span>
							<span class="span_2" style="margin-left: 0px">
                                  <input type="text" id="skuId" style="display: none" value="${requestScope.bookAuctionVo.bookId}">
                                  	<c:if test='${requestScope.bookAuctionVo.status==2}'>
										<h2>竞拍未开始，${requestScope.bookAuctionVo.sTime} 敬请期待！！</h2>
										<%--<h1>
											  <button  id="insertMyBook" style="cursor:pointer;margin-top:40px;margin-left:100px;color:white;font-size:16px;width: 150px; height: 40px; background-color: red; border: 1px gainsboro solid; border-radius: 5px; text-align: center;">报名参加</button>
										</h1>--%>
									</c:if>
								    <c:if test='${requestScope.bookAuctionVo.status==4}'>
										<h2 style="margin-left: 30px;display: inline;">竞拍中！</h2>
										<button type="button" id="refersh" class="btn btn-primary" data-style="zoom-in" style="width: 60px;display: inline;border:white;margin-left: 30px;line-height: 20px;background-color: orange"
												formaction="javascript:void(0);">刷新
													</button>
										<div style="width: 98%;height: 100px;margin: auto;">
											<div style="width: 50%;float: left">
												  <table  class="table" style="width: 300px;margin-top: 10px;">
													<tr style="background-color: #2764ff;color: white;">
														<th style="text-align: center;"><span>当前价</span></th>
														<th style="text-align: center;"><span>我的出价</span></th>
														<th style="text-align: center;"><span>我的状态</span></th>
													</tr>
													<tr >
														<td style="text-align: center;">
															<span >${maxPrice} </span>元
														</td>
														<td style="text-align: center;">
															<span >${myPrice} </span>元
														</td>
														<td style="text-align: center;">
															<span style="color: orange">
																<c:if test='${maxPrice==myPrice}'>领先</c:if>
																<c:if test='${maxPrice>myPrice}'>落后</c:if>
															</span>
														</td>
													</tr>
												  </table>
											</div>
											<div style="width: 50%;float: left">
												<form id="form_auction_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
														 onkeydown="if(event.keyCode==13){return false;}">
                                              <div class="form-group" style="margin-top: 20px;">
												  	<input name="userId" type="text" type="text" style="display: none" value="${requestScope.bookAuctionVo.sellerId}">
													<input type="text" name="price" style="text-align: center"  class="input"  placeholder="元">
												  <input type="text" name="auctionId" style="display: none;" value="${requestScope.bookAuctionVo.id}" >
												  	<button type="button" id="auctionprice" class="btn btn-primary" data-style="zoom-in" style="background-color:red;border:white;width: 60px;display: inline;margin-left: 10px;line-height: 20px;"
															formaction="javascript:void(0);">出价
													</button>
											  </div>
												   </form>
											</div>
										</div>
									</c:if>
								   <c:if test='${requestScope.bookAuctionVo.status==5}'>
									   <h2>竞拍已经结束啦，敬请下次吧！！</h2>
								   </c:if>
								 <c:if test='${requestScope.bookAuctionVo.status==6}'>
									 <h2>竞拍已经结束啦，敬请下次吧！！</h2>
								 </c:if>
						    	</span>
						</div>
					</div>
				</div>
				<div class="bodyPage_body_bookdetail_up_right">
					<div class="bodyPagefirst_right_title ">
						<img src="${basePath}/sharebook/img/勋章.png " /><p>猜你喜欢</p>
					</div>
					<div class="bodyPagefirst_right_content ">
					</div>
				</div>
			</div>
			<div class="bodyPage_body_bookdetail_down">
				<div class="bodyPage_body_bookdetail_down_left">
					<div class="bodyPagefirst_right_title ">
						<img src="${basePath}/sharebook/img/勋章.png " /><p>专业相关</p>
					</div>
					<div class="bodyPagefirst_right_content " style="padding-bottom: 20px;">
					</div>
				</div>
				<div class="bodyPage_body_bookdetail_down_right">
					<div class="bodyPage_body_bookdetail_down_right_seller">
						<div class="panel panel-default" style="padding-right: 0px;">
							<div>
								<form id="form_bookuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<input type="text" name="auctionId" style="display: none" value="${requestScope.bookAuctionVo.id}"/>
									<div class="form-group" style="margin-left: 10px;">
										<label onclick="$(this).next().focus();" style="font-size: 20px; ">竞价记录</label>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button" id="formSearchBtn" class="btn btn-primary"  data-style="zoom-in"
												style="width: 100px;height: 33px;margin-left: 600px"	formaction="javascript:void(0);">刷新
										</button>
									</div>
								</form>
							</div>
							<div id="panel-body" style="width: 98%;margin: auto;">
								<table  id="mainTable"></table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="bottom" class="footerPage" style="margin-top: 10px;padding-top: 20px;">
		<div style="width: 40%;margin: auto;height: 40px; font-size: 20px; text-align: center; color: #fff;   opacity: 0.8;  line-height: 20px;filter:alpha(opacity=80);">
			Copyright © 2018-2020  燕鸣书屋 ysu.sharebook.com 版权所有
		</div>
	</div>
	<input id="bookTypeName2" style="display: none" value="${requestScope.bookAuctionVo.bookTypeName2}"/>
	<input id="professionalTypeName2" style="display: none" value="${requestScope.bookAuctionVo.professionalTypeName2}"/>
</div>
</body>
<script>
    $(function () {

		$("#refersh").on('click',function () {
            window.location.reload();
        })

        $(".imgBook").click(function () {
            $(".imgBookBig").attr('src',$(this)[0].src);
        });
        //详情书籍分类相关推荐
        $.ajax({
            type : "post",
            async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/ideaWorkSpace/bookshare/probooktop",    //请求发送到TestServlet处
            data: JSON.stringify($.extend(true, {},{bookTypeName2:$("#bookTypeName2").val(),preNum:4})),
            contentType:"text/html;charset=utf-8",
            dataType: "json",   //返回格式为json
            success : function(data) {
                try {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data.error_code == 0){
                        list = JSON.parse(JSON.stringify(data.data));
                        if(list.length>0){
                            list.forEach(function (item) {
                                $(".bodyPage_body_bookdetail_up_right").find(".bodyPagefirst_right_content").append("<a href='${basePath}/bookshare/bookdetails?id="+item.id+"'> <div class='bodyPagefirst_right_content_grid'><div class='bodyPagefirst_right_content_left'>"+
                                    "<img src='${basePath}/sharebook/img/"+item.src+"' /></div><div class='bodyPagefirst_right_content_right'><p>"+item.bookName+"</p>"+
                                    "<p>作者：<span>"+item.author+"</span></p><p>价格：<span class='moneyRed'>"+item.pricing+"￥</span></p></div></div></a>");
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
            }})
        //详情书籍专业相关推荐
        $.ajax({
            type : "post",
            async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/ideaWorkSpace/bookshare/bookuserselftop",    //请求发送到TestServlet处
            data: JSON.stringify($.extend(true, {},{professionalTypeName2:$("#professionalTypeName2").val()})),
            contentType:"text/html;charset=utf-8",
            dataType: "json",   //返回格式为json
            success : function(data) {
                try {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data.error_code == 0){
                        list = JSON.parse(JSON.stringify(data.data));
                        if(list.length>0){
                            list.forEach(function (item) {
                                $(".bodyPage_body_bookdetail_down_left").find(".bodyPagefirst_right_content").append("<a href='${basePath}/bookshare/bookdetails?id="+item.id+"'> <div class='bodyPagefirst_right_content_grid'><div class='bodyPagefirst_right_content_left'>"+
                                    "<img src='${basePath}/sharebook/img/"+item.src+"' /></div><div class='bodyPagefirst_right_content_right'><p>"+item.bookName+"</p>"+
                                    "<p>作者：<span>"+item.author+"</span></p><p>价格：<span class='moneyRed'>"+item.pricing+"￥</span></p></div></div></a>");
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
            }})

		//竞价出价
        $("#auctionprice").on('click',function () {
            $.ajax({
                type : "post",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/ideaWorkSpace/bookshare/auctionPrice",    //请求发送到TestServlet处
                data: JSON.stringify($.extend(true, {},convertSerializeArrayToObject($("#form_auction_q").serializeArray()))),
                contentType:"text/html;charset=utf-8",
                dataType: "json",   //返回格式为json
                success : function(data) {
                    try {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
						alert(data.resultMassage);
                        window.location.reload();
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

		//竞价记录

        $('#formSearchBtn').on('click', function () {
            $('#mainTable').bootstrapTable('refresh');
        });
        var $table = $("#mainTable");
        $table.bootstrapTable({
            toolbar: "#toolbar_book",
            url: '${basePath}/bookshare/recordauction',
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
                var newParams = convertSerializeArrayToObject($("#form_bookuser_q").serializeArray());
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
                    field: 'userName',
                    title: '出价人',
                    align: "center",
                },
                {
                    field: 'aTime',
                    title: '出价时间',
                    align: "center",
                },{
                    field: 'price',
                    title: '出价',
                    align: "center",
                    formatter: function (value, row, index) {
                        if(row.price){
                            return  row.price + '元 ' ;
                        }else{
                            return '-';
                        }

                    }
                }
            ]
        });
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
    })
</script>
</html>
