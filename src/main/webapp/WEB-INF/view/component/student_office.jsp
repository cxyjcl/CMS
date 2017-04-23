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
        <li class="nav-active"><a href="/dcs/excel/student_office">学工办</a></li>
        <li><a href="/dcs/excel/subcommittee">分团委</a></li>
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
    <div class="group" id="group">
        <ul class="list-group">
            <li><a href="/dcs/excel/select_list?code=30001&level=2" class="list-group-item">1.学期学生信息一览表</a></li>
            <li><a href="/dcs/excel/select_list?code=30002&level=2" class="list-group-item">2.本学期党建发文文件</a></li>
            <li><a href="/dcs/excel/select_list?code=30003&level=2" class="list-group-item">3.本学期学生工作发文文件</a></li>
            <li><a href="/dcs/excel/select_list?code=30004&level=2" class="list-group-item">4.本学期党员转正、预备党员、积极分子、上党校学生汇总名单</a></li>
            <li><a href="/dcs/excel/select_list?code=30005&level=2" class="list-group-item">5.各类奖助学金汇总名单</a></li>
            <li><a href="/dcs/excel/select_list?code=30006&level=2" class="list-group-item">6.年度学生学籍异动情况汇总</a></li>
            <li><a href="/dcs/excel/select_list?code=30007&level=2" class="list-group-item">7.学生表彰名单（学工）</a></li>
            <li><a href="/dcs/excel/select_list?code=30008&level=2" class="list-group-item">8.教师表彰名单</a></li>
            <li><a href="/dcs/excel/select_list?code=30009&level=2" class="list-group-item">9.学期值班表</a></li>
            <li><a href="/dcs/excel/select_list?code=30010&level=2" class="list-group-item">10.年度辅导员、班主任测评汇总表</a></li>
            <li><a href="/dcs/excel/select_list?code=30011&level=2" class="list-group-item">11.就业质量年度报告</a></li>
            <li><a href="/dcs/excel/select_list?code=30012&level=2" class="list-group-item">12.学院讲座汇总表</a></li>
            <li><a href="/dcs/excel/select_list?code=30013&level=2" class="list-group-item">13.工作计划及总结</a></li>
            <li><a href="/dcs/excel/select_list?code=30014&level=2" class="list-group-item">14.新闻报道上传情况</a></li>
            <li><a href="/dcs/excel/select_list?code=30015&level=2" class="list-group-item">15.个人成果及获奖情况</a></li>
        </ul>
    </div>
</div>
<script src="/dcs/static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="/dcs/static/js/content.js" charset="utf-8"></script>
</body>
</html>
