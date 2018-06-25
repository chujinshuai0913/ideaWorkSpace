<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>注册</title>
		<script src="${basePath}/sso/js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${basePath}/sso/css/login.css">
	</head>
	<body>
		<header>
			<a href="${basePath}/sharebook/jsp/shareindex.jsp" class="logo"><img style="height: 50px;width: 160px" src="${basePath}/sso/img/燕鸣书屋.png" ></a>
			<div class="desc">欢迎注册</div>
			<div class="desc1">已有账号？<a href="${basePath}/sso/sharebook/login.jsp" style="color: red;">欢迎登入</a></div>
		</header>
		<section>
			<form id="form_login_q">
				<div class="register-box">
					<label  class="other_label">昵 称
			<input maxlength="20" type="text" name="userName" placeholder="昵 称">
					</label>
					<div class="tips">

					</div>
				</div>
				<div class="register-box">
					<label  class="other_label">设 置 密 码
			<input maxlength="20" type="password" name="password" placeholder="建议至少使用两种字符组合">
			</label>
					<div class="tips">

					</div>
				</div>
				<div class="register-box">
					<label  class="other_label">确 认 密 码
			<input maxlength="20" type="password" placeholder="请再次输入密码">
			</label>
					<div class="tips">

					</div>
				</div>
				<div class="register-box">
					<label  class="username_label">
			<span>中国 0086∨</span>
			<input class="phone" maxlength="20" type="text" name="phoneNumber" placeholder="建议使用常用手机">
			</label>
					<div id="phoneIs" class="tips">

					</div>
				</div>
				<div class="register-box">
					<label  class="other_label">验 证 码
			<input maxlength="20" type="text" placeholder="请输入验证码">
			</label>
					<span id="code"></span>
					<div class="tips">

					</div>
				</div>
				<div class="arguement">
					<input type="checkbox" id="xieyi"> 阅读并同意
					<a href="#">《燕鸣书屋用户注册协议》</a>
					<a href="#">《隐私政策》</a>
					<div class="tips">

					</div>
				</div>
				<div class="submit_btn">
					<button type="button" id="submit_btn">立 即 注 册</button>
				</div>
			</form>
		</section>
	<div style="text-align:center;margin:20px 0; font:normal 14px/24px 'MicroSoft YaHei';">
    <p class="message"> <a href="#" style="color: red;">忘记密码?</a></p>
</div>
	</body>
<script>
    $(function(){
        //聚焦失焦input
        $('input').eq(0).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("支持中文，字母，数字，'-'，'_'的多种组合");
            }
        })
        $('input').eq(1).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("建议使用字母、数字和符号两种以上的组合，6-20个字符");
            }
        })
        $('input').eq(2).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("请再次输入密码");
            }
        })
        $('input').eq(3).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("验证完后，你可以使用该手机登陆和找回密码");
            }
        })
        $('input').eq(4).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next().next("div").text("看不清？点击图片更换验证码");
            }
        })
        //input各种判断
        //用户名：
        $('input').eq(0).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("");
                $(this).parent().next("div").css("color",'#ccc');
            }else if($(this).val().length>0 && $(this).val().length<4){
                $(this).parent().next("div").text("长度只能在4-20个字符之间");
                $(this).parent().next("div").css("color",'red');
            }else if($(this).val().length>=4&& !isNaN($(this).val())){
                $(this).parent().next("div").text("用户名不能为纯数字");
                $(this).parent().next("div").css("color",'red');
            }else{
                $(this).parent().next("div").text("");
            }
        })
        //密码
        $('input').eq(1).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("");
                $(this).parent().next("div").css("color",'#ccc');
            }else if($(this).val().length>0 && $(this).val().length<6){
                $(this).parent().next("div").text("长度只能在6-20个字符之间");
                $(this).parent().next("div").css("color",'red');
            }else{
                $(this).parent().next("div").text("");
            }
        })
