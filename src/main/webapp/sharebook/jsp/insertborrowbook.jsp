 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
    <!DOCTYPE html>
    <html>
    <head>
        <title>我的闲置书</title>
        <meta charset="utf-8" />
        <title>燕鸣书屋</title>
        <script src="${basePath}/sharebook/js/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table.js"></script>
        <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/js/bootstrap-table-zh-CN.min.js"></script>
        <script type="text/javascript" src="${basePath}/sharebookmanager/static/bootstrap-datepicker-1.5.0/js/bootstrap-datepicker.js" ></script>
        <script type="text/javascript" src="${basePath}/sharebook/js/jquery.cardtabs.js"></script>
        <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-table-1.9.1/css/bootstrap-table.css" />
        <link rel="stylesheet" href="${basePath}/sharebookmanager/static/bootstrap-3.3.5/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/index.css">
        <link rel="stylesheet" href="${basePath}/sharebook/css/bookdetails.css" />
        <link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/tab_div.css">
        <link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/demo.css">
        <link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/jquery.cardtabs.css">
        <link rel="stylesheet" type="text/css" href="${basePath}/sharebook/css/dl_b.css">
    </head>
    <style>
        .bodyPage_body_insert_bookdetail{
            width: 90%;
            margin: auto;
        }
        .bodyPage_body_insert_bookdetail_up{
            width: 100%;
            margin-top: 20px;
        }

        .bodyPage_body_insert_bookdetail_up_img{
            width:23%;
            height: 310px;
            float: left;
            background-color: grey;
        }
        .bodyPage_body_insert_bookdetail_up_img img{
            width: 100%;
            height: 100%;
        }
        .bodyPage_body_insert_bookdetail_up_text{
            width: 77%;
            height: 310px;
            float: left;
            padding: 0 0 0 20px;
            font-size: 14px;
        }
    </style>
    <body>
    <div class="homePage">
        <div class="headPage">
            <div class="headPagehead">
                <div class="headPagehead_text_one">
                    <%--	${requestScope.user.id}--%>
                    <font color="grey">你好 <span>楚金帅</span><input id="userId" type="text" type="text" style="display: none" value="1">，欢迎访问燕鸣书屋 !</font>
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
                        <div class="headPagebody_none_search " style="height: 48px" >
                            <input class="headPagebody_none_search_text "  name="bookName1" type="text"  placeholder="书名" value="${requestScope.bookName1}"/>
                            <button class="headPagebody_none_search_icon"  type="submit">搜索</button>
                            <select name="classType1" name="searchSelect "  class="headPagebody_none_search_select">
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
                            <li><a href="${basePath}/sharebook/jsp/bookClassification.jsp">普通分类</a></li>
                            <li><a href="${basePath}/sharebook/jsp/bookProification.jsp">按专业分类</a></li>
                            <li><a href="# ">书籍竞拍</a></li>
                            <li><a href="# ">资料共享</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="bodyPage">
            <div class="bodyPage_body">
                <div class="bodyPage_body_insert_bookdetail">
                        <div class="bodyPage_body_insert_bookdetail_up markdown-body">
                            <div class='example'>
                                <div class='tabsholder'>
                                    <div data-tab="书籍信息">
                                        <div style="width: 100%;height: 310px">
                                        <div class="bodyPage_body_insert_bookdetail_up_img">
                                            <img src="${basePath}/sharebook/img/${requestScope.book.src}"/>
                                        </div>
                                         <div class="bodyPage_body_insert_bookdetail_up_text">
                                              <h1 style="display: inline">${requestScope.book.bookName}</h1>
                                             <span style="font-size: 12px;color: grey">
                                                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.book.subtitle}
                                             </span>
                                               <p style="margin-left: 20px;margin-top: 20px">

                                                   作者:<span>${requestScope.book.author}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                   翻译:<span>${requestScope.book.translator}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                   ISBN： <span>${requestScope.book.isbn}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                   ISBN10： <span>${requestScope.book.isbn10}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                               </p>
                                             <p style="margin-left: 20px;margin-top: 20px">
                                                 定价： <span>${requestScope.book.pricing}元</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                 装帧:<span>${requestScope.book.binding}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                 页数：<span>${requestScope.book.pageNumber}页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                 出版社:<span>${requestScope.book.press}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                 出版时间:<span>
                                                             <jsp:useBean id="Timestamp" class="java.util.Date"/>
                                                            <c:set target="${Timestamp}" property="time" value="${requestScope.book.pressTime}"/>
                                                            <fmt:formatDate pattern="yyyy-MM-dd" value="${Timestamp}" type="both"/>
                                                        </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                             </p>
                                                <p style="margin-left: 20px;margin-top: 20px">
                                                  标签:<span>${requestScope.book.tag}</span>
                                                </p>
                                                <p style="margin-left: 20px;margin-top: 20px;height:100px;line-height: 30px;" class="zwjs">
                                                    作者简介:${requestScope.book.authorIntro}
                                                </p>
                                          </div>
                                        </div>
                                    </div>
                                    <div data-tab="简介" style="font-size: 14px;color: grey">
                                        ${requestScope.book.introduce}
                                    </div>
                                    <div data-tab="目录">
                                        <div style="width:50%;margin: auto">
                                            ${requestScope.book.catalog}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div style="width: 100%;margin-top: 20px">
                            <div style="width: 30%;margin: auto;color: grey;text-align: center">
                                <h2>需要出租书籍信息</h2>
                            </div>
                            <form id="form_insert_q" class="form-inline" role="form" style="width: 95%;margin: auto;margin-top: 20px;"
                                  onkeydown="if(event.keyCode==13){return false;}">
                                <input style="display: none" name="isbn" value="${requestScope.book.isbn}">
                                <div class="form-group" style="margin-left: 40px;">
                                    <label onclick="$(this).next().focus();">图片一</label>
                                    <input  style="margin-left:10px"  name="src1" type="text" id="uploadImg1" class="form-control" placeholder="图片一" readonly/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;">
                                    <label onclick="$(this).next().focus();">图片二</label>
                                    <input  style="margin-left: 10px"  name="src2" type="text"  id="uploadImg2" class="form-control" placeholder="图片二" readonly/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;">
                                    <label onclick="$(this).next().focus();">图片三</label>
                                    <input  style="margin-left: 10px"  name="src3" type="text"  id="uploadImg3" class="form-control" placeholder="图片三" readonly/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;">
                                    <label onclick="$(this).next().focus();">图片四</label>
                                    <input  style="margin-left: 10px"  name="src4" type="text"  id="uploadImg4" class="form-control" placeholder="图片四" readonly/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;margin-top: 20px;">
                                    <label onclick="$(this).next().focus();">租金</label>
                                    <input  style="margin-left: 25px"  name="price" type="text" class="form-control" placeholder="元/天"/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;margin-top: 20px;">
                                    <label onclick="$(this).next().focus();">逾期租金</label>
                                    <input  style="margin-left: 25px"  name="beyondPrice" type="text" class="form-control" placeholder="元/天"/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;margin-top: 20px;">
                                    <label onclick="$(this).next().focus();">押金</label>
                                    <input  style="margin-left: 25px"  name="depositPrice" type="text" class="form-control" placeholder="元/本 "/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;margin-top: 20px">
                                    <label onclick="$(this).next().focus();">数量</label>
                                    <input  style="margin-left: 25px"  name="useableNum" type="text" class="form-control" placeholder="数量"/>
                                </div>
                                <div class="form-group" style="margin-left: 40px;margin-top: 20px">
                                    <label onclick="$(this).next().focus();">一级分类</label>
                                    <select style="margin-left: 25px"  type="text" id="bookTypeName1" name="bookTypeName1"  class="form-control" >
                                    </select>
                                </div>
                                <div class="form-group" style="margin-left: 90px;margin-top: 20px">
                                    <label  onclick="$(this).next().focus();">二级分类</label>
                                    <select style="margin-left: 25px" type="text" name="bookTypeName2" id="bookTypeName2"  class="form-control" >
                                    </select>
                                </div>
                                <div class="form-group" style="margin-left: 40px;margin-top:20px">
                                    <label  onclick="$(this).next().focus();">介绍</label>
                                    <textarea class="form-control" name="remark" style="width:600px;height: 200px;margin-left: 25px">

                                    </textarea>
                                </div>
                                <div>
                                    <div class="form-group" style="margin-left: 500px;margin-top:50px;margin-bottom: 200px;">
                                        <label></label>
                                        <button type="button" id="formInsertBtn" class="btn btn-primary"  data-style="zoom-in"
                                                style="width: 200px;height:43px;"	formaction="javascript:void(0);">确认添加
                                        </button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    </div>
                                </div>
                            </form>
                        </div>
                </div>
            </div>
        </div>
        <div id="modal_uploadImg1" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
            <div class="modal-dialog" dialog-width="800px" style="width:800px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                        <h4 class="modal-title" >上传书籍图片</h4>
                        <input type="file" class="form-control"  id="logoFile" name="logoFile" onchange="setImg1(this);">
                        <img id="uploadImgShow1" style=" width:100%; height:80%;" src="${basePath}/sharebook/img/1.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <div id="modal_uploadImg2" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
            <div class="modal-dialog" dialog-width="800px" style="width:800px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                        <h4 class="modal-title" >上传书籍图片</h4>
                        <input type="file" class="form-control"  id="logoFile2" name="logoFile" onchange="setImg2(this);">
                        <img id="uploadImgShow2" style=" width:100%; height:80%;" src="${basePath}/sharebook/img/1.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <div id="modal_uploadImg3" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
            <div class="modal-dialog" dialog-width="800px" style="width:800px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                        <h4 class="modal-title" >上传书籍图片</h4>
                        <input type="file" class="form-control"  id="logoFile3" name="logoFile" onchange="setImg3(this);">
                        <img id="uploadImgShow3" style=" width:100%; height:80%;" src="${basePath}/sharebook/img/1.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <div id="modal_uploadImg4" class="modal fade" tabindex="1" role="dialog" aria-labelledby="lackModalLabel" data-backdrop="false" aria-hidden="true">
            <div class="modal-dialog" dialog-width="800px" style="width:800px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" onclick="$(this).parents('.modal').modal('hide');">&times;</button>
                        <h4 class="modal-title" >上传书籍图片</h4>
                        <input type="file" class="form-control"  id="logoFile4" name="logoFile" onchange="setImg4(this);">
                        <img id="uploadImgShow4" style=" width:100%; height:80%;" src="${basePath}/sharebook/img/1.jpg" >
                    </div>
                </div>
            </div>
        </div>
        <div style="width: 80px;height: 50px;opacity:0.3;background-color: lightgray;border-radius: 10px;position: fixed;	text-align: center;color: grey;right: 10px;top: 450px;line-height: 40px;z-index: 50;">
            <a href="javascript:window.scrollTo(0,0) ">返回顶部</a>
        </div>
    </div>
    </body>
    <script>
        $('.tabsholder').cardTabs({theme: 'graygreen'});
        //上传图片

        $('#uploadImg1').on('click', function () {
            $('#modal_uploadImg1').modal("show");
        });
        $('#uploadImg2').on('click', function () {
            $('#modal_uploadImg2').modal("show");
        });
        $('#uploadImg3').on('click', function () {
            $('#modal_uploadImg3').modal("show");
        });
        $('#uploadImg4').on('click', function () {
            $('#modal_uploadImg4').modal("show");
        });
        function setImg1(obj){//用于进行图片上传，返回地址
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
                        $("#uploadImg1").val(suc.message);//将地址存储好
                        $("#uploadImgShow1").attr("src","${basePath}/sharebook/img/"+suc.message+"");//显示图片
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
        function setImg2(obj){//用于进行图片上传，返回地址
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
                        $("#uploadImg2").val(suc.message);//将地址存储好
                        $("#uploadImgShow2").attr("src","${basePath}/sharebook/img/"+suc.message+"");//显示图片
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
        function setImg3(obj){//用于进行图片上传，返回地址
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
                        $("#uploadImg3").val(suc.message);//将地址存储好
                        $("#uploadImgShow3").attr("src","${basePath}/sharebook/img/"+suc.message+"");//显示图片
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
        function setImg4(obj){//用于进行图片上传，返回地址
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
                        $("#uploadImg4").val(suc.message);//将地址存储好
                        $("#uploadImgShow4").attr("src","${basePath}/sharebook/img/"+suc.message+"");//显示图片
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
        $('#formInsertBtn').on('click', function () {
            $.ajax({
                type : "post",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/ideaWorkSpace/bookshare/insertborrowbook",    //请求发送到TestServlet处
                data: JSON.stringify($.extend(true, {},convertSerializeArrayToObject($("#form_insert_q").serializeArray()))),
                contentType:"text/html;charset=utf-8",
                dataType: "json",   //返回格式为json
                success : function(data) {
                    try {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (data.error_code == 0){
                            alert("添加成功！")
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
        });
        //图书分类
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
                            $("#bookTypeName1").find("option").remove();
                            list.forEach(function (item) {
                                $("#bookTypeName1").append("<option value='"+item.id+"'>"+item.className1+"</option>");
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
        //图书二类
        $("#bookTypeName1").change(function(){
            Class2BookTopAjax( $("#bookTypeName1").val());
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
                            $("#bookTypeName2").find("option").remove();
                            if(list.length>0){
                                list.forEach(function (item) {
                                    $("#bookTypeName2").append("<option>"+item.className2+"</option>");
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
        function convertSerializeArrayToObject(array) {
            var obj = {};
            for(var i = 0, length = array.length; i<length; i++){
                obj[array[i]['name']] =array[i]['value'];
            }
            return obj;
        }
    </script>
    </html>
