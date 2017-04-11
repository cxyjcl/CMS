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
        <li><a href="/dcs/excel/student_office">学工办</a></li>
        <li><a href="/dcs/excel/subcommittee">分团委</a></li>
        <li class="nav-active"><a href="/dcs/excel/counsellor">辅导员</a></li>
        <c:if test="${sessionScope.user.level ne '管理员'}">
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
            <li><a href="/dcs/excel/select_list?code=10001&level=1" class="list-group-item">1.年级信息</a></li>
            <li><a href="/dcs/excel/select_list?code=10002&level=1" class="list-group-item">2.班级信息</a></li>
            <li><a href="/dcs/excel/select_list?code=10003&level=1" class="list-group-item">3.年级本学期党建学生名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10004&level=1" class="list-group-item">4.年级各种荣誉名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10005&level=1" class="list-group-item">5.年级各种学科竞赛获奖名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10006&level=1" class="list-group-item">6.各种校园文化活动获奖名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10007&level=1" class="list-group-item">7.年级奖、助学金名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10008&level=1" class="list-group-item">8.年级受处分学生名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10009&level=1" class="list-group-item">9.年级学籍异动学生名单和原因</a></li>
            <li><a href="/dcs/excel/select_list?code=10010&level=1" class="list-group-item">10.年级讲座统计表</a></li>
            <li><a href="/dcs/excel/select_list?code=10011&level=1" class="list-group-item">11.工作计划及总结</a></li>
            <li><a href="/dcs/excel/select_list?code=10012&level=1" class="list-group-item">12.毕业生派遣方案（毕业年级）</a></li>
            <li><a href="/dcs/excel/select_list?code=10013&level=1" class="list-group-item">13.个人成果及获奖情况</a></li>
        </ul>
    </div>
</div>
<script src="/dcs/static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="/dcs/static/js/content.js" charset="utf-8"></script>
</body>
</html>
