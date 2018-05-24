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
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-3.3.5/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/css/bootstrap-table.css" />

	<link rel="stylesheet" href="${basePath}/sharebook/css/bookdetails.css" />
</head>
<body>
<div class="homePage">
	<div class="headPage">
		<div class="headPagehead">
			<div class="headPagehead_text_one">
				<font color="grey">你好，欢迎访问燕鸣书屋 !</font>
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
				<img src="${basePath}/sharebook/img/燕鸣书屋.png" style="width:250px;height: 100px;padding-top: 10px; cursor:pointer" "  alt="燕鸣书屋 " />
			</div>
			<div class="headPagebody_none ">
				<form action="/ideaWorkSpace/bookshare/searchresult1"  name="myform" method="post" >
					<div class="headPagebody_none_search " >
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
						<a href="# "><p>我的书箱(<span>222</span>)</p></a>
						<a href="# "><p>我的闲置书(<span>333</span>)</p></a>
					</div>
				</div>
			</div>
		</div>

		<div class="navwrap ">
			<div class="navwrap_text ">
				<div class="navLeft ">
					<a style="color: white; " href="bookClassification.html">全部图书分类</a><span><img src="${basePath}/sharebook/img/向下.png " alt="向下 " style="position:relative;top:5px;width: 20px;height: 20px; "/></span>
				</div>
				<div class="navwrap_text_right ">
					<ul>
						<li><a href="${basePath}/sharebook/jsp/shareindex.jsp">首页</a></li>
						<li><a href="${basePath}/sharebook/jsp/bookClassification.jsp">普通分类</a></li>
						<li><a href="${basePath}/sharebook/jsp/bookProification.jsp ">按专业分类</a></li>
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
				<div class="bodyPage_body_bookdetail_up_up">
					<p>您所在位置：<span>分类</span>><span>${requestScope.bookVo.bookTypeName1}</span>><span>${requestScope.bookVo.bookTypeName2}</span></p>
				</div>
				<div class="bodyPage_body_bookdetail_up_left">
					<div class="bodyPage_body_bookdetail_up_left_img">
						<img src="${basePath}/sharebook/img/a5.png" />
					</div>
					<div class="bodyPage_body_bookdetail_up_left_text">
						<p class="bodyPage_body_bookdetail_up_left_text_title">${requestScope.bookVo.bookName}</p>
						<p class="bodyPage_body_bookdetail_up_left_text_detail">
							<span class="span_1">作者:<a href="#"><span>${requestScope.bookVo.author}</span></a> </span>
							<span class="span_1">出版社：<a href='"${basePath}/bookshare/searchresult?press="+${requestScope.bookVo.press}'><span>${requestScope.bookVo.press}</span></a> </span>
							<span class="span_1">ISBN:<span>${requestScope.bookVo.isbn}</span></span><br />
							<span class="span_1"> 出版日期：<span>${requestScope.bookVo.pTime} </span></span>
							<span class="span_1"> 定价：<span>${requestScope.bookVo.pricing}￥</span></span><br />
						</p>
						<div class="bodyPage_body_bookdetail_up_left_text_ziying">
							<hr style="width:90%;height:1px;border:none;border-top:1px dashed grey;" />

							<h4 style="margin-bottom: 20px;margin-top: 10px;">
								<c:if test='${requestScope.bookVo.selfStatus==1}'>  自营:${requestScope.bookVo.bookSellingVo.sellerName} </c:if>
								<c:if test='${requestScope.bookVo.selfStatus==0}'> 推荐商家: ${requestScope.bookVo.bookSellingVo.sellerName}</c:if>
							</h4>
							<span class="span_2"> 价格：<span style="color: red;">${requestScope.bookVo.bookSellingVo.price}￥</span> </span>
							<span class="span_2">
						    	  	可用库存：<span style="color: green; margin-right: 20px;"> ${requestScope.bookVo.bookSellingVo.useableNum}</span>
						    	  	购买数量:
						    	  	<button class="btn jian">-</button>
			                           <input class="input_buy" disabled="disabled" type="text" value="1" />
			                       	<button class="btn jia"> +</button><br />
						    	  <button style="cursor:pointer;margin-top:40px;margin-left:80px;color:white;font-size:16px;width: 150px; height: 40px; background-color: red; border: 1px gainsboro solid; border-radius: 5px; text-align: center;">加入书箱</button></span>
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
						<div id="sharebookuserList" class="panel panel-default" style="padding-right: 0px;">
							<div>
								<form id="form_bookuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
									  onkeydown="if(event.keyCode==13){return false;}">
									<div class="form-group" style="margin-left: 50px;">
										<label onclick="$(this).next().focus();">交易方式</label>
										<select  name="pageNum" type="text" class="form-control" >
											<option value="1">买卖</option>
											<option value="2">租借</option>
											<option value="3">赠予</option>
											<option value="4">竞拍</option>
										</select>
									</div>
									<div class="form-group" style="margin-left: 30px;">
										<label></label>
										<button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
												formaction="javascript:void(0);">查询
										</button>
									</div>
								</form>
							</div>
							<div id="panel-body" style="width: 98%;margin: auto;">
								<table  id="mainTable"></table>
							</div>
						</div>
					</div>
					<div class="bodyPage_body_bookdetail_down_right_book">
						内容提要
						文章节选
						目录
						编辑推荐语
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="bottom" class="footerPage"></div>
	<input id="bookTypeName2" style="display: none" value="${requestScope.bookVo.bookTypeName2}"/>
	<input id="professionalTypeName2" style="display: none" value="${requestScope.bookVo.professionalTypeName2}"/>
