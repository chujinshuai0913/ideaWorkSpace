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
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
	<link rel="stylesheet" href="${basePath}/sharebook/css/bookdetails.css" />
	<script src="${basePath}/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>
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
					<p>您所在位置：<span>全部分类</span>><span>文学小说</span>><span>青春文学</span></p>
				</div>
				<div class="bodyPage_body_bookdetail_up_left">
					<div class="bodyPage_body_bookdetail_up_left_img">
						<img src="${basePath}/sharebook/img/a5.png" />
					</div>
					<div class="bodyPage_body_bookdetail_up_left_text">
						<p class="bodyPage_body_bookdetail_up_left_text_title">狼图腾</p>
						<p class="bodyPage_body_bookdetail_up_left_text_detail">
							<span class="span_1">作者:<a href="#"><span>王刚</span></a> </span>
							<span class="span_1">出版社：<a href="#"><span>北京人民出版北京人民出版北京人民出版北京人民出版北京人民出版北京人民出版</span></a> </span>
							<span class="span_1">ISBN:<span>12233378</span></span><br />
							<span class="span_1"> 出版日期：<span>2014年12月24日 </span></span>
							<span class="span_1"> 定价：<span>23.39￥</span><br />
						</p>
						<div class="bodyPage_body_bookdetail_up_left_text_ziying">
							<hr style="width:90%;height:1px;border:none;border-top:1px dashed grey;" />
							<h4 style="margin-bottom: 20px;margin-top: 10px;">售卖人: </h4>
							<span class="span_2"> 价格：<span style="color: red;">12.39￥</span> </span>
							<span class="span_2">
						    	  	库存：<span style="color: green; margin-right: 20px;"> 26</span>
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
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<div class="bodyPage_body_bookdetail_down">
				<div class="bodyPage_body_bookdetail_down_left">
					<div class="bodyPagefirst_right_title ">
						<img src="${basePath}/sharebook/img/勋章.png " /><p>专业相关</p>
					</div>
					<div class="bodyPagefirst_right_content " style="padding-bottom: 20px;">
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
						<a href="# ">
							<div class="bodyPagefirst_right_content_grid ">
								<div class="bodyPagefirst_right_content_left ">
									<img src="${basePath}/sharebook/img/1.jpg " alt="11 " />
								</div>
								<div class="bodyPagefirst_right_content_right ">
									<p>狼图腾</p>
									<p>作者：<span>王刚</span></p>
									<p>价格：<span class="moneyRed ">23.39￥</span></p>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="bodyPage_body_bookdetail_down_right">
					<div class="bodyPage_body_bookdetail_down_right_seller">
						<div class="bodyPage_body_bookdetail_down_right_seller">
							评价
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
</body>
<script type="text/javascript " src="${basePath}/sharebook/js/index.js " ></script>
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
</script>
</html>
