<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>燕鸣书屋</title>
		<link rel="stylesheet" href="${basePath}/sharebook/css/bookClassification.css" />
		<link rel="stylesheet" href="${basePath}/sharebook/css/owl.carousel.min.css" />
		<link rel="stylesheet" href="${basePath}/sharebook/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
		<link rel="stylesheet" href="${basePath}/sharebook/css/dl_b.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/shufflingStyle.css">
		<script src="${basePath}/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${basePath}/sharebook/js/carousel.js"></script>
		<script type="text/javascript" src="${basePath}/sharebook/js/zturn.js"></script>
		<script type="text/javascript" src="${basePath}/sharebook/js/owl.carousel.min.js"></script>

	</head>
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
		<div class="bodyPage_classBook">
			<div class="bodyPage_classBook_left">
				<div class="bodyPage_classBook_left_title">
					<img src="${basePath}/sharebook/img/浏览记录.png"/><p>最近浏览图书</p>
				</div>
			</div>
			<div class="bodyPage_classBook_right">
				<div class="bodyPage_classBook_right_title">
					<p>专业分类</p>
				</div>
				<div class="bodyPage_classBook_right_content">

				</div>
			</div>
		</div>
		<div style="width: 100%;height: 1px; clear: both;"></div>
			<div id="bottom" class="footerPage" style="margin-top: 10px;padding-top: 20px;">
				<div style="width: 40%;margin: auto;height: 40px; font-size: 20px; text-align: center; color: #fff;   opacity: 0.8;  line-height: 20px;filter:alpha(opacity=80);">
					Copyright © 2018-2020  燕鸣书屋 ysu.sharebook.com 版权所有
				</div>
			</div>
		</div>
	</body>
<script>
	//分类
    $.ajax({
        type : "post",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/ideaWorkSpace/bookshare/bookpro12information",    //请求发送到TestServlet处
        data: {id:1},
        contentType:"text/html;charset=utf-8",
        dataType: "json",   //返回格式为json
        success : function(data) {
            try {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (data.error_code == 0){
                    list = JSON.parse(JSON.stringify(data.data));
                    if(list.length>0){

                        list.forEach(function (item) {
                            var class2="";
                            item.list.forEach(function (item1) { class2=class2 +"<a href='${basePath}/bookshare/proResult?professionalTypeName2="+item1.className2+"'><span>"+item1.className2+"</span><span> |</span> </a>";})
                            $(".bodyPage_classBook_right_content").append("<div class='bodyPage_classBook_right_content_text'><dl class='bodyPage_classBook_right_content_text_d'>"+
                               "<dt><span>"+item.className1+"</span> <span> |</span></dt><dd>"+class2+"</dd></dl></div>");
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

    //浏览历史
    $.ajax({
        type : "post",
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/ideaWorkSpace/bookshare/searchistory",    //请求发送到TestServlet处
        data: {id:1},
        contentType:"text/html;charset=utf-8",
        dataType: "json",   //返回格式为json
        success : function(data) {
            try {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (data.error_code == 0){
                    list = JSON.parse(JSON.stringify(data.data));
                    if(list.length>0){
                        list.forEach(function (item) {
                            $(".bodyPage_classBook_left").append("<div class='bodyPage_classBook_left_content'><a href='${basePath}/bookshare/bookdetails?id="+item.id+"'>  <div class='bodyPage_classBook_left_content_left'>"+
                                "<img src='${basePath}/sharebook/img/"+item.src+"' alt='11' /></div><div class='bodyPagefirst_right_content_right'>" +
                            "<p>"+item.bookName+"</p><p>作者：<span>"+item.author+"</span></p><p>价格：<span class='moneyRed'>"+item.pricing+"￥</span></p> </div></a></div>");
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


</script>
</html>