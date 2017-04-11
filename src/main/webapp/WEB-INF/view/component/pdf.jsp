<%@ page language="java" import="java.util.*,java.io.*"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>资料集锦管理系统</title>
    <link rel="stylesheet" href="/dcs/static/css/pdf.css">
    <link rel="stylesheet" href="/dcs/static/css/main.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="/dcs/static/css/bootstrap.min.css">
</head>
<body>
<div class="nav">
    <ul>
        <li class="nav-active"><a href="/dcs/excel/select_limit">主页</a></li>
        <li><a href="/dcs/excel/student_office">学工办</a></li>
        <li><a href="/dcs/excel/subcommittee">分团委</a></li>
        <li><a href="/dcs/excel/counsellor">辅导员</a></li>
        <c:if test="${sessionScope.user.level eq '管理员'}">
        	<li><a href="/dcs/management">用户管理</a></li>
        </c:if>
        <li><a href="/dcs/change">修改密码</a></li>
    </ul>
</div>
<div class="header">
    <div class="logo">
        <img src="/dcs/static/img/logo.png" height="45"/>
    </div>
    <div class="tool">
        <ul>
            <li class="out"><a href="/dcs/exit" id="log-out">注销</a></li>
            <c:if test="${sessionScope.user ne null}">
            	<li id="username">${sessionScope.user.loginName}</li>
            	<li id="level">${sessionScope.user.level}</li>
            </c:if>
        </ul>
    </div>
</div>
<div id="container" class="container">
    <div class="warp">
        <div class="title"><span class="text">整体浏览页 > 列表信息 > 详情信息</span></div>
        <!--<div class="title pull-right text">-->
            <!--<span class="glyphicon glyphicon-arrow-left"></span>-->
            <!--<a id="back" href="#">返回</a>-->
        <!--</div>-->
    </div>
    <div class="clearfix" id="${code}">
        <div class="pull-right mg-5" id="${infoId}"> 
            <button type="button" class="btn btn-danger" id="download">下载</button>
        </div>
    </div>
    <div class="group">
    	<div class="path">    	
       		<embed src="${path}"></embed>
   		</div>
    </div>
</div>
<script src="/dcs/static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="/dcs/static/js/content.js" charset="utf-8"></script>
<script src="/dcs/static/js/bootstrap.min.js"></script>
<script src="/dcs/static/js/pdf.js" charset="utf-8"></script>
</body>
</html>