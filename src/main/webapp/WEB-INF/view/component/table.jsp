<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <li class="out"><a href="/dcs/exit" id="log-out">注销</a></li>
            <c:if test="${sessionScope.user ne null}">
            	<li id="username">${sessionScope.username}</li>
            </c:if>
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
        <form id="excel-form" name="excel-form" encType="multipart/form-data" method="post" >
	        <div class="pull-right mg-5">
				<button type="button" class="btn btn-info" id="upload">上传文件</button>
	        </div>
	        <div class="pull-right mg-5">
				<a href="javascript:;" class="file">选择文件
				    <input type="file" name="excel" id="excel">
				</a>
	        </div>
	    </form>
        <div class="pull-right mg-5">
            <button type="button" class="btn btn-info" id="download">下载模板</button>
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
                    <th>表格名字</th>
                    <th>提交人</th>
                    <th>提交时间</th>
                    <th>修改人</th>
                    <th>修改时间</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
              <c:forEach items="${list}" var="info">
                <tr id="${info.id}">
                    <td><a href="/dcs/excel/select_info?code=${info.listId}&id=${info.infoId}">${info.excelName}</a></td>
                    <td>${info.creator}</td>
                    <td><fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd"/></td>
               		<td>${info.reviser}</td>
               		<td><fmt:formatDate value="${info.reviseTime}" pattern="yyyy-MM-dd"/></td>
                	<td><input type="checkbox"/></td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
        <c:if test="${page.totalSize!=0}">
        	<div class="page">
	        	<ul class="pagination">
	               <c:choose>
	               		<c:when test="${page.pageEnd<=10}">
	               			<c:set var="begin" value="1"></c:set>
	               			<c:set var="end" value="${page.pageEnd}"></c:set>
	               		</c:when>
	               		<c:otherwise>
	               			<c:set var="begin" value="${page.pageIndex-4}"></c:set>
	               			<c:set var="end" value="${page.pageIndex+5}"></c:set>
		               <c:if test="${begin<1}">
		    				<c:set var="begin" value="1"/>
		    				<c:set var="end" value="10"/>
		               </c:if>
		               <c:if test="${end>page.pageEnd}">
		    				<c:set var="begin" value="${page.pageEnd-9}"/>
		    				<c:set var="end" value="${page.pageEnd}"/>
		               </c:if>
	               </c:otherwise>
	             </c:choose>
	              		<c:if test="${page.pageIndex==1}">
	                    	<li><a href="#" >&laquo;</a></li>              		
	               		</c:if>
	                   <c:if test="${page.pageIndex!=1}">
	                    	<li><a href="/dcs/select_info?pageIndex=${page.pageIndex-1}" >&laquo;</a></li>
	               		</c:if>
			        		<c:forEach begin="${begin}" end="${end}" var="i">
			        		<c:choose>
			        			<c:when test="${i eq page.pageIndex}">
			        				 <li><a href="#" class="nowpage">${i}</a></li>
			        			</c:when>
			        			<c:otherwise>
			        			    	<li><a href="/dcs/select_info?pageIndex=${i}">${i}</a></li>
			        			</c:otherwise>
			        		</c:choose>
			        		</c:forEach>
	        		<c:if test="${page.pageIndex==page.pageEnd}">
	        			<li><a href="#">&raquo;</a></li>
	        		</c:if>
	        		<c:if test="${page.pageIndex!=page.pageEnd}">
	           			<li><a href="/dcs/select_info?pageIndex=${page.pageIndex+1}">&raquo;</a></li>     				
	        		</c:if>
	             </ul>
        	</div>
        </c:if>
    </div>
</div>
<script src="../static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="../static/js/content.js" charset="utf-8"></script>
<script src="../static/js/table.js" charset="utf-8"></script>
</body>
</html>
