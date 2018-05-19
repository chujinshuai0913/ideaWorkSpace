<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="author" content="Heanes heanes.com email(heanes@163.com)">
    <meta name="keywords" content="软件,商务,HTML,tutorials,source codes">
    <meta name="description" content="描述">
    <!-- css -->
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/vendor/jQWidgets/4.4.0/styles/jqx.base.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/vendor/jQWidgets/4.4.0/styles/jqx.bootstrap.css" media="screen">
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/vendor/treeView/1.0.0/css/treeView.min.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/vendor/heanesUI/dist/css/heanesUI.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/sharebookmanager/static/css/css.css"/>
    <link rel="shortcut icon" href="${basePath}/sharebookmanager/static/image/favicon/favicon.ico" type="image/x-icon">
    <link rel="icon" href="${basePath}/sharebookmanager/static/image/favicon/favicon.ico" type="image/x-icon">
    <title>燕鸣书屋后台管理</title>
</head>
<body class="scrollbar">
<div class="center wrap layout">
    <!-- S 主要内容 S -->
    <div class="main">
        <!-- 后台布局的相关处理 -->
        <div class="layout-handle">
            <a href="javascript:;" id="fullScreen" class="handle" title="全屏"><i class="fa fa-arrows-alt layout-handle-icon"></i></a>
        </div>
        <!-- 顶部全宽度内容区域 -->
        <div class="main-top-block">
            <div class="header">
                <div class="cell admin-logo left-width scrollbar scrollbar-mini">
                    <a href="javascript:;" class="admin-log-href lap-left-menu" id="homeStartHref" target="iframeRightContent">
                        <!--<i class="fa fa-gears admin-icon" aria-hidden="true"></i>-->
                        <img src="${basePath}/sharebookmanager/static/image/logo/logo.png" class="admin-icon" />
                        <span class="admin-title-text">管理后台<em class="system-version">v1.0</em></span>
                    </a>
                    <!-- 折叠左侧菜单 -->
                    <a href="javascript:;" class="lap-handle left-menu-lap-handle lap-left-menu" id="lapLeftMenu" title="收缩/展开左侧菜单">
                        <i class="fa fa-exchange" aria-hidden="true"></i>
                    </a>
                </div>
                <!-- 顶部菜单显示区域 -->
                <div class="cell menu-top scrollbar scrollbar-mini">
                </div>
                <div class="cell user-info-cell scrollbar scrollbar-mini">
                    <div class="user-info-wrap">
                        <div class="admin-user-info toggle-show">
                            <div class="user-info">
                                <span class="user-name">楚金帅</span>
                                <span class="user-role">(超级管理员)</span>
                            </div>
                            <div class="toggle-show-info-block">
                                <div class="user-detail">
                                    <dl>
                                        <dt class="field">电话:</dt>
                                        <dd class="value">15010691715</dd>
                                    </dl>
                                    <dl>
                                        <dt class="field">最后登录:</dt>
                                        <dd class="value">2016-12-12 11:06:12 周一</dd>
                                    </dl>
                                </div>
                                <div class="login-handle">
                                    <div class="handle-item">
                                        <a href="#" class="handle-href"><i class="fa fa-lock icon"></i>修改密码</a>
                                    </div>
                                    <div class="handle-item">
                                        <a href="#" class="handle-href"><i class="fa fa-power-off icon"></i>退出登录</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--<div class="admin-select-city">--%>
                            <%--<select class="select-city">--%>
                                <%--<option value="1">北京</option>--%>

                            <%--</select>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
        </div>
        <!-- 主体内容 -->
        <div class="main-content main-wrap clearfix">
            <!-- 左侧区域 -->
            <div class="left-block left-wrap left-width scrollbar scrollbar-mini"></div>
            <div class="v-split-bar"></div>
            <div class="v-split-bar-placeholder"></div>
            <!-- 中心区域 -->
            <div class="center-block center-wrap iframe-container">
                <!-- tabs相关操作 -->
                <div class="tabs-handle">
                    <a href="javascript:;" id="refreshTab" class="handle" title="刷新标签"><i class="fa fa-refresh"></i></a>
                    <a href="javascript:;" id="closeAllTabs" class="handle" title="关闭全部标签"><i class="fa fa-close"></i></a>
                </div>
                <div class="tabs-container" id="tabsContainer">
                    <ul class="tab-title-container" id="tabsTitleContainer">
                        <li>
                            <div class="tab-title-wrap">
                                <i class="tab-title-icon fa fa-home" aria-hidden="true"></i>
                                <span class="tab-title-text">首页</span>
                            </div>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <iframe src="${basePath}/sharebookmanager/jsp/welcome.jsp"></iframe>
                    </div>
                </div>
            </div>
            <!-- 右侧区域 -->
            <div class="right-block right-wrap"></div>
        </div>
        <!-- 底部区域 -->
        <div class="main-bottom-content main-wrap"></div>
        <!-- 底部全宽度内容区域 -->
        <div class="main-bottom-block"></div>
    </div>
    <!-- E 主要内容 E -->
</div>
<cite>
    <!-- S js S -->
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/vendor/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/vendor/jQWidgets/4.4.0/jqxcore.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/vendor/jQWidgets/4.4.0/jqxtabs.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/vendor/jQWidgets/4.4.0/jqxbuttons.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/vendor/treeView/1.0.0/js/treeView.min.js"></script>
    <script type="text/javascript" src="${basePath}/sharebookmanager/static/js/layout.js"></script>
    <!-- E js E -->
</cite>
</body>
</html>