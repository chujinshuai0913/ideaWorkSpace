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
		<link rel="stylesheet" type="text/css" href="../css/index.css">
		<script src="../js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="js/jquery.slideBox.js" type="text/javascript"></script>
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
						<img src="../img/燕鸣书屋.png" style="width:250px;height: 100px;padding-top: 10px; cursor:pointer" "  alt="燕鸣书屋 " />
					</div>
					<div class="headPagebody_none ">
						<form  action=" " method="get "  id="myform ">
							<div class="headPagebody_none_search " >
								<input class="headPagebody_none_search_text " name="searchName " placeholder=" 书名、作者、出版社、ISBN "/>
								<select class="headPagebody_none_search_icon " name="searchSelect " onchange="submitForm() " >
									<option >借书</option>
									<option >买书</option>
									<option >送书</option>
								</select>
							</div>
						</form>
					</div>
					<div class="headPagebody_right ">
						<div class="headPagebody_right_text ">
							<div class="headPagebody_right_text_one ">
								<img src="../img/购物车.png " />
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
						   <a style="color: white; " href="bookClassification.html">全部图书分类</a><span><img src="../img/向下.png " alt="向下 " style="position:relative;top:5px;width: 20px;height: 20px; "/></span>
					     </div> 	
						<div class="navwrap_text_right ">
							<ul>
								<li><a href="shareindex.jsp">首页</a></li>
								<li><a href="bookClassification.html">普通分类</a></li>
								<li><a href="# ">按专业分类</a></li>
								<li><a href="# ">书记竞拍</a></li>
								<li><a href="# ">资料共享</a></li>
								</ul>					
						</div>
					</div>
				</div>
		</div>
		<div class="bodyPage">
			
		</div>
		<div id="bottom" class="footerPage "></div>
	</body>
	<script type="text/javascript " src="../js/index.js " ></script>
</html>