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
	<link rel="stylesheet" href="${basePath}/sharebook/css/bookdetails.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
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
					<p><span>
					<c:if test='${requestScope.bookSellingVo.selfStatus==1}'>  自营:${requestScope.bookSellingVo.sellerName} </c:if>
					<c:if test='${requestScope.bookSellingVo.selfStatus==0}'> 商家: ${requestScope.bookSellingVo.sellerName}</c:if>
					</span>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;感谢您的到来！</p>
				</div>
				<div class="bodyPage_body_bookdetail_up_left">
					<div class="bodyPage_body_bookdetail_up_left_img">
						<div style="cursor:pointer;width: 100%;height: 80%">
								<img class="imgBookBig" style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookSellingVo.src1}" alt="">
						</div>
						<div style="width: 100%;height: 20%;">
							<div style="border-top: 1px gainsboro solid;cursor:pointer;width: 25%;height: 100%;float: left">
								<img class="imgBook"  style="" src="${basePath}/sharebook/img/${requestScope.bookSellingVo.src1}" alt="">
							</div>
							<div style="border-top: 1px gainsboro solid;border-left: 1px gainsboro solid;cursor:pointer;width: 25%;height: 100%;float: left">
								<img class="imgBook"  style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookSellingVo.src2}" alt="">
							</div>
							<div  style="border-top: 1px gainsboro solid;border-left: 1px gainsboro solid;cursor:pointer;width: 25%;height: 100%;float: left">
								<img class="imgBook"  style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookSellingVo.src3}" alt="">
							</div>
							<div  style="border-top: 1px gainsboro solid;border-left: 1px gainsboro solid;cursor:pointer;width: 24%;height: 100%;float: left">
								<img class="imgBook"  style="width: 100%;height: 100%;" src="${basePath}/sharebook/img/${requestScope.bookSellingVo.src4}" alt="">
							</div>
						</div>
					</div>
					<div class="bodyPage_body_bookdetail_up_left_text">
						<p class="bodyPage_body_bookdetail_up_left_text_title">${requestScope.bookSellingVo.bookName}</p>
						<p class="bodyPage_body_bookdetail_up_left_text_detail">
							<input id="bookId" type="text" type="text" style="display: none" value="${requestScope.bookSellingVo.id}">
							<span class="span_1">售卖人:<a href="#"><span>${requestScope.bookSellingVo.sellerName}</span></a> </span>
							<%--<span class="span_1">联系电话:<span>${requestScope.bookSellingVo.phoneNumber}</span> </span>--%>
							<span class="span_1"> 上传时间：<span>${requestScope.bookSellingVo.uTime} </span></span>
                            <input type="text" id="priceN" style="display: none" value="${requestScope.bookSellingVo.price}">
							<span class="span_1"> 售价：<span  style="color: red">${requestScope.bookSellingVo.price}</span>￥</span><br />
						</p>
						<div class="bodyPage_body_bookdetail_up_left_text_ziying">
							介绍:<span class="span_2 zwjs" style="margin-left: 0px;height: 100px;width: 80%">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.bookSellingVo.remark}
						       </span>
							<span class="span_2" style="margin-left: 0px">
                                  <input type="text" id="useableNum" style="display: none" value="${requestScope.bookSellingVo.useableNum}">
                                 <input type="text" id="skuId" style="display: none" value="${requestScope.bookSellingVo.skuId}">
						    	  	可用库存：<span style="color: green; margin-right: 20px;"> ${requestScope.bookSellingVo.useableNum}</span>
						            购买数量:
						    	  	<button class="btn jian">-</button>
			                           <input class="input_buy" disabled="disabled" type="text" value="1"/>
			                       	<button class="btn jia"> +</button><br />
						    	  <button  id="insertMyBook" style="cursor:pointer;margin-top:40px;margin-left:100px;color:white;font-size:16px;width: 150px; height: 40px; background-color: red; border: 1px gainsboro solid; border-radius: 5px; text-align: center;">加入书箱</button></span>
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
				<div class="bodyPage_body_bookdetail_down_right">
					<div class="bodyPage_body_bookdetail_down_right_seller">
					</div>
					<div class="bodyPage_body_bookdetail_down_right_book">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="bottom" class="footerPage"></div>
</div>
</body>
<script>
	$(function () {
        $("#insertMyBook").on('click',function () {
            var useableNum=$("#useableNum").val();
            if(useableNum<=0){
              alert("当前无库存！");
            }else {
                insertBookCat($("#bookId").val(),$(".input_buy").val(),$("#userId").val(),1,$("#priceN").val(),$("#skuId").val());
            }
        })
		//加入书箱
		function insertBookCat(bookId,num,userId,status,price,bookFatherId) {
            $.ajax({
                type : "post",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/ideaWorkSpace/bookshare/insertBookCat",    //请求发送到TestServlet处
                data: JSON.stringify($.extend(true, {},{bookId:bookId,num:num,userId:userId,status:status,price:price,bookFatherId:bookFatherId})),
                contentType:"text/html;charset=utf-8",
                dataType: "json",   //返回格式为json
                success : function(data) {
                    try {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (data.error_code == 0){
                                 alert("加入成功，前往书箱查看联系方式！")
                                 location.reload();
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
        }
        $(".imgBook").click(function () {
            $(".imgBookBig").attr('src',$(this)[0].src);
        });
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
        var useableNum=$("#useableNum").val();
        if(lskoe>=useableNum){
            alert("超过当前库存量！")
		}else{
            lsoek.val(lskoe+1);
		}
    })
    $(".lskdo").on('input propertychange',function(){
        var deox=$(this).val();
        if(isNaN(deox)){
            alert("您好,请输入数量!");
            $(this).val(1);
        }
    })
    //所在专业相关推荐
    $.ajax({
        type : "post",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/ideaWorkSpace/bookshare/bookuserselftop",    //请求发送到TestServlet处
        data: JSON.stringify($.extend(true, {},{bookTypeName2:""})),
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
    })
</script>
</html>
