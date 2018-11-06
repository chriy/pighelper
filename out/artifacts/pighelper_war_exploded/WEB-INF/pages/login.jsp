<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_oo76d01a1rq.css"/>
    <title></title>
</head>
<body>
<div class="login-body">
    <div class="layui-container">
        <div class="layui-tab-content">
            <h1 class="site-h1 text-middle"><img src="img/logo.jpeg" width="65px" height="65px"
                                                 style="border-radius: 50%"></h1>
            <form class="layui-form" action="signin" method="post">
                <div class="layui-form-item">
                    <div class="layui-row">
                        <span class="icon layui-icon layui-icon-username"></span>
                        <input type="text" name="username" id="username" class="layui-input-yj" autocomplete="off"
                               placeholder="手机号/邮箱"/>
                    </div>
                </div>
                <div class="layui-form-item" style="margin-top: 20px;position:relative;">
                    <div class="layui-row">
                        <span class="icon layui-icon layui-icon-password"></span>
                        <input type="password" name="pwd" id="pwd" class="layui-input-yj" autocomplete="off"
                               placeholder="输入密码"/>
                        <span class="show-pwd iconfont icon-xianshi" style="font-size: 24px"></span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <input type="checkbox" class="rememberme" title="记住密码" lay-skin="primary">
                    <input type="checkbox" class="layui-input" name="auto_login" title="自动登录" lay-skin="primary">
                </div>
            </form>
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn layui-btn-fluid layui-btn-radius">登录</button>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <p>&copy; 2018 Copyright All rights reserved</p>
    <p>猪猪帮手 版权所有</p>
</div>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/signin.js"></script>
</body>
</html>