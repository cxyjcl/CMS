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
        <li><a href="subcommittee.html">分团委</a></li>
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
    <div class="warp clearfix">
        <div class="title"><span class="text"><a href="counsellor.html">整体浏览页</a> > 列表信息</span></div>
        <!--<div class="title pull-right text">-->
            <!--<span class="glyphicon glyphicon-arrow-left"></span>-->
            <!--<a id="back" href="#">返回</a>-->
        <!--</div>-->
    </div>
    <div class="clearfix">
        <div class="pull-right mg-5">
            <button type="button" id="delete" class="btn btn-danger">删除</button>
        </div>
        <div class="pull-right mg-5">
            <button type="button" id="all" class="btn btn-info">全选</button>
        </div>
        <div class="pull-right mg-5">
            <button type="button" class="btn btn-info">上传</button>
        </div>
        <div class="pull-right mg-5 static">
            <div class="input-group w-220 static">
                <input type="text" class="form-control static" placeholder="搜索表格名字或提交人">
                <span class="input-group-btn static">
                 <button class="btn btn-info static" type="button"><span class="glyphicon static glyphicon-search"></span></button>
             </span>
            </div>
        </div>
    </div>
    <div class="group">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>序号</th>
                <th>表格名字</th>
                <th>提交人</th>
                <th>提交时间</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td><a href="info.html">学期学生情况一览表</a></td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>2</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>3</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>4</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>5</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>6</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>7</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>8</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>9</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            <tr>
                <td>10</td>
                <td>学期学生情况一览表</td>
                <td>admin</td>
                <td>2017/3/14</td>
                <td><input type="checkbox"/></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="../../static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="../../static/js/content.js" charset="utf-8"></script>
<script src="../../static/js/table.js" charset="utf-8"></script>
</body>
</html>
