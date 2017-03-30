<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料集锦管理系统</title>
    <link rel="stylesheet" href="../../static/css/user.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="../../static/css/main.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="nav">
    <ul>
        <li><a href="../component/default.html">主页</a></li>
        <li><a href="../component/student_office.html">学工办</a></li>
        <li><a href="../component/subcommittee.html">分团委</a></li>
        <li><a href="../component/counsellor.html">辅导员</a></li>
        <li><a href="user.html">用户管理</a></li>
        <li><a href="change.html">修改密码</a></li>
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
        <div>
            <div class="title"><a class="text" href="#" id="create_btn">创建用户</a></div>
            <div class="title"><a class="text" href="#" id="update_btn">更新用户</a></div>
        </div>
    </div>
    <div id="create">
        <form class="form-horizontal user-form" role="form">
            <div class="form-group">
                <label class="col-sm-1 static control-label">电子邮箱</label>
                <div class="col-sm-3 static">
                    <input type="text" class="form-control" placeholder="请输入电子邮箱">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 static control-label">登录名</label>
                <div class="col-sm-3 static">
                    <input type="text" class="form-control" placeholder="请输入登录名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 static control-label">密码</label>
                <div class="col-sm-3 static">
                    <input type="text" class="form-control" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 static control-label">真实姓名</label>
                <div class="col-sm-3 static">
                    <input type="text" class="form-control" placeholder="请输入真实姓名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 static control-label">所属部门</label>
                <div class="col-sm-3 static">
                    <select class="form-control">
                        <option value="">辅导员</option>
                        <option value="">学工办</option>
                        <option value="">分团委</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-xs-offset-4">
                    <button type="submit" class="btn btn-primary col-xs-6 col-sm-3 mgl-10">提交</button>
                </div>
            </div>
        </form>
    </div>
    <div id="update">
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
                    <th>序号</th>
                    <th>登录名</th>
                    <th>真实名</th>
                    <th>提交时间</th>
                    <th>删除</th>
                    <th>修改</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>admin</td>
                    <td>admin</td>
                    <td>2017/3/14</td>
                    <td><input type="checkbox"/></td>
                    <td><button type="button" class="btn-danger pd-5" data-toggle="modal" data-target="#myModal">更改</button></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>admin</td>
                    <td>admin</td>
                    <td>2017/3/14</td>
                    <td><input type="checkbox"/></td>
                    <td><button type="button" class="btn-danger pd-5">更改</button></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>admin</td>
                    <td>admin</td>
                    <td>2017/3/14</td>
                    <td><input type="checkbox"/></td>
                    <td><button type="button" class="btn-danger pd-5" >更改</button></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>admin</td>
                    <td>admin</td>
                    <td>2017/3/14</td>
                    <td><input type="checkbox"/></td>
                    <td><button type="button" class="btn-danger pd-5" >更改</button></td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>admin</td>
                    <td>admin</td>
                    <td>2017/3/14</td>
                    <td><input type="checkbox"/></td>
                    <td><button type="button" class="btn-danger pd-5" >更改</button></td>
                </tr>
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
<script src="../../static/js/jquery-1.3.2.min.js"></script>
<script src="../../static/js/user.js" charset="utf-8"></script>
<script src="../../static/js/content.js" charset="utf-8"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