//	确认密码
        $('input').eq(2).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("");
                $(this).parent().next("div").css("color",'#ccc');
            }else if($(this).val()!=$('input').eq(1).val()){
                $(this).parent().next("div").text("两次密码不匹配");
                $(this).parent().next("div").css("color",'red');
            }else{
                $(this).parent().next("div").text("");
            }
        })
//	手机号
        $('input').eq(3).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next("div").text("");
                $(this).parent().next("div").css("color",'#ccc');
            }else if($(this).val().length>0){
                var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
                var phone = $.trim($(this).val());
                if (!phoneReg.test(phone)) {
                    $(this).parent().next("div").text("手机号格式不正确");
                    $(this).parent().next("div").css("color",'red');
                }else{
                /*验证手机号是否已经存在*/
                $.ajax({
                    type : "post",
                    async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                    url : "${basePath}/login/userphone",    //请求发送到TestServlet处
                    data: JSON.stringify($.extend(true, {}, {phoneNumber:$(this).val()})),
                    contentType:"text/html;charset=utf-8",
                    dataType: "json",   //返回格式为json
                    success : function(data) {
                        try {
                            //请求成功时执行该函数内容，result即为服务器返回的json对象
                            if (data.resultMassage == 1){
                                $("#phoneIs").text("手机号已经存在了！");
                                $("#phoneIs").css("color",'red');
                            }
                            else{
                                $("#phoneIs").text("");
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
            }else {
                $(this).parent().next("div").text("");
			}
        })
// 	验证码
//	 验证码刷新
        function code(){
            var str="qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPLKJHGFDSAZXCVBNM";
            var str1=0;
            for(var i=0; i<4;i++){
                str1+=str.charAt(Math.floor(Math.random()*62))
            }
            str1=str1.substring(1)
            $("#code").text(str1);
        }
        code();
        $("#code").click(code);
//	验证码验证
        $('input').eq(4).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next().next("div").text("");
                $(this).parent().next().next("div").css("color",'#ccc');
            }else if($(this).val().toUpperCase()!=$("#code").text().toUpperCase()){
                $(this).parent().next().next("div").text("验证码不正确");
                $(this).parent().next().next("div").css("color",'red');
            }else{
                $(this).parent().next().next("div").text("");
            }
        })
//	提交按钮
        $("#submit_btn").click(function(e){
            for(var j=0 ;j<5;j++){
                if($('input').eq(j).val().length==0){
                    $('input').eq(j).focus();
                    if(j==4){
                        $('input').eq(j).parent().next().next("div").text("此处不能为空");
                        $('input').eq(j).parent().next().next("div").css("color",'red');
                        return;
                    }
                    $('input').eq(j).parent().next(".tips").text("此处不能为空");
                    $('input').eq(j).parent().next(".tips").css("color",'red');
                    return;
                }
            }
            //验证
                if( $('input').eq(0).val().length==0){
                    $('input').eq(0).parent().next("div").text("");
                    $('input').eq(0).parent().next("div").css("color",'#ccc');
                    return;
                }else if( $('input').eq(0).val().length>0 &&  $('input').eq(0).val().length<4){
                    $('input').eq(0).parent().next("div").text("长度只能在4-20个字符之间");
                    $('input').eq(0).parent().next("div").css("color",'red');
                    return;

                }else if( $('input').eq(0).val().length>=4&& !isNaN( $('input').eq(0).val())){
                    $('input').eq(0).parent().next("div").text("用户名不能为纯数字");
                    $('input').eq(0).parent().next("div").css("color",'red');
                    return;

                }else{
                    $('input').eq(0).parent().next("div").text("");
                }
            //密码
                if( $('input').eq(1).val().length==0){
                    $('input').eq(1).parent().next("div").text("");
                    $('input').eq(1).parent().next("div").css("color",'#ccc');
                    return;
                }else if( $('input').eq(1).val().length>0 &&  $('input').eq(1).val().length<6){
                    $('input').eq(1).parent().next("div").text("长度只能在6-20个字符之间");
                    $('input').eq(1).parent().next("div").css("color",'red');
                    return;
                }else{
                    $('input').eq(1).parent().next("div").text("");
                }
//	确认密码
                if( $('input').eq(2).val().length==0){
                    $('input').eq(2).parent().next("div").text("");
                    $('input').eq(2).parent().next("div").css("color",'#ccc');
                    return;
                }else if ($('input').eq(2).val()!=$('input').eq(2).val()){
                    $('input').eq(2).parent().next("div").text("两次密码不匹配");
                    $('input').eq(2).parent().next("div").css("color",'red');
                    return;
                }else{
                    $('input').eq(2).parent().next("div").text("");
                }
//	手机号
                if($('input').eq(3).val().length==0){
                    $('input').eq(3).parent().next("div").text("");
                    $('input').eq(3).parent().next("div").css("color",'#ccc');
                    return;
                }else if( $('input').eq(3).val().length>0){
                    var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
                    var phone = $.trim($('input').eq(3).val());
                    if (!phoneReg.test(phone)) {
                        $('input').eq(3).parent().next("div").text("手机号格式不正确");
                        $('input').eq(3).parent().next("div").css("color",'red');
                        return;
                    }else{
                        /*验证手机号是否已经存在*/
                        $.ajax({
                            type : "post",
                            async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                            url : "${basePath}/login/userphone",    //请求发送到TestServlet处
                            data: JSON.stringify($.extend(true, {}, {phoneNumber:$('input').eq(3).val()})),
                            contentType:"text/html;charset=utf-8",
                            dataType: "json",   //返回格式为json
                            success : function(data) {
                                try {
                                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                                    if (data.resultMassage == 1){
                                        $("#phoneIs").text("手机号已经存在了！");
                                        $("#phoneIs").css("color",'red');
                                        return;
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
                }else {
                    $('input').eq(3).parent().next("div").text("");
                }
            //	验证码验证
                if($('input').eq(4).val().length==0){
                    $('input').eq(4).parent().next().next("div").text("");
                    $('input').eq(4).parent().next().next("div").css("color",'#ccc');
                    return;
                }else if($('input').eq(4).val().toUpperCase()!=$("#code").text().toUpperCase()){
                    $('input').eq(4).parent().next().next("div").text("验证码不正确");
                    $('input').eq(4).parent().next().next("div").css("color",'red');
                    return;
                }else{
                    $('input').eq(4).parent().next().next("div").text("");
                }
            //协议
            if($("#xieyi")[0].checked){
                //向变量stuList数组添加一个数值，数值内部格式Student(name,password,tel,id)
                //发送用户信息
                //请求后台
                $.ajax({
                    type : "post",
                    async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                    url : "${basePath}/login/usersign",    //请求发送到TestServlet处
                    data: JSON.stringify($.extend(true, {},  convertSerializeArrayToObject($("#form_login_q").serializeArray()))),
                    contentType:"text/html;charset=utf-8",
                    dataType: "json",   //返回格式为json
                    success : function(data) {
                        try {
                            //请求成功时执行该函数内容，result即为服务器返回的json对象
                            if (data.resultMassage == 0){
                                alert("注册失败！")
                            }else if(data.resultMassage==1){
                                alert("注册成功！！")
                                window.location.href="/ideaWorkSpace/sso/sharebook/login.jsp";
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
            }else{
                $("#xieyi").next().next().next(".tips").text("请勾选协议");
                $("#xieyi").next().next().next(".tips").css("color",'red');
                return;
            }
        })
    })
    function convertSerializeArrayToObject(array) {
        var obj = {};
        for(var i = 0, length = array.length; i < length; i++) {
            obj[array[i]['name']] = array[i]['value'];
        }
        return obj;
    }
</script>
</html>