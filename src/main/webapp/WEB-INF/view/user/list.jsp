<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料集锦管理系统</title>
    <link rel="stylesheet" href="../static/css/user.css" media="screen" title="no title" charset="utf-8">
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
        <div>
            <div class="title"><a class="text" href="/dcs/management">创建用户</a></div>
            <div class="title"><a class="text" href="/dcs/get/user">用户列表</a></div>
        </div>
    </div>
    <div>
        <div class="clearfix">
            <div class="pull-right mg-5">
                <button type="button" class="btn btn-danger">删除</button>
            </div>
            <div class="pull-right mg-5">
                <button type="button" class="btn btn-info">全选</button>
            </div>
            <div class="pull-right mg-5">
                <div class="input-group static w-220">
                    <input type="text" class="form-control static" placeholder="按名字搜索">
                    <span class="input-group-btn static">
                 <button class="btn btn-info static" type="button"><span class="glyphicon glyphicon-search static"></span></button>
             </span>
                </div>
            </div>
        </div>
        <div class="group">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>邮箱</th>
                    <th>登录名</th>
                    <th>真实名</th>
                    <th>提交人</th>
                    <th>提交时间</th>
                    <th>修改人</th>
                    <th>修改时间</th>      
                    <th>状态</th>                                                  
                    <th>删除</th>
                    <th>修改</th>
                </tr>
                </thead>
                <tbody>
                <script>console.log("${list}")</script>
	             <c:forEach items="${list}" var="user">
	                <tr>
	                    <td>${user.email}</td>
	                    <td>${user.loginName}</td>
	                    <td>${user.realName}</td>
	                    <td>${user.creator}</td>
	                    <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/></td>
	               		<td>${user.reviser}</td>
	               		<td><fmt:formatDate value="${user.reviserTime}" pattern="yyyy-MM-dd"/></td>
	               		<c:if test="${user.dataStatus eq '000'}">
	               			<td class="red">删除</td>
	               		</c:if>
	               		<c:if test="${user.dataStatus eq '001'}">
	               			<td>创建</td>
	               		</c:if>
	               		<td><input type="checkbox"/></td>
                    	<td><button type="button" class="btn-danger pd-5" data-toggle="modal" data-target="#myModal">更改</button></td>
	                </tr>
	              </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-3 col-sm-offset-1 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 col-sm-offset-1 control-label">真实名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" placeholder="请输入真实姓名">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script src="../static/js/jquery-1.3.2.min.js"></script>
<script src="../static/js/user.js" charset="utf-8"></script>
<script src="../static/js/content.js" charset="utf-8"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
