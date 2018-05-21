<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/heanesUI/js/resource/jquery.2.2.4.min.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/jquery-2.1.4/jquery.min.js" ></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-datepicker-1.5.0/js/bootstrap-datepicker.js" ></script>
    <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-3.3.5/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-datepicker-1.5.0/css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/css/bootstrap-table.css" />
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>

    <style type="text/css">
        body > div {
            margin: 0px;
            padding: 0px;
        }
        .form-group {
            margin-top: 20px;
            margin-left: 20px;
            margin-right: -5px;
        }
        body > div > form > .form-group > label {
            width: 90px;
            text-align: center;
        }

        .form-control, .select2-selection--single {
            min-width: 160px;
            max-width: 160px;
        }
        a{
            text-decoration:none;
            cursor:pointer
        }
        .W30 .th-inner {
            width:120px !important;
        }
    </style>


</head>
<body>
<div id="sharebookuserList" class="panel panel-default" style="padding-right: 0px;">
    <div>
        <form id="form_sharebookuser_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
              onkeydown="if(event.keyCode==13){return false;}">

            <div class="form-group">
                <label for="startTime" style="width: 90px;">预定上传日期</label>
                <div class="input-group date">
                    <input type="text" class="form-control" style="width: 147px;"
                           id="startTime" name="startTime"
                           placeholder="预定上传日期(开始)"> <span class="input-group-addon"><i
                        class="glyphicon glyphicon-th"></i></span>
                </div>
            </div>
            <div class="form-group">
                <label for="finshTime" style="width: 90px;">至</label>
                <div class="input-group date">
                    <input type="text" class="form-control" style="width: 147px;"
                           id="finshTime" name="finshTime" placeholder="预定上传日期(结束)">
                    <span class="input-group-addon"><i
                            class="glyphicon glyphicon-th"></i></span>
                </div>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">活动编码</label> <input
                    name="activityId" type="text" class="form-control" placeholder="活动编码"/>
            </div>
            <div class="form-group" style="margin-left: 50px;">
                <label onclick="$(this).next().focus();">是否删除</label>
                <select type="text" name="isDelete"  class="form-control" >
                    <option value="">全部</option>
                    <option value="1">是</option>
                    <option value="2">否</option>
                </select>
            </div>
                <div class="form-group" style="margin-left: 30px;">
                    <label></label>
                    <button type="button" id="formClass2SearchBtn" class="btn btn-primary" data-style="zoom-in"
                            formaction="javascript:void(0);">查询
                    </button>&nbsp;&nbsp;
                    <button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;
                    <button type="button" id="insertClass2" class="btn btn-primary" data-style="zoom-in"
                            formaction="javascript:void(0);">信息公告新建
                    </button>
                </div>
                <div class="form-group" style="margin-left: 30px;">
                    <button type="button" class="btn btn-success" onclick="rejectClass2()">删除</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-success" onclick="auditedClass2()">恢复</button>
                </div>
        </form>
    </div>
    <div id="panel-body" style="width: 98%;margin: auto;">
        <table  id="mainTable"></table>
    </div>
</div>
<div id="modal_insertClass2" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="400px" style="width:500px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" >信息公告</h4>
                <form id="form_insertClass2_q" class="form-inline" role="form" style="width: 95%;margin: auto;"
                      onkeydown="if(event.keyCode==13){return false;}">
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;">活动编码</label>
                        <input name="activityId" id="activityId" type="text" class="form-control" />
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;">图片上传</label>
                        <input name="src" type="text" class="form-control" placeholder="src" id="uploadImg" readonly="readonly"/>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">

                        <label for="startTime" style="width: 90px;" onclick="$(this).next().focus();">预定上传时间</label>
                        <div class="input-group date">
                            <input type="text" class="form-control" style="width: 147px;"
                                   id="start1Time" name="startTime"
                                   placeholder="预定上传时间"> <span class="input-group-addon"><i
                                class="glyphicon glyphicon-th"></i></span>
                        </div>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label for="finshTime" style="width: 90px;"  onclick="$(this).next().focus();">预定结束时间</label>
                        <div class="input-group date">
                            <input type="text" class="form-control" style="width: 147px;"
                                   id="finsh1Time" name="finshTime"
                                   placeholder="预定结束时间"> <span class="input-group-addon"><i
                                class="glyphicon glyphicon-th"></i></span>
                        </div>
                    </div>
                    <div class="form-group" style="margin-left: 50px;">
                        <label onclick="$(this).next().focus();" style="width: 90px;">内容备注</label>
                        <textarea name="remark" style="width: 300px" type="text" class="form-control" placeholder="内容备注"></textarea>
                    </div>
                    <div class="form-group" style="margin-left: 30px; display: inherit">
                        <label></label>
                        <button type="button" style="margin-left: 100px; " id="insert2" class="btn btn-primary" data-style="zoom-in"
                                formaction="javascript:void(0);">确认新增
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="modal_img" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="800px" style="width:800px">
        <div class="modal-content">
            <div class="modal-header" style="height: 400px">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
               <img id="myImage" style=" width:100%; height:98%;" src="${basePath}/sharebook/img/shareactivity/2.jpg" alt="信息公告图片">
            </div>
        </div>
    </div>