</div>
</body>
<script>
    $(".jian").click(function(){
        var lsoek=$(this).parent().find(".input_buy");
        var lskoe=parseInt(lsoek.val());
        var a=lskoe-1;
        if(a<=0){
            a=lskoe
        }
        lsoek.val(a);
    })
    $(".jia").click(function(iiii){
        var lsoek=$(this).parent().find(".input_buy");
        var lskoe=parseInt(lsoek.val());
        lsoek.val(lskoe+1);
    })
    $(".lskdo").on('input propertychange',function(){
        var deox=$(this).val();
        if(isNaN(deox)){
            alert("您好,请输入数量!");
            $(this).val(1);
        }
    })
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
                                "<p>作者：<span>"+item.author+"</span></p><p>价格：<span class='moneyRed'>"+item.pricing+"￥</span><span>共"+item.userableNum+" 本</span></p></div></div></a>");
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
            url : "/ideaWorkSpace/bookshare/probooktop",    //请求发送到TestServlet处
            data: JSON.stringify($.extend(true, {},{professionalTypeName2:$("#professionalTypeName2").val(),preNum:10})),
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
                                    "<p>作者：<span>"+item.author+"</span></p><p>价格：<span class='moneyRed'>"+item.pricing+"￥</span><span>共"+item.userableNum+" 本</span></p></div></div></a>");
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
    $('#formSearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_book",
        url: '${basePath}/bookshare/bookuserdetails',
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
                field: 'selfStatus',
                title: 'selfStatus',
                align: "center",
                visible:false,

            },{
                field: 'sellerName',
                title: '售卖人',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.selfStatus==3){
                        return  row.sellerName + '（自营）';
                    }
                    else{
                        return  row.sellerName;
                    }

                }
            },
            {
                field: 'phoneNumber',
                title: '联系方式',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'useNum',
                title: '销量',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'useableNum',
                title: '可用库存',
                align: "center",
            },{
                field: 'price',
                title: '售价',
                align: "center",
                formatter: function (value, row, index) {
                    if(row.price){
                        return  row.price + ' ' +switchState(row.state);
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
                        return [ "<a  class='record-detail'>详细</a>" ].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        detailBook(e, value, row, index);
                    }
                }

            }
        ]
    });
     function detailBook(e, value, row, index) {
         if(row.state=1){
             windows.location.href="${basePath}/bookshare/bookselldetail?id="+row.id;
		 }
         if(row.state=2){
             windows.location.href="${basePath}/bookshare/bookborrowdetail?id="+row.id;
         }
         if(row.state=3){
             windows.location.href="${basePath}/bookshare/bookgiftdetail?id="+row.id;
         }
         if(row.state=4){
             windows.location.href="${basePath}/bookshare/bookauctiondetail?id="+row.id;
         }
     }
    function switchState(n) {
        switch(n)
        {
            case 1:
                元
                break;
            case 2:
                元/天
                break;
            case 3:
                break;
            case 4:
                元
                break;
        }
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
</script>
</html>
