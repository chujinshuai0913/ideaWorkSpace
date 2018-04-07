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
	<link rel="stylesheet" href="${basePath}/sharebook/css/owl.carousel.min.css" />
	<link rel="stylesheet" href="${basePath}/sharebook/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
	<link rel="stylesheet" href="/ideaWorkSpace/sharebook/css/dl_b.css"/>
	<link rel="stylesheet" type="text/css" href="/ideaWorkSpace/sharebook/css/shufflingStyle.css">
	<script src="/ideaWorkSpace/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="/ideaWorkSpace/sharebook/js/carousel.js"></script>
	<script type="text/javascript" src="/ideaWorkSpace/sharebook/js/zturn.js"></script>
	<script type="text/javascript" src="/ideaWorkSpace/sharebook/js/owl.carousel.min.js"></script>
</head>
<style>

</style>
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
				<img src="/ideaWorkSpace/sharebook/img/燕鸣书屋.png" style="width:250px;height: 100px;padding-top: 10px; cursor:pointer"   alt="燕鸣书屋 " />
			</div>
			<div class="headPagebody_none ">
				<form  action=" " method="get "  id="myform" >
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
						<img src="/ideaWorkSpace/sharebook/img/购物车.png " />
					</div>
					<div class="headPagebody_right_text_two ">
						<a href="/ideaWorkSpace/sharehome/show"><p>我的书箱(<span>222</span>)</p>
                             ${user.username}
						</a>
						<a href="# "><p>我的闲置书(<span>333</span>)</p></a>
					</div>
				</div>
			</div>
		</div>

		<div class="navwrap ">
			<div class="navwrap_text ">
				<div class="navLeft ">
					<a style="color: white; " href="bookClassification.html">全部图书分类</a><span><img src="/ideaWorkSpace/sharebook/img/向下.png " alt="向下 " style="position:relative;top:5px;width: 20px;height: 20px; "/></span>
					<div class="fenlei ">
						<ul>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
							<li>
								<dl class="fenleiLeft ">
									<dt>男人</dt>
									<dd>
										<a href="javascript:; ">男鞋</a>
										<a href="javascript:; ">男裤</a>
										<a href="javascript:; ">手表</a>
										<a href="javascript:; ">男卫衣</a>
										<a href="javascript:; ">nb男鞋</a>
										<a href="javascript:; ">打底衫</a>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
					<div class="fenleiright ">
						<dl class="flright ">
							<dt>上衣</dt>
							<dd>
								<a href="javascript:; ">白衬衫 </a>
								<a href="javascript:; ">潮牌</a>
								<a href="javascript:; ">雪纺衫</a>
								<a href="javascript:; ">班服</a>
								<a href="javascript:; ">宽松上衣</a>
								<a href="javascript:; ">胖人装</a>
								<a href="javascript:; ">棉衬衫</a>
								<a href="javascript:; ">学院风</a>
								<a href="javascript:; "> 中长款装</a>
								<a href="javascript:; ">白衬衫 </a>
							</dd>
						</dl>
						<dl class="flright ">
							<dt>上衣</dt>
							<dd>
								<a href="javascript:; ">白衬衫 </a>
								<a href="javascript:; ">潮牌</a>
								<a href="javascript:; ">雪纺衫</a>
								<a href="javascript:; ">班服</a>
								<a href="javascript:; ">宽松上衣</a>
								<a href="javascript:; ">胖人装</a>
								<a href="javascript:; ">棉衬衫</a>
								<a href="javascript:; ">学院风</a>
								<a href="javascript:; "> 中长款装</a>
								<a href="javascript:; ">白衬衫 </a>
							</dd>
						</dl>
					</div>
				</div>
				<div class="navwrap_text_right ">
					<ul>
						<li><a href="shareindex.jsp">首页</a></li>
						<li><a href="bookClassification.html">按图书分类</a></li>
						<li><a href="# ">按专业分类</a></li>
						<li><a href="# ">书籍</a></li>
						<li><a href="# ">资料共享</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="bodyPage ">
		<div class="bodyPagefirst ">
			<div class="bodyPagefirst_left ">

			</div>
			<div class="bodyPagefirst_none ">
				<div class="bodyPagefirst_none_up ">
					<div class="a-content ">
						<div class="carousel-content ">
							<ul class="carousel ">
								<li><img src="/ideaWorkSpace/sharebook/img/pic1.png "></li>
								<li><img src="/ideaWorkSpace/sharebook/img/pic2.png "></li>
								<li><img src="/ideaWorkSpace/sharebook/img/pic3.png "></li>
								<li><img src="/ideaWorkSpace/sharebook/img/pic4.png "></li>
								<li><img src="/ideaWorkSpace/sharebook/img/pic5.png "></li>
							</ul>
							<ul class="img-index "></ul>
							<div class="carousel-prev "><img src="/ideaWorkSpace/sharebook/img/left1.png "></div>
							<div class="carousel-next "><img src="/ideaWorkSpace/sharebook/img/right1.png "></div>
						</div>
					</div>
				</div>
				<div class="bodyPagefirst_none_down ">
					<div class="bodyPagefirst_none_down_up ">
						<img src="/ideaWorkSpace/sharebook/img/音量.png " />
						<p>图书推荐</p>
					</div>
					<div class="bodyPagefirst_none_down_body ">
						<div class="mhn-slide owl-carousel ">
							<div class="mhn-item ">
								<div class="mhn-inner ">
									<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
									<div class="mhn-text ">
										<h4>啊弥陀佛么么哒</h4>
										<p>大冰</p>
										<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
									</div>
								</div>
							</div>
							<div class="mhn-item ">
								<div class="mhn-inner ">
									<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
									<div class="mhn-text ">
										<h4>啊弥陀佛么么哒</h4>
										<p>大冰</p>
										<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
									</div>
								</div>
							</div>
							<div class="mhn-item ">
								<div class="mhn-inner ">
									<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
									<div class="mhn-text ">
										<h4>啊弥陀佛么么哒</h4>
										<p>大冰</p>
										<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
									</div>
								</div>
							</div>
							<div class="mhn-item ">
								<div class="mhn-inner ">
									<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
									<div class="mhn-text ">
										<h4>啊弥陀佛么么哒</h4>
										<p>大冰</p>
										<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
									</div>
								</div>
							</div>
							<div class="mhn-item ">
								<div class="mhn-inner ">
									<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
									<div class="mhn-text ">
										<h4>啊弥陀佛么么哒</h4>
										<p>大冰</p>
										<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
									</div>
								</div>
							</div>
							<div class="mhn-item ">
								<div class="mhn-inner ">
									<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
									<div class="mhn-text ">
										<h4>啊弥陀佛么么哒</h4>
										<p>大冰</p>
										<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="bodyPagefirst_right ">
				<div class="bodyPagefirst_right_title ">
					<img src="/ideaWorkSpace/sharebook/img/勋章.png " /><p>近期热销榜</p>
				</div>
				<div class="bodyPagefirst_right_content ">
					<a href="# ">
						<div class="bodyPagefirst_right_content_grid ">
							<div class="bodyPagefirst_right_content_left ">
								<img src="/ideaWorkSpace/sharebook/img/1.jpg " alt="11 " />
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
								<img src="/ideaWorkSpace/sharebook/img/3.jpg " alt="11 " />
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
								<img src="/ideaWorkSpace/sharebook/img/4.jpg " alt="11 " />
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
								<img src="/ideaWorkSpace/sharebook/img/5.jpg " alt="11 " />
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
								<img src="/ideaWorkSpace/sharebook/img/1.jpg " alt="11 " />
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
								<img src="/ideaWorkSpace/sharebook/img/3.jpg " alt="11 " />
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
								<img src="/ideaWorkSpace/sharebook/img/5.jpg " alt="11 " />
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
								<img src="/ideaWorkSpace/sharebook/img/1.jpg " alt="11 " />
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
		<div id="1F" class="bodyPagesecond ">
			<div class="bodyPagethreehead ">
				<div class="bodyPagethreehead_text " >
					<img src="/ideaWorkSpace/sharebook/img/分类推荐.png "/>
					<p>图书分类推荐</p>
				</div>
				<div class="bodyPagethreehead_nav ">
					<ul>
						<li class="bodyPagesecond_nav_li1 ">青春文学  </li>
						<li class="bodyPagesecond_nav_li2 ">小说</li>
						<li class="bodyPagesecond_nav_li3 ">人物传记</li>
						<li class="bodyPagesecond_nav_li4 ">历史政治</li>
						<li class="bodyPagesecond_nav_li5 ">外国名著</li>
						<li class="bodyPagesecond_nav_li6 ">人文艺术</li>
					</ul>
				</div>
			</div>
			<div class="bodyPagesecondbody ">
				<div class="bodyPagesecondbody_1">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagesecondbody_2 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagesecondbody_3 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagesecondbody_4 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagesecondbody_5 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagesecondbody_6 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div id="2F" class="bodyPagesecond ">
			<div class="bodyPagethreehead ">
				<div class="bodyPagethreehead_text " >
					<img src="/ideaWorkSpace/sharebook/img/分类推荐.png "/>
					<p>专业分类推荐</p>
				</div>
				<div class="bodyPagethreehead_nav ">
					<ul>
						<li class="bodyPagethree_nav_li1 "> 软件工程</li>
						<li class="bodyPagethree_nav_li2 "> 电气自动化</li>
						<li class="bodyPagethree_nav_li3 "> 通信工程</li>
						<li class="bodyPagethree_nav_li4 "> 马克思</li>
						<li class="bodyPagethree_nav_li5 "> 光电子信息</li>
						<li class="bodyPagethree_nav_li6 "> 土木工程 </li>
					</ul>
				</div>
			</div>
			<div class="bodyPagethreebody ">
				<div class="bodyPagethreebody_1 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagethreebody_2 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagethreebody_3 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagethreebody_4 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagethreebody_5 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
				<div class="bodyPagethreebody_6 ">
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/3.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic1.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic2.png ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/pic3.png">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/2.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/1.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/4.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
					<div class="bodyPagebook">
						<img src="/ideaWorkSpace/sharebook/img/5.jpg ">
						<div class="bodyPagebook_text ">
							<h4>啊弥陀佛么么哒</h4>
							<p><span class="moneyRed ">23.39￥</span> <span class="money ">39.99￥</span></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bodyPagefourbody">
		<h1 class="turn_3d">所在专业推荐图书</h1>
		<div style="position: relative;width: 100%; height: 200px;margin-left: 38px;">
			<div class="pictureSlider">
				<ul id="zturn">
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li><li class="poster-item  zturn-item" >
					<p class="xxgy">狼图腾</p>
					<div class="for_btn">
						<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
					</div>
					<div class="students_star">
						<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
						</p>
						<div class="zwjs">
							简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
						</div>
					</div>
				</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
					<li class="poster-item  zturn-item" >
						<p class="xxgy">狼图腾</p>
						<div class="for_btn">
							<img src="/ideaWorkSpace/sharebook/img/a1.png" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list">作者:<span class="darks">王刚</span>价格:<span class="darks" >23.39￥</span>
							</p>
							<div class="zwjs">
								简介:<span>是向别人展示你自我介绍好不好,甚至直接关系到你给别人的第一印象的好坏及以后自我介绍是向别人展示你自我介绍好不好</span>
							</div>
						</div>
					</li>
				</ul>
			</div></div>
	</div>
</div>
<div class="home_nav ">
	<a href="javascript:window.scrollTo(0,0) ">返回顶部</a>
	<a href="#1F">分类推荐</a>
	<a href="#2F">专业推荐</a>
	<a href="#bottom">到达底部</a>
</div>
<div id="bottom" class="footerPage" style="margin-top: 10px;"></div>
</body>
<script type="text/javascript " src="/ideaWorkSpace/sharebook/js/index.js " ></script>
<script type="text/javascript ">
	alert(${mb});
</script>

</html>