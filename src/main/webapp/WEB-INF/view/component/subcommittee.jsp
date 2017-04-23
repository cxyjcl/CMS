<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料集锦管理系统</title>
    <link rel="stylesheet" href="/dcs/static/css/main.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="/dcs/static/css/bootstrap.min.css">
</head>
<body>
<div class="nav">
    <ul>
        <li><a href="/dcs/excel/select_limit">主页</a></li>
        <li><a href="/dcs/excel/counsellor">辅导员</a></li>        
        <li><a href="/dcs/excel/student_office">学工办</a></li>
        <li class="nav-active"><a href="/dcs/excel/subcommittee">分团委</a></li>
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
        <div class="title"><span class="text">整体浏览页</span></div>
    </div>
    <div class="group">
        <ul class="list-group">
            <li><a href="/dcs/excel/select_list?code=20001&level=3" class="list-group-item">1.分团委、学生会、协会人员名单</a></li></li>
            <li><a href="/dcs/excel/select_list?code=20002&level=3" class="list-group-item">2.学生荣誉名单（团委）</a></li>
            <li><a href="/dcs/excel/select_list?code=10005&level=3" class="list-group-item">3.各种学科竞赛获奖名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10006&level=3" class="list-group-item">4.各种校园文化活动获奖名单</a></li>
            <li><a href="/dcs/excel/select_list?code=20003&level=3" class="list-group-item">5.学期开展活动汇总表及方案</a></li>
            <li><a href="/dcs/excel/select_list?code=10011&level=3" class="list-group-item">6.工作计划及总结</a></li>
            <li><a href="/dcs/excel/select_list?code=10013&level=3" class="list-group-item">7.个人成果及获奖情况</a></li>
        </ul>
    </div>
</div>
<script src="/dcs/static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="/dcs/static/js/content.js" charset="utf-8"></script>
</body>
</html>
