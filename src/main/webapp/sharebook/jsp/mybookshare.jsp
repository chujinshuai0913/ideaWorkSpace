<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>个人中心</title>

	<link rel="stylesheet" type="text/css" href="${basePath}/sso/css/login.css">
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/heanesUI/js/resource/jquery.2.2.4.min.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/jquery-2.1.4/jquery.min.js" ></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table-zh-CN.min.js"></script>
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-3.3.5/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/css/bootstrap-table.css" />
	<script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</head>
<style>
	.span_1{
		width:195px ;
		height: 30px;
		display:block;
		float: left;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}
</style>
<body>
<header>
	<a href="${basePath}/sharebook/jsp/shareindex.jsp" class="logo"><img style="height: 50px;width: 160px" src="${basePath}/sso/img/燕鸣书屋.png" ></a>
	<div class="desc">个人中心</div>
	<div class="desc2"><a href="${basePath}/login/loginout" style="color: grey;">注销</a></div>
	<div class="desc1"><a href="${basePath}/login/updatepass" style="color: grey;">修改密码</a></div>
</header>
<section>
	<div style="width: 80%;margin: auto;margin-top:20px;">
		<p style="font-size: 20px;font-weight: bold;margin-top: 10px;display: inline">${sessionScope.userLogin.userName}</p>
		<p style="font-size: 16px; margin-top: 10px;display: inline">&nbsp;&nbsp;&nbsp;(${sessionScope.userLogin.phoneNumber})</p>

		<c:if test='${sessionScope.userLogin.studentCode != null}'>
			<p style="	margin-top: 10px;line-height: 30px;font-size: 16px;color: grey;">
				<span class="span_1">学号:<span>${sessionScope.userLogin.studentCode}</span></span>
				<span class="span_1">姓名：<span>${sessionScope.userLogin.realUserName}</span> </span>
				<span class="span_1">学院:<span>${sessionScope.userLogin.professionalName1}</span></span>
				<span class="span_1"> 专业：<span>${sessionScope.userLogin.professionalName2}</span></span>
			</p>
		</c:if>
		<c:if test='${sessionScope.userLogin.studentCode == null}'>
			<p style="	margin-top: 10px;line-height: 30px;font-size: 16px;color: grey;">
				<button type="button" style="margin-left: 30px;margin-top: 20px;" id="sureSchooclCode" class="btn btn-primary" data-style="zoom-in"
						formaction="javascript:void(0);">进行认证
				</button>&nbsp;&nbsp;
			</p>
		</c:if>

	</div>

	<div id="modal_detailTable" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
		<div class="modal-dialog"  dialog-width="400px" style="width:400px;margin-top: 400px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
					<h4 class="modal-title" id="modalTitle">输入学号</h4>
					<form id="isbnIn"  class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px"
						  onkeydown="if(event.keyCode==13){return false;}">
						<div class="form-group" style="margin-left: 30px;">
							<label onclick="$(this).next().focus();">学号</label>
							<input id="schoolCode" style="margin-left: 20px" name="schoolCode" type="text" class="form-control" placeholder="学号"/>
						</div>
						<div class="form-group" style="margin-left: 30px;margin-top: 20px">
							<label onclick="$(this).next().focus();">姓名</label>
							<input id="realName" style="margin-left: 20px" name="realName" type="text" class="form-control" placeholder="姓名"/>
						</div>
						<div class="form-group" style="margin-left: 100px;margin-top: 20px">
							<label></label>
							<button type="button" id="insertSearchBtn" class="btn btn-primary" data-style="zoom-in"
									formaction="javascript:void(0);">确定
							</button>&nbsp;&nbsp;
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<hr style="width: 80%;margin: auto">
	<c:if test='${sessionScope.userLogin.studentCode != null}'>
		<div style="width: 80%;margin: auto;margin-top:20px;">
			<form id="form_sharebookuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
				  onkeydown="if(event.keyCode==13){return false;}">
				<input type="text" name="typeProfessionalname1" style="display: none"  class="form-control" value="${sessionScope.userLogin.professionalName1}"/>
				<input type="text" name="typeProfessionalname2" style="display: none"  class="form-control" value="${sessionScope.userLogin.professionalName2}"/>
				<div class="form-group" style="margin-left: 20px;">
					<label onclick="$(this).next().focus();">年级</label>
					<select type="text" style="margin-left: 20px;" name="grade"  class="form-control" >
						<option value="">全部</option>
						<option value="0">通用</option>
						<option value="1">大一</option>
						<option value="2">大二</option>
						<option value="3">大三</option>
						<option value="4">大四</option>
						<option value="5">研一</option>
						<option value="6">研二</option>
						<option value="7">研三</option>
						<option value="8">博士</option>
					</select>
				</div>
				<div class="form-group" style="margin-left: 700px;">
					<label></label>
					<button type="button" id="formSearchBtn" class="btn btn-primary" data-style="zoom-in"
							formaction="javascript:void(0);">查询
					</button>&nbsp;&nbsp;
					<button type="reset" class="btn btn-warning">重置</button>
				</div>
			</form>
		</div>
		<div id="panel-body" style="width: 80%;margin: auto;">
			<table  id="mainTable"></table>
		</div>
	</c:if>
	</div>
</section>
</body>
<script>
    $('#formSearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    $('#sureSchooclCode').on('click', function () {
            $('#modal_detailTable').modal("show");
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_book",
        url: '/ideaWorkSpace/book/bookprofessionalList',
        showColumns: false,
        method:'post',
        dataType: "json",
        sidePagination : "server",
        pagination : true,
        sortOrder:"desc",
        pageList : [10,15,25,50,100,'all'],
        pageNumber:1,
        pageSize :10,
        totalField : "total_records",
        dataField: 'data',
        queryParamsType : "page",
        queryParams: function (params) {
            var newParams = convertSerializeArrayToObject($("#form_sharebookuser_q").serializeArray());
            newParams = $.extend(true, {}, params, newParams);
            return newParams;
        },
        columns: [
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,
            },
            {
                field: 'bookName',
                title: '书名',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'isbn',
                title: 'ISBN',
                align: "center",
                formatter :formatterToValue
            },
            {
                field: 'gradeName',
                title: '年级',
                align: "center",
                formatter :formatterToValue
            }
        ]
    });
    function convertSerializeArrayToObject(array) {
        var obj = {};
        for(var i = 0, length = array.length; i<length; i++){
            obj[array[i]['name']] =array[i]['value'];
        }
        return obj;
    }
    function formatterToValue(value, row, index) {
        if(value && value!=null && value !="1970"){

        }else{
            value="-";
        }
        return value;
    }
    $("#insertSearchBtn").on('click',function () {
		$.ajax({
            type : "post",
            async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "${basePath}/login/sureSchooclCode",    //请求发送到TestServlet处
            data: JSON.stringify($.extend(true, {},{schoolCode:$("#schoolCode").val(),realName:$("#realName").val()})),
            contentType:"text/html;charset=utf-8",
            dataType: "json",   //返回格式为json
            success : function(data) {
                try {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data.resultMassage == 'ok'){
                        alert("认证成功，需要您重新登陆！");
                        $('#modal_detailTable').modal("hide");
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
</script>
</html>