</div>
<div id="modal_uploadImg" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
    <div class="modal-dialog" dialog-width="800px" style="width:800px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                <h4 class="modal-title" >信息公告图片</h4>
                <input type="file" class="form-control"  id="logoFile" name="logoFile" onchange="setImg(this);">
                <img id="uploadImgShow" style=" width:100%; height:80%;" src="${basePath}/sharebook/img/shareactivity/1.jpg" >
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    //上传图片
    function setImg(obj){//用于进行图片上传，返回地址
        var f=$(obj).val();
        if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
        {
            alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
            $(obj).val('');
            return false;
        }
        var data = new FormData();
        $.each($(obj)[0].files,function(i,file){
            data.append('file', file);
        });
        $.ajax({
            type: "POST",
            url: "/ideaWorkSpace/img/uploadImgSimple",
            data: data,
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType:"json",
            success: function(suc) {
                if(suc.code==0){
                    $("#uploadImg").val(suc.message);//将地址存储好
                    $("#uploadImgShow").attr("src","${basePath}/sharebook/img/shareactivity/"+suc.message+"");//显示图片
                }else{
                    alertLayel("上传失败");
                    $(obj).val('');
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alertLayel("上传失败，请检查网络后重试");
                $(obj).val('');
            }
        });
    }

    $('#startTime').val(getNowDate());
    $('#finshTime').val(getNowDate(1));
    $('#startTime').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        language: "zh-CN"
    });

    $('#finshTime').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        language: "zh-CN"
    });

    $('#start1Time').val(getNowDate());
    $('#finsh1Time').val(getNowDate(1));
    $('#start1Time').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        language: "zh-CN"
    });
    $('#finsh1Time').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        language: "zh-CN"
    });

    //初始化配送日期
    function getNowDate(isNext) {
        var d = new Date();
        var timestamp = d.getTime();
        console.log("timestamp:" + timestamp);
        var hour = d.getHours();
        if (hour >= 12) {
            d = new Date(timestamp);
        }
        if (isNext && hour > 12) {
            timestamp += 86400000;
            console.log("timestamp2:" + timestamp);
            d = new Date(timestamp);
        }
        var year = d.getFullYear() + "";
        var month = d.getMonth() + 1 + "";
        var day = d.getDate() + "";
        return year + "-" + ((month.length == 1) ? ("0" + month) : month)
            + "-" + ((day.length == 1) ? ("0" + day) : day);
    }
    $('#insertClass2').on('click', function (){
        $('#modal_insertClass2').modal("show");
    });
    $('#formClass2SearchBtn').on('click', function () {
        $('#mainTable').bootstrapTable('refresh');
    });
    var $table = $("#mainTable");
    $table.bootstrapTable({
        toolbar: "#toolbar_book",
        url: '/ideaWorkSpace/share/shareannouncementlist',
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
        columns: [   {
            checkbox: true
        },
            {
                field: 'id',
                title: 'id',
                align: "center",
                visible:false,
            },
            {
                field: 'isDelete',
                title: 'isDelete',
                align: "center",
                visible:false,
            },{
                field: 'src',
                title: '图片路径',
                align: "center",
                formatter:function(value, row, index) {
                    return [ "<a  class='record-detail'>"+value+'</a>'].join('');
                },
                events: {
                    'click .record-detail': function (e, value, row, index) {
                        imgDialog(e, value, row, index);
                    }
                }
            }, {
                field: 'remark',
                title: '内容',
                align: "center",

            },
            {
                field: 'uTime',
                title: '预定开始时间',
                align: "center",

            },
            {
                field: 'eTime',
                title: '预定结束时间',
                align: "center",

            },
            {
                field: 'cUser',
                title: '操作人',
                align: "center",
                formatter: formatterToValue

            },
            {
                field: 'cTime',
                title: '操作时间',
                align: "center",
                formatter: formatterToValue
            }
        ]
    });

    function imgDialog(e, value, row, index){
        $('#modal_img').modal("show");
        $("#myImage").attr('src',"${basePath}/sharebook/img/shareactivity/"+value+"");
    }

    $('#uploadImg').on('click', function () {
        $('#modal_uploadImg').modal("show");
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
    //审核通过
    function auditedClass2(){
        var selected = $('#mainTable').bootstrapTable("getSelections");
        var dataNum=$('#mainTable').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
            if(item.isDelete != 1){
                alert("只能操作已删除的数据！")
                flag = false;
                return false;
            }else{
                ids[index] = item.id;
            }
        });
        if(flag){
            if(ids.length == 0){
                alert("最少要有一条数据！")
                flag = false;
                return false;
            }
            var params = {ids:ids};
            $.ajax({
                url: "/ideaWorkSpace/share/auditannouncement",    //请求的url地址
                dataType: "json",   //返回格式为json
                data: JSON.stringify(params),    //参数值
                type: "POST",   //请求方式
                contentType:"text/html;charset=utf-8",
                beforeSend: function() {
                },
                success: function(data) {
                    try {
                        console.log(JSON.stringify(data));
                        if(data){
                            var jsonData = JSON.parse(JSON.stringify(data));
                            if(jsonData.resultMassage == 'ok'){
                                alert("操作成功!");
                                $('#mainTable').bootstrapTable('refresh');
                            }else{
                                alert(jsonData.resultMassage);
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
            });
        }
    }

    //驳回
    function rejectClass2(){
        var selected = $('#mainTable').bootstrapTable("getSelections");
        var dataNum=$('#mainTable').bootstrapTable("getOptions").data.length;
        if (dataNum == 0) {
            alert("没有要操作的数据！")
            return false;
        }
        var ids = [];
        var flag = true;
        $.each(selected,function(index,item){
            if(item.isDelete != 2){
                alert("只能操作未删除的数据！")
                flag = false;
                return false;
            }else{
                ids[index] = item.id;
            }
        });

        if(flag){
            if(ids.length == 0){
                alert("最少要有一条数据！")
                flag = false;
                return false;
            }
            var params = {ids:ids};
            $.ajax({
                url: "/ideaWorkSpace/share/auditNotannouncement",    //请求的url地址
                dataType: "json",   //返回格式为json
                data: JSON.stringify(params),    //参数值
                type: "POST",   //请求方式
                contentType:"text/html;charset=utf-8",
                beforeSend: function() {
                },
                success: function(data) {
                    try {
                        console.log(JSON.stringify(data));
                        if(data){
                            var jsonData = JSON.parse(JSON.stringify(data));
                            if(jsonData.resultMassage == 'ok'){
                                alert("操作成功!");
                                $('#mainTable').bootstrapTable('refresh');
                            }else{
                                alert(jsonData.resultMassage);
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
            });
        }
    }

    $('#insert2').on('click',function(){
        $.ajax({
            url: "/ideaWorkSpace/share/insertannouncement",    //请求的url地址
            dataType: "json",   //返回格式为json
            data: JSON.stringify($.extend(true, {},convertSerializeArrayToObject($("#form_insertClass2_q").serializeArray()))),
            type: "POST",   //请求方式
            contentType:"text/html;charset=utf-8",
            beforeSend: function() {
            },
            success: function(data) {
                try {
                    if(data){
                        console.log(JSON.stringify(data));
                        var jsonData = JSON.parse(JSON.stringify(data));
                        console.log(jsonData.resultMassage );
                        if(jsonData.resultMassage == 'ok'){
                            alert("插入成功!")
                            $("#form_insertClass2_q")[0].reset();
                                $('#modal_insertClass2').modal("hide");
                            $('#mainTable').bootstrapTable('refresh');
                        }else{
                            alert(jsonData.resultMassage);
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
        });
    });
</script>
</body>
</html>