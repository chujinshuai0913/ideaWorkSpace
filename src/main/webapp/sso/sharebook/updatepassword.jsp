<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>修改密码</title>
		<script src="${basePath}/sso/js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${basePath}/sso/css/login.css">
	</head>
	<body>
		<header>
			<a href="${basePath}/sharebook/jsp/shareindex.jsp" class="logo"><img style="height: 50px;width: 160px" src="${basePath}/sso/img/燕鸣书屋.png" ></a>
			<div class="desc">燕鸣书屋</div>
		</header>
		<section>
			<form id="form_login_q">
				<div class="register-box">
					<label  class="other_label">原 密 码
						<input maxlength="20" type="password" name="password" placeholder="建议至少使用两种字符组合">
					</label>
					<div class="tips">

					</div>
				</div>
				<div class="register-box">
					<label  class="other_label">设 置 密 码
			<input maxlength="20" type="password" name="newpassword" placeholder="建议至少使用两种字符组合">
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
					<label  class="other_label">验 证 码
			<input maxlength="20" type="text" placeholder="请输入验证码">
			</label>
					<span id="code"></span>
					<div class="tips">

					</div>
				</div>
				<div class="submit_btn">
					<button type="button" id="submit_btn">立 即 修 改</button>
				</div>
			</form>
		</section>
	</body>
<script>
    $(function(){
        //聚焦失焦input
        $('input').eq(0).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next(".tips").text("建议使用字母、数字和符号两种以上的组合，6-10个字符");
            }
        })
        $('input').eq(1).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next(".tips").text("建议使用字母、数字和符号两种以上的组合，6-10个字符");
            }
        })
        $('input').eq(2).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next(".tips").text("请再次输入密码");
            }
        })

        $('input').eq(3).focus(function(){
            if($(this).val().length==0){
                $(this).parent().next().next(".tips").text("看不清？点击图片更换验证码");
            }
        })
        //input各种判断
        //用户名：
        $('input').eq(0).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next(".tips").text("");
                $(this).parent().next(".tips").css("color",'#ccc');
            }else if( $('input').eq(0).val().length>0 &&  $('input').eq(1).val().length<6&& $('input').eq(1).val().length>10){
                $(this).parent().next(".tips").text("长度只能在6-10个字符之间");
                $(this).parent().next(".tips").css("color",'red');
            }else{
                $(this).parent().next(".tips").text("");
            }
        })
        //密码
        $('input').eq(1).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next(".tips").text("");
                $(this).parent().next(".tips").css("color",'#ccc');
            }else if( $('input').eq(0).val().length>0 &&  $('input').eq(1).val().length<6&& $('input').eq(1).val().length>10){
                $(this).parent().next(".tips").text("长度只能在6-10个字符之间");
                $(this).parent().next(".tips").css("color",'red');
            }else{
                $(this).parent().next(".tips").text("");
            }
        })
//	确认密码
        $('input').eq(2).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next(".tips").text("");
                $(this).parent().next(".tips").css("color",'#ccc');
            }else if($(this).val()!=$('input').eq(1).val()){
                $(this).parent().next(".tips").text("两次密码不匹配");
                $(this).parent().next(".tips").css("color",'red');
            }else{
                $(this).parent().next(".tips").text("");
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
        $('input').eq(3).blur(function(){
            if($(this).val().length==0){
                $(this).parent().next().next(".tips").text("");
                $(this).parent().next().next(".tips").css("color",'#ccc');
                return ;
            }else if($(this).val().toUpperCase()!=$("#code").text().toUpperCase()){
                $(this).parent().next().next(".tips").text("验证码不正确");
                $(this).parent().next().next(".tips").css("color",'red');
                return ;
            }else{
                $(this).parent().next().next(".tips").text("");
            }
        })
//	提交按钮
        $("#submit_btn").click(function(e){
            for(var j=0 ;j<4;j++){
                if($('input').eq(j).val().length==0){
                    $('input').eq(j).focus();
                    $('input').eq(j).parent().next(".tips").text("此处不能为空");
                    $('input').eq(j).parent().next(".tips").css("color",'red');
                    return;
                }
            }
            //验证
            if( $('input').eq(0).val().length==0){
                $('input').eq(0).parent().next(".tips").text("");
                $('input').eq(0).parent().next(".tips").css("color",'#ccc');
                return;
            }else if( $('input').eq(0).val().length>0 &&  $('input').eq(1).val().length<6&& $('input').eq(1).val().length>0){
                $('input').eq(0).parent().next(".tips").text("长度只能在6-10个字符之间");
                $('input').eq(0).parent().next(".tips").css("color",'red');
                return;
            }else{
                $('input').eq(0).parent().next(".tips").text("");
            }
            //密码
                if( $('input').eq(1).val().length==0){
                    $('input').eq(1).parent().next(".tips").text("");
                    $('input').eq(1).parent().next(".tips").css("color",'#ccc');
                    return;
                }else if( $('input').eq(0).val().length>0 &&  $('input').eq(1).val().length<6&& $('input').eq(1).val().length>10){
                    $('input').eq(1).parent().next(".tips").text("长度只能在6-10个字符之间");
                    $('input').eq(1).parent().next(".tips").css("color",'red');
                    return;
                }else{
                    $('input').eq(1).parent().next(".tips").text("");
                }
//	确认密码
                if( $('input').eq(2).val().length==0){
                    $('input').eq(2).parent().next(".tips").text("");
                    $('input').eq(2).parent().next(".tips").css("color",'#ccc');
                    return;
                }else if ($('input').eq(2).val()!=$('input').eq(2).val()){
                    $('input').eq(2).parent().next(".tips").text("两次密码不匹配");
                    $('input').eq(2).parent().next("di.tipsv").css("color",'red');
                    return;
                }else{
                    $('input').eq(2).parent().next(".tips").text("");
                }

            //	验证码验证
                if($('input').eq(3).val().length==0){
                    $('input').eq(3).parent().next().next(".tips").text("");
                    $('input').eq(3).parent().next().next(".tips").css("color",'#ccc');
                    return;
                }else if($('input').eq(3).val().toUpperCase()!=$("#code").text().toUpperCase()){
                    $('input').eq(3).parent().next().next(".tips").text("验证码不正确");
                    $('input').eq(3).parent().next().next(".tips").css("color",'red');
                    return;
                }else{
                    $('input').eq(3).parent().next().next(".tips").text("");
                }
                //向变量stuList数组添加一个数值，数值内部格式Student(name,password,tel,id)
                //发送用户信息
                //请求后台
                $.ajax({
                    type : "post",
                    async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                    url : "${basePath}/login/updatesharepassword",    //请求发送到TestServlet处
                    data: JSON.stringify($.extend(true, {},  convertSerializeArrayToObject($("#form_login_q").serializeArray()))),
                    contentType:"text/html;charset=utf-8",
                    dataType: "json",   //返回格式为json
                    success : function(data) {
                        try {
                            //请求成功时执行该函数内容，result即为服务器返回的json对象
                            if (data.resultMassage == 'ok'){
                                alert("修改成功！");
                                window.location.href="/ideaWorkSpace/sso/sharebook/login.jsp";
                            }else {
                                alert(data.resultMassage);
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