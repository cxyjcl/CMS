<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料集锦管理系统</title>
    <link rel="stylesheet" href="../static/css/main.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="nav">
    <ul>
        <li class="nav-active"><a href="/dcs/excel/select_limit">主页</a></li>
        <li><a href="/dcs/excel/student_office">学工办</a></li>
        <li><a href="/dcs/excel/subcommittee">分团委</a></li>
        <li><a href="/dcs/excel/counsellor">辅导员</a></li>
        <li><a href="/dcs/management">用户管理</a></li>
        <li><a href="/dcs/change">修改密码</a></li>
    </ul>
</div>
<div class="header">
    <div class="logo">
        <img src="../static/img/logo.png" height="45"/>
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
    <div class="group" id="group">
        <ul class="list-group">
            <li><a href="/dcs/excel/select_list?code=10001&level=2" class="list-group-item">1.年级信息</a></li>
            <li><a href="/dcs/excel/select_list?code=10002&level=2" class="list-group-item">2.班级信息</a></li>
            <li><a href="/dcs/excel/select_list?code=30001&level=2" class="list-group-item">2.班主任人员名单</a></li>
            <li><a href="/dcs/excel/select_list?code=30002&level=2" class="list-group-item">3.本学期发文文件</a></li>
            <li><a href="/dcs/excel/select_list?code=10003&level=2" class="list-group-item">4.本学期党员转正、预备党员积极分子、上党课学生汇总名单</a></li>
            <li><a href="/dcs/excel/select_list?code=10007&level=2" class="list-group-item">5.各类奖助学金汇总名单</a></li>
            <li><a href="/dcs/excel/select_list?code=20002&level=2" class="list-group-item">6.学生表彰名单（学工）</a></li>
            <li><a href="/dcs/excel/select_list?code=30003&level=2" class="list-group-item">7.教师表彰名单</a></li>
            <li><a href="/dcs/excel/select_list?code=30004&level=2" class="list-group-item">8.学期值班表</a></li>
            <li><a href="/dcs/excel/select_list?code=30005&level=2" class="list-group-item">9.年度辅导员、班主任测评汇总表</a></li>
            <li><a href="/dcs/excel/select_list?code=30006&level=2" class="list-group-item">10.就业质量年度报告</a></li>
            <li><a href="/dcs/excel/select_list?code=10010&level=2" class="list-group-item">11.学院讲座汇总表</a></li>
            <li><a href="/dcs/excel/select_list?code=10011&level=2" class="list-group-item">12.工作计划及总结</a></li>
            <li><a href="/dcs/excel/select_list?code=30007&level=2" class="list-group-item">13.新闻报道上传情况</a></li>
            <li><a href="/dcs/excel/select_list?code=10013&level=2" class="list-group-item">14.个人成果及获奖情况</a></li>
        </ul>
    </div>
</div>
<script src="../static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="../static/js/content.js" charset="utf-8"></script>
</body>
</html>
