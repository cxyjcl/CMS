<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料集锦管理系统</title>
    <link rel="stylesheet" href="../static/css/main.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="../static/css/change.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="nav">
    <ul>
        <li class="nav-active"><a href="/dcs/excel/select_limit">主页</a></li>
        <li><a href="/dcs/excel/student_office">学工办</a></li>
        <li><a href="/dcs/excel/subcommittee">分团委</a></li>
        <li><a href="/dcs/excel/counsellor">辅导员</a></li>
        <li><a href="/dcs/user/management">用户管理</a></li>
        <li><a href="/dcs/user/change">修改密码</a></li>
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
        <div class="title"><span class="text">修改主页</span></div>
    </div>
    <form class="form-horizontal user-form" role="form">
        <div class="form-group">
            <label class="col-sm-1 static control-label">电子邮箱</label>
            <div class="col-sm-3 static">
                <input type="text" class="form-control" placeholder="请输入电子邮箱">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 static control-label">密码</label>
            <div class="col-sm-3 static">
                <input type="text" class="form-control" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 static control-label">确认密码</label>
            <div class="col-sm-3 static">
                <input type="text" class="form-control" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-xs-offset-4">
                <button type="submit" class="btn btn-primary col-xs-6 col-sm-3 mgl-10">提交</button>
            </div>
        </div>
    </form>
</div>
<script src="../static/js/jquery-1.3.2.min.js"></script>
<script src="../static/js/user.js" charset="utf-8"></script>
<script src="../static/js/content.js" charset="utf-8"></script>
</body>
</html>