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
        <li><a href="/dcs/excel/counsellor">辅导员</a></li>
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
        <div class="title">整体浏览页 > 列表信息 > 详情信息</div>
    </div>
    <div class="clearfix" id="${code}">
        <div class="pull-right mg-5" id="${infoId}">
            <button type="button" class="btn btn-danger" id="download">下载</button>
        </div>
        <div class="pull-right mg-5">
            <a type="button" href="/dcs/excel/select_info?code=${code}&level=${level}" class="btn btn-danger">返回</a>
        </div>
    </div>
    <div class="group">
        <table class="table table-striped" id="${code}">
            <caption class="text-center">${title}</caption>
            <thead>
            	<tr>
             <c:forEach items="${mapVo.mapString}" var="map">
                  <th>${map.value}</th>
              </c:forEach>
                </tr>
            </thead>
            <tbody>
              <c:forEach items="${mapVo.mapList}" var="info">
                <tr id="${info.id}">
                	<c:forEach items="${info}" var="item">
                		<c:if test="${item.key ne 'id' &&item.key ne 'info_id' && item.key ne 'data_status'}">
			                <td class="${item.key}">
		                		<a tabindex="0" role="button" data-toggle="popover" data-placement="top" data-toggle="popover" data-content="<div class='row change-div'><div class='col-sm-9 col-xs-9'><input type='text' class='form-control' placeholder='请输入姓名'/></div><div class='col-sm-1 md-1'><button type='button' class='btn btn-primary' onclick=change(this)>√</button></div></div>">${item.value}</a>
			                </td>
		                </c:if>
	                </c:forEach>
                </tr>
              </c:forEach>
            </tbody>
        </table>
        <c:if test="${mapVo.totalSize!=0}">
        	<div class="page">
	        	<ul class="pagination">
	               <c:choose>
	               		<c:when test="${mapVo.pageEnd<=10}">
	               			<c:set var="begin" value="1"></c:set>
	               			<c:set var="end" value="${mapVo.pageEnd}"></c:set>
	               		</c:when>
	               		<c:otherwise>
	               			<c:set var="begin" value="${mapVo.pageIndex-4}"></c:set>
	               			<c:set var="end" value="${mapVo.pageIndex+5}"></c:set>
		               <c:if test="${begin<1}">
		    				<c:set var="begin" value="1"/>
		    				<c:set var="end" value="10"/>
		               </c:if>
		               <c:if test="${end>mapVo.pageEnd}">
		    				<c:set var="begin" value="${mapVo.pageEnd-9}"/>
		    				<c:set var="end" value="${mapVo.pageEnd}"/>
		               </c:if>
	               </c:otherwise>
	             </c:choose>
	              		<c:if test="${mapVo.pageIndex==1}">
	                    	<li><a href="#" >&laquo;</a></li>              		
	               		</c:if>
	                   <c:if test="${mapVo.pageIndex!=1}">
	                    	<li><a href="/dcs/excel/select_info?code=${code}&level=${level}&id=${infoId}&pageIndex=${mapVo.pageIndex-1}" >&laquo;</a></li>
	               		</c:if>
			        		<c:forEach begin="${begin}" end="${end}" var="i">
			        		<c:choose>
			        			<c:when test="${i eq mapVo.pageIndex}">
			        				 <li><a href="#" class="nowpage">${i}</a></li>
			        			</c:when>
			        			<c:otherwise>
			        			    	<li><a href="/dcs/excel/select_info?code=${code}&level=${level}&id=${infoId}&pageIndex=${i}">${i}</a></li>
			        			</c:otherwise>
			        		</c:choose>
			        		</c:forEach>
	        		<c:if test="${mapVo.pageIndex==mapVo.pageEnd}">
	        			<li><a href="#">&raquo;</a></li>
	        		</c:if>
	        		<c:if test="${mapVo.pageIndex!=mapVo.pageEnd}">
	           			<li><a href="/dcs/excel/select_info?code=${code}&level=${level}&id=${infoId}&pageIndex=${mapVo.pageIndex+1}">&raquo;</a></li>     				
	        		</c:if>
	             </ul>
        	</div>
        </c:if>
    </div>
</div>
<script src="/dcs/static/js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script src="/dcs/static/js/content.js" charset="utf-8"></script>
<script src="/dcs/static/js/bootstrap.min.js"></script>
<script src="/dcs/static/js/info.js" charset="utf-8"></script>
</body>
</html>
