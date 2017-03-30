<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料集锦管理系统</title>
    <link rel="stylesheet" href="../../static/css/main.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="nav">
    <ul>
        <li><a href="default.html">主页</a></li>
        <li><a href="student_office.html">学工办</a></li>
        <li class="nav-active"><a href="subcommittee.html">分团委</a></li>
        <li><a href="counsellor.html">辅导员</a></li>
        <li><a href="../user/user.html">用户管理</a></li>
        <li><a href="../user/change.html">修改密码</a></li>
    </ul>
</div>
<div class="header">
    <div class="logo">
        <img src="../../static/img/logo.png" height="45"/>
    </div>
    <div class="tool">
        <ul>
            <li class="out"><a href="#" id="log-out">注销</a></li>
            <li id="username">admin</li>
        </ul>
    </div>
</div>
<div id="container" class="container">
    <div class="warp">
        <div class="title"><span class="text">整体浏览页</span></div>
    </div>
    <div class="group">
        <ul class="list-group">
            <a href="#" class="list-group-item">1.分团委、学生会、协会人员名单</a>
            <a href="#" class="list-group-item">2.学生荣誉名单（团委）</a>
            <a href="#" class="list-group-item">3.各种学科竞赛获奖名单</a>
            <a href="#" class="list-group-item">4.各种校园文化活动获奖名单</a>
            <a href="#" class="list-group-item">5.学期开展活动汇总表及方案</a>
            <a href="#" class="list-group-item">6.工作计划及总结</a>
            <a href="#" class="list-group-item">7.个人成果及获奖情况</a>
        </ul>
    </div>
</div>
<script src="../../static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="../../static/js/content.js" charset="utf-8"></script>
</body>
</html>
