<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
	<meta charset="utf-8" />
	<title>燕鸣书屋</title>
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
	<link rel="stylesheet" href="${basePath}/sharebook/css/searchResult.css" />
	<link rel="stylesheet" href="${basePath}/sharebook/css/bookClassification.css" />
	<script src="${basePath}/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${basePath}/sharebook/js/clamp.js" ></script>
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
						<li>  <a href="${basePath}/sharebook/jsp/bookClassification.jsp">普通分类</a></li>
						<li><a href="${basePath}/sharebook/jsp/bookProification.jsp">按专业分类</a></li>
						<li><a href="# ">书记竞拍</a></li>
						<li><a href="# ">资料共享</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="bodyPage_searchResult">
		<div class="bodyPage_searchResult_head">
			<div class="bodyPage_searchResult_head_up">
				<p>搜索:<span>${requestScope.bookName}  ${requestScope.author} ${requestScope.ISBN} ${requestScope.press}</span>" （共有图书<span>${requestScope.total}</span>种）</p>
			</div>
			<div class="bodyPage_searchResult_head_down">
				<form action="/ideaWorkSpace/bookshare/searchresult"  name="myform" method="post">高级搜索
					书名：<input name="bookName" class="searchResult_input" type="text" value="${requestScope.bookName}" />
					作者：<input name="author" class="searchResult_input"  type="text" value="${requestScope.author}" />
					ISBN：<input name="ISBN" class="searchResult_input" type="text" value="${requestScope.ISBN}" />
					出版社：  <input name="press" class="searchResult_input" type="text" value="${requestScope.press}" />
					类型：<select name="classType" class="searchResult_input" >
						<option value="" <c:if test='${requestScope.classType== ""}'>  selected='selected'  </c:if>>全部</option>
						<option value="1" <c:if test='${requestScope.classType== "1"}'>  selected='selected'  </c:if>>买卖</option>
						<option value="2" <c:if test='${requestScope.classType== "2"}'>  selected='selected'  </c:if>>租借</option>
						<option value="3" <c:if test='${requestScope.classType== "3"}'>  selected='selected'  </c:if>>赠予</option>
					</select>
					<button class="button small" type="submit">搜索</button>
				</form>
			</div>
		</div>
		<div class="bodyPage_searchResult_body">
			<div class="bodyPage_searchResult_body_right">
				<div class="bodyPage_classBook_left_title">
					<img src="${basePath}/sharebook/img/浏览记录.png"/><p>最近浏览图书</p>
				</div>
			</div>
			<div class="bodyPage_searchResult_body_left">
				<c:forEach items="${requestScope.searchResult }" var="s">
					<div class="bodyPage_searchResult_body_text">
						<div class="bodyPage_searchResult_body_text_left " style="margin-top: 15px;">
							<a href='${basePath}/bookshare/bookdetails?id=${s.id}'> <img src="${basePath}/sharebook/img/${s.src}" /></a>
						</div>
						<div class="bodyPage_searchResult_body_text_right " style="height:145px; margin-top: 15px">
							<p class="searchResult_bookname">${s.bookName}</p>
							<p class="searchResult_booktext"> 作者:<span class="author">${s.author}</span> &nbsp;&nbsp;&nbsp;&nbsp; 价格：<span class="moneyRed ">${s.pricing}￥</span> &nbsp;&nbsp;&nbsp;&nbsp;ISBN<span >${s.isbn}</span> &nbsp;&nbsp;&nbsp;&nbsp; 可用库存：<span>${s.userableNum}本</span></p>
							<p class="searchResult_introduction">简介：<span>${s.introduce}</span></p>
							<p class="searchResult_booktext_seller">
								售卖人:<a href="#"><span class="seller">王刚</span></a>/<a href="#"><span class="seller">王刚</span></a>/<a href="#"><span class="seller">王刚</span></a>/<a href="#"><span class="seller">王刚</span></a>
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div style="width: 100%;height: 1px; clear: both;"></div>
	<div id="bottom" class="footerPage "></div>
</div>
</body>
<script>
	$(function () {
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
                                $(".bodyPage_searchResult_body_right").append("<div class='bodyPage_classBook_left_content'><a href='${basePath}/bookshare/bookdetails?id="+item.id+"'>  <div class='bodyPage_classBook_left_content_left'>"+
                                    "<img src='${basePath}/sharebook/img/book/"+item.src+"' alt='11' /></div><div class='bodyPage_classBook_left_content_right'>" +
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

    })

</script>
</html>