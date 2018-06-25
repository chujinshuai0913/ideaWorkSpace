<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>登入</title>

<script src="${basePath}/sso/js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${basePath}/sso/css/login.css">

</head>
<body>
<header>
	<a href="${basePath}/sharebook/jsp/shareindex.jsp" class="logo"><img style="height: 50px;width: 160px" src="${basePath}/sso/img/燕鸣书屋.png" ></a>
	<div class="desc">欢迎登陆</div>
	<div class="desc1">还没有账户? <a href="${basePath}/sso/sharebook/sign.jsp" style="color: red;">立刻创建</a></div>
</header>
<section>
	<form id="form_login_q">
		<div class="register-box">
			<label  class="username_label">用 户 名
				<input maxlength="20" class="phone" name="phoneNumber" type="text" placeholder="手机号">
			</label>
			<div class="tips">

			</div>
		</div>
		<div class="register-box">
			<label class="other_label">密 码
				<input maxlength="20" type="password" name="password" placeholder="密码">
			</label>
			<div class="tips">

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
		<div class="submit_btn">
			<button type="button" id="login">立即登陆</button>
		</div>
	</form>
</section>
</body>
<script>
$(function () {
    var password=$(".password").val();
	var phoneNumber=$(".phoneNumber").val();
        //聚焦失焦input
        $('input').eq(2).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next().next("div").text("看不清？点击图片更换验证码");
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

    $("#login").on('click',function () {
        for(var j=0 ;j<2;j++){
            if($('input').eq(j).val().length==0){
                $('input').eq(j).focus();
                $('input').eq(j).parent().next(".tips").text("此处不能为空");
                $('input').eq(j).parent().next(".tips").css("color",'red');
                return;
            }
        }
        //	验证码验
        $('input').eq(2).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next().next("div").text("");
                $(this).parent().next().next("div").css("color",'#ccc');
                return ;
            }else if($(this).val().toUpperCase()!=$("#code").text().toUpperCase()){
                $(this).parent().next().next("div").text("验证码不正确");
                $(this).parent().next().next("div").css("color",'red');
                return ;
            }else{
                $(this).parent().next().next("div").text("");
            }
        })

        $.ajax({
            type : "post",
            async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "${basePath}/login/userlogin",    //请求发送到TestServlet处
            data: JSON.stringify($.extend(true, {},  convertSerializeArrayToObject($("#form_login_q").serializeArray()))),
            contentType:"text/html;charset=utf-8",
            dataType: "json",   //返回格式为json
            success : function(data) {
                try {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data.resultMassage == 0){
                        alert("登陆失败！")
                    }else if(data.resultMassage==1){
                        alert("登陆成功！！")
                       window.location.href="/ideaWorkSpace/sharebook/jsp/shareindex.jsp";
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
    function convertSerializeArrayToObject(array) {
        var obj = {};
        for(var i = 0, length = array.length; i < length; i++) {
            obj[array[i]['name']] = array[i]['value'];
        }
        return obj;
    }
})
</script>
</html>