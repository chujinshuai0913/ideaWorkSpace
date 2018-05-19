<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
    <!-- meta -->
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta charset="UTF-8"/>
    <!-- responsive -->
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no,minimal-ui"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="renderer" content="webkit"/>
    <meta name="author" content="Heanes heanes.com email(heanes@163.com)"/>
    <meta name="keywords" content="软件,商务,HTML,tutorials,source codes"/>
    <meta name="description" content="描述，不超过150个字符"/>
    <!-- favicon -->
    <link rel="shortcut icon" href="/public/static/image/favicon/favicon.ico"/>
    <link rel="bookmark" href="/public/static/image/favicon/favicon.ico"/>
    <!-- css -->
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/vendor/heanesUI/dist/css/heanesUI.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/css/css.css"/>
    <title>后台欢迎页面</title>
</head>
<body class="scrollbar scrollbar-mini">
<div class="wrap">
    <!-- S 主要内容 S -->
    <div class="main">
        <!-- 顶部全宽度内容区域 -->
        <div class="main-top-block"></div>
        <!-- 顶部内容 -->
        <div class="main-top-content main-wrap"></div>
        <!-- 主体内容 -->
        <div class="main-content main-wrap clearfix">
            <!-- 中心区域 -->
            <div class="center-block center-wrap" style="margin: auto;text-align:center;margin-top: 50px;font: 100px;">
                <h2>Welcome</h2>
            </div>
        </div>
        <!-- 底部区域 -->
        <div class="main-bottom-content main-wrap"></div>
        <!-- 底部全宽度内容区域 -->
        <div class="main-bottom-block"></div>
    </div>
    <!-- E 主要内容 E -->
</div>
<!-- S 右侧功能区 S -->
<div class="right-bar">
    <div class="right-bar-content"></div>
</div>
<!-- E 右侧功能区 E -->
<cite>
    <!-- S js S -->
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/vendor/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            ;
        });
    </script>
    <!-- E js E -->
</cite>
</body>
</html>