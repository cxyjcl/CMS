<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料集锦系统登录界面</title>
    <link href="/dcs/static/css/login.css" rel="stylesheet"/>
</head>
<body>
<!--导航栏-->
<div class="header">
        <div class="logo">
            <img src="/dcs/static/img/logo.png" height="45"/>
        </div>
</div>
<!--body1登录界面-->
<div class="login" id="login">
    <form>
        <h2>登录界面</h2>
        <div id="errorMessage">&nbsp;</div>
        <input type="text" class="input w-100" id="username" placeholder="用户名">
        <input type="password" class="input w-100" id="password" placeholder="密码">
        <input type="text" class="input w-30" id="verifyCode" placeholder="验证码">
        <img src="/dcs/verify_code" id="verify_img"/>
        <a href="#" id="change">看不清,换一张</a>
        <a id="submitButton" class="btn btn-100">登录</a>
    </form>
    <div class="login-footer">
        <a id="forget-a">忘记密码</a>
    </div>
</div>
<!--body2忘记密码-->
<div class="forget hide" id="forget">
    <form>
        <h2>忘记密码</h2>
        <div id="findErrorMessage">&nbsp;</div>
        <input type="text"  class="input w-100" id="find_user" placeholder="用户名">
        <div class="block"><input type="text"  class="input w-100" id="forget_code" placeholder="验证码"></div>
        <div class="block text"><button type="button"  id="send" class="button">发送验证码</button></div>
        <input type="password"  class="input w-100" id="new_password" placeholder="重置密码">
        <input type="password"  class="input w-100" id="renew_password" placeholder="重置密码">
        <a  id="findButton" class="btn btn-100">重置密码</a>
    </form>
    <div class="login-footer">
        <a id="login-a">登录界面</a>
    </div>
</div>
<script src="/dcs/static/js/jquery-1.3.2.min.js"></script>
<script src="/dcs/static/js/login.js"></script>
</body>
</html>
