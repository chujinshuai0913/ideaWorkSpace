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
	<link rel="stylesheet" href="${basePath}/sharebook/css/dl_b.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/shufflingStyle.css">
	<script src="${basePath}/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${basePath}/sharebook/js/carousel.js"></script>
	<script type="text/javascript" src="${basePath}/sharebook/js/zturn.js"></script>
	<script type="text/javascript" src="${basePath}/sharebook/js/owl.carousel.min.js"></script>
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
						<img src="/ideaWorkSpace/sharebook/img/购物车.png " />
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
					<a style="color: white; margin-left: 110px" href="${basePath}/sharebook/jsp/bookClassification.jsp">全部图书分类</a><span><img src="/ideaWorkSpace/sharebook/img/向下.png " alt="向下 " style="position:relative;top:5px;width: 20px;height: 20px; "/></span>
					<div class="fenlei ">
						<ul id="index1F">
						</ul>
					</div>
					<div class="fenleiright ">
						<dl class="flright ">
							<dt></dt>
							<dd>
							</dd>
						</dl>
					</div>
				</div>
				<div class="navwrap_text_right ">
					<ul>
						<li><a href="${basePath}/sharebook/jsp/shareindex.jsp">首页</a></li>
						<li><a href="${basePath}/sharebook/jsp/bookClassification.jsp">按图书分类</a></li>
						<li><a href="${basePath}/sharebook/jsp/bookProification.jsp">按专业分类</a></li>
						<li><a href="# ">书籍竞拍</a></li>
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
							</ul>
							<ul class="img-index "></ul>
							<div class="carousel-prev "><img src="${basePath}/sharebook/img/left1.png "></div>
							<div class="carousel-next "><img src="${basePath}/sharebook/img/right1.png "></div>
						</div>
					</div>
				</div>
				<div class="bodyPagefirst_none_down ">
					<div class="bodyPagefirst_none_down_up ">
						<img src="${basePath}/sharebook/img/音量.png " />
						<p>图书推荐</p>
					</div>
					<div class="bodyPagefirst_none_down_body ">
						<div id="booktop" class="mhn-slide owl-carousel ">

						</div>
					</div>
				</div>
			</div>
			<div class="bodyPagefirst_right ">
				<div class="bodyPagefirst_right_title ">
					<img src="${basePath}/sharebook/img/勋章.png " /><p>近期热销榜</p>
				</div>
				<div class="bodyPagefirst_right_content ">

				</div>
			</div>
		</div>
		<div id="1F" class="bodyPagesecond ">
			<div class="bodyPagethreehead ">
				<div class="bodyPagethreehead_text " >
					<img src="${basePath}/sharebook/img/分类推荐.png "/>
					<p>图书分类推荐</p>
				</div>
				<div class="bodyPagethreehead_nav ">
					<ul id="FA">
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
				</div>
				<div class="bodyPagesecondbody_2 ">
				</div>
				<div class="bodyPagesecondbody_3 ">
				</div>
				<div class="bodyPagesecondbody_4 ">
				</div>
				<div class="bodyPagesecondbody_5 ">
				</div>
				<div class="bodyPagesecondbody_6 ">
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
					<ul id="FB">
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
				</div>
				<div class="bodyPagethreebody_2 ">
				</div>
				<div class="bodyPagethreebody_3 ">
				</div>
				<div class="bodyPagethreebody_6 ">
				</div>
			</div>
		</div>
	</div>
	<div class="bodyPagefourbody">
		<h1 class="turn_3d">所在专业推荐图书</h1>
		<div style="position: relative;width: 100%; height: 200px;margin-left: 38px;">
			<div class="pictureSlider">
				<ul id="zturn">
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
<script type="text/javascript ">
    $(function () {


        //轮播图
        // imgCycleOnload();
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/ideaWorkSpace/bookshare/imgcycle",    //请求发送到TestServlet处
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
                                $(".bodyPagefirst_none_up").find(".carousel").append("<li><img src='${basePath}/sharebook/img/shareactivity/"+item.src+"'></li>");
                            })
                            imgCycle();
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
            }
        })

        //近期热销榜
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/ideaWorkSpace/bookshare/bookhot",    //请求发送到TestServlet处
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
                                $(".bodyPagefirst_right_content").append("<a href='${basePath}/bookshare/bookdetails?id="+item.id+"'> " +
                                    "<div class='bodyPagefirst_right_content_grid '><div class='bodyPagefirst_right_content_left'>" +
                                    " <img src='${basePath}/sharebook/img/book/"+item.src+"' alt='11' /></div><div class='bodyPagefirst_right_content_right'>" +
                                    "<p>"+item.bookName+"</p><p>作者：<span>"+item.author+"</span></p><p>价格：<span class='moneyRed'>"+item.pricing+"￥</span></p> </div></div></a>");
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

        //图书推荐榜
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/ideaWorkSpace/bookshare/booktop",    //请求发送到TestServlet处
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
                                $("#booktop").append("<div class='mhn-item'> <div class='mhn-inner' ><a href='${basePath}/bookshare/bookdetails?id="+item.id+"'> <img style='margin-left: 10px;' src='${basePath}/sharebook/img/"+item.src+"'></a><div class='mhn-text'>" +
                                    " <h4>"+item.bookName+"</h4><p>"+item.author+"</p><p><span class='moneyRed'>"+item.pricing+"￥</span> &nbsp;&nbsp;&nbsp;&nbsp;<span>共"+item.userableNum+" 本</span></p></div></div></div>");
                            })
                            bookTopA();
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

        //所在专业书籍推荐
        var professionalTypeName2="";
        var list=[];
        /*获取当前用户的专业*/
        proBookTopUser(professionalTypeName2);
        function proBookTopUser(professionalTypeName2) {
            proBookTopUserA(professionalTypeName2);
            var aa=new zturn({
                id:"zturn",
                opacity:0.9,
                width:300,
                Awidth:900,
                scale:0.9
            })
        }
        function proBookTopUserA(professionalTypeName2){
            $.ajax({
                type : "post",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/ideaWorkSpace/bookshare/probooktop",    //请求发送到TestServlet处
                data: JSON.stringify($.extend(true, {},{professionalTypeName2:professionalTypeName2,preNum:0})),
                contentType:"text/html;charset=utf-8",
                dataType: "json",   //返回格式为json
                success : function(data) {
                    try {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (data.error_code == 0){
                            list = JSON.parse(JSON.stringify(data.data));
                            if(list.length>0){
                                list.forEach(function (item) {
                                    $("#zturn").append("<li class='poster-item  zturn-item'> <p class='xxgy'>"+item.bookName+"</p><div class='for_btn'>" +
                                        "<a href='${basePath}/bookshare/bookdetails?id="+item.id+"'><img src='${basePath}/sharebook/img/"+item.src+"'width='100%'></a></div><div class='students_star'>" +
                                        " <p class='cell_list'>作者:<span class='darks'>"+item.author+"</span>价格:<span class='darks' >"+item.pricing+"￥</span></p><div class='zwjs'>" +
                                        " 简介:<span>"+item.introduce+"</span></div></div></li>");
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
        }
        //分专业推荐图书
        $("#FB").find('li').mouseover(function() {
            num= $(this).index()+1;
            proBookTopA($(this).text(),num);
        });
        function proBookTopA(professionalTypeName2,num){
            $.ajax({
                type : "post",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/ideaWorkSpace/bookshare/probooktop",    //请求发送到TestServlet处
                data: JSON.stringify($.extend(true, {},{professionalTypeName2:professionalTypeName2,preNum:0})),
                contentType:"text/html;charset=utf-8",
                dataType: "json",   //返回格式为json
                success : function(data) {
                    try {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (data.error_code == 0){
                            list = JSON.parse(JSON.stringify(data.data));
                            if(list.length>0){
                                $(".bodyPagethreebody_"+num+"").find(".bodyPagebook").remove();
                                list.forEach(function (item) {
                                    $(".bodyPagethreebody_"+num+"")
                                    $(".bodyPagethreebody_"+num+"").append("<div class='bodyPagebook'><a href='${basePath}/bookshare/bookdetails?id="+item.id+"'><img src='${basePath}/sharebook/img/"+item.src+"'></a> <div class='bodyPagebook_text'>" +
                                        "<h4>"+item.bookName+"</h4><p><span class='moneyRed'>"+item.pricing+"￥</span> &nbsp;&nbsp;&nbsp;&nbsp;<span>共"+item.userableNum+" 本</span></p></div></div>");
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
        }
       //分类推荐图书
        $("#FA").find('li').mouseover(function() {
            num= $(this).index()+1;
            proBookTopB($(this).text(),num);
        });
        function proBookTopB(bookTypeName2,num){
            $.ajax({
                type : "post",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/ideaWorkSpace/bookshare/probooktop",    //请求发送到TestServlet处
                data: JSON.stringify($.extend(true, {},{bookTypeName2:bookTypeName2,preNum:0})),
                contentType:"text/html;charset=utf-8",
                dataType: "json",   //返回格式为json
                success : function(data) {
                    try {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (data.error_code == 0){
                            list = JSON.parse(JSON.stringify(data.data));
                            if(list.length>0){
                                $(".bodyPagesecondbody_"+num+"").find(".bodyPagebook").remove();
                                list.forEach(function (item) {
                                    $(".bodyPagesecondbody_"+num+"").append("<div class='bodyPagebook'><a href='${basePath}/bookshare/bookdetails?id="+item.id+"'><img src='${basePath}/sharebook/img/"+item.src+"'></a><div class='bodyPagebook_text'>" +
                                        "<h4>"+item.bookName+"</h4><p><span class='moneyRed'>"+item.pricing+"￥</span>&nbsp;&nbsp;&nbsp;&nbsp; <span>共"+item.userableNum+" 本</span></p></div></div>");
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
        }

       //首页图书分类
        $.ajax({
            type : "post",
            async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/ideaWorkSpace/bookshare/bookclassinformation",    //请求发送到TestServlet处
            data: {id:1},
            contentType:"text/html;charset=utf-8",
            dataType: "json",   //返回格式为json
            success : function(data) {
                try {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data.error_code == 0){
                        list = JSON.parse(JSON.stringify(data.data));
                        if(list.length>0){

                            $("#index1F").find("li").remove();
                            list.forEach(function (item) {
                                $("#index1F").append("<li><dl class='fenleiLeft'><dt>"+item.className1+"</dt> <dt class='dt_value' style='display: none'>"+item.id+"</dt></dl></li>");
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
        //首页图书二类
        $("#index1F").find('li').mouseover(function() {
            Class2BookTopAjax($(this).find('.fenleiLeft').find('.dt_value').text());
        });
        function Class2BookTopAjax(classId1){
            $.ajax({
                type : "post",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/ideaWorkSpace/bookshare/bookclass2information",    //请求发送到TestServlet处
                data: JSON.stringify($.extend(true, {},{classId1:classId1})),
                contentType:"text/html;charset=utf-8",
                dataType: "json",   //返回格式为json
                success : function(data) {
                    try {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (data.error_code == 0){
                            list = JSON.parse(JSON.stringify(data.data));
                            if(list.length>0){
                                $(".flright").find("a").remove();
                                list.forEach(function (item) {
                                    $(".flright").find("dd").append("<a href='javascript:;'>"+item.className2+"<span class='class2_value' style='display: none'>"+item.id+"</span></a>");
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
        }


        function imgCycle() {
            $(".carousel-content ").carousel({
                carousel : ".carousel ",//轮播图容器
                indexContainer : ".img-index ",//下标容器
                prev : ".carousel-prev ",//左按钮
                next : ".carousel-next ",//右按钮
                timing : 3000,//自动播放间隔
                animateTime : 700,//动画时间
                autoPlay : true,//是否自动播放 true/false
                direction : "left ",//滚动方向 right/left
            });

            $(".carousel-content ").hover(function(){
                $(".carousel-prev,.carousel-next ").fadeIn(300);
            },function(){
                $(".carousel-prev,.carousel-next ").fadeOut(300);
            });

            $(".carousel-prev ").hover(function(){
                $(this).find("img ").attr("src ","./img/left2.png ");
            },function(){
                $(this).find("img ").attr("src ","./img/left1.png ");
            });
            $(".carousel-next ").hover(function(){
                $(this).find("img ").attr("src ","./img/right2.png ");
            },function(){
                $(this).find("img ").attr("src ","./img/right1.png ");
            });
        }

        $('.fenlei ul li').mouseenter(function() {
            $(this).siblings().css('background', '#F5F5F5');
            $('.fenleiright').fadeTo(0, 0.8).stop().animate({
                'width': '700px'
            }, 300);
        }).mouseleave(function() {
            $(this).siblings().css('background', '#ffffff');
        });
        $('.navLeft').mouseleave(function() {

            $('.fenleiright').stop().animate({
                'width': '0px'
            }, 300);

        })
        function bookTopA() {
            $('.mhn-slide').owlCarousel({
                nav:true,
                //loop:true,
                slideBy:'page',
                rewind:false,
                responsive:{
                    0:{items:1},
                    480:{items:2},
                    600:{items:3},
                    1000:{items:4}
                },
                smartSpeed:70,
                onInitialized:function(e){
                    $(e.target).find('img').each(function(){
                        if(this.complete){
                            $(this).closest('.mhn-inner').find('.loader-circle').hide();
                            $(this).closest('.mhn-inner').find('.mhn-img').css('background-image','url('+$(e.target).attr('src')+')');
                        }else{
                            $(this).bind('load',function(e){
                                $(e.target).closest('.mhn-inner').find('.loader-circle').hide();
                                $(e.target).closest('.mhn-inner').find('.mhn-img').css('background-image','url('+$(e.target).attr('src')+')');
                            });
                        }
                    });
                },
                navText:['<svg viewBox="0 0 24 24 "><path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z "></path></svg>','<svg viewBox="0 0 24 24 "><path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z "></path></svg>']
            });
        }


        function submitForm(){
            var form = document.getElementById("myform ");
            form.submit();
        }


        $(".bodyPagesecond_nav_li1").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagesecondbody_1").css("display","block");
                $(".bodyPagesecondbody_1").siblings().css("display","none");
            });
        $(".bodyPagesecond_nav_li2").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagesecondbody_2").css("display","block");
                $(".bodyPagesecondbody_2").siblings().css("display","none");
            });
        $(".bodyPagesecond_nav_li3").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagesecondbody_3").css("display","block");
                $(".bodyPagesecondbody_3").siblings().css("display","none");
            });
        $(".bodyPagesecond_nav_li4").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagesecondbody_4").css("display","block");
                $(".bodyPagesecondbody_4").siblings().css("display","none");
            });
        $(".bodyPagesecond_nav_li5").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagesecondbody_5").css("display","block");
                $(".bodyPagesecondbody_5").siblings().css("display","none");
            });
        $(".bodyPagesecond_nav_li6").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagesecondbody_6").css("display","block");
                $(".bodyPagesecondbody_6").siblings().css("display","none");
            });
        $(".bodyPagethree_nav_li1").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagethreebody_1").css("display","block");
                $(".bodyPagethreebody_1").siblings().css("display","none");
            });
        $(".bodyPagethree_nav_li2").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagethreebody_2").css("display","block");
                $(".bodyPagethreebody_2").siblings().css("display","none");
            });
        $(".bodyPagethree_nav_li3").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagethreebody_3").css("display","block");
                $(".bodyPagethreebody_3").siblings().css("display","none");
            });
        $(".bodyPagethree_nav_li4").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagethreebody_4").css("display","block");
                $(".bodyPagethreebody_4").siblings().css("display","none");
            });
        $(".bodyPagethree_nav_li5").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagethreebody_5").css("display","block");
                $(".bodyPagethreebody_5").siblings().css("display","none");
            });
        $(".bodyPagethree_nav_li6").hover(
            function(){
                $(this).css("color","red");
                $(this).siblings().css("color","black");
                $(".bodyPagethreebody_6").css("display","block");
                $(".bodyPagethreebody_6").siblings().css("display","none");
            });

    })



</script>


</html>