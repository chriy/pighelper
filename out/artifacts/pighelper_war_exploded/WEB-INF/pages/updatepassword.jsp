<%--
  Created by IntelliJ IDEA.
  User: stark
  Date: 2018.10.26
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_z7x5ppxb0ym.css"/>
    <title></title>
</head>
<body>
<header class="layui-header layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                <a href="javascript:;" class="layui-icon layui-icon-left back" style="font-size: 22px;color: #fff;"></a>
            </div>
            <div class="text-middle layui-pull-center">
                <span>&nbsp;修改用户密码</span>
            </div>
        </div>
    </div>
</header>
<section style="margin-top: 35px;">
    <form method="post" class="layui-form layui-form-pane submit">
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">旧密码</label>
                <div class="layui-input-inline">
                    <input type="hidden" value="${UserSession.userId}" name="userId">
                    <input type="password" name="oldPwd" class="layui-input" autocomplete="off" required lay-verify="required" placeholder="请输入原密码"/>
                </div>
            </div>
        </div>
        <br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="newPwd" class="layui-input" autocomplete="off" required lay-verify="required" placeholder="请输入新密码"/>
                </div>
            </div>
        </div>
        <br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="confirmPwd" class="layui-input" autocomplete="off" required lay-verify="required" placeholder="请确认新密码"/>
                </div>
            </div>
        </div>
        <br>
        <div class="layui-btn-container layui-container" style="margin-top: 40px;">
            <hr class="layui-bg-gray">
            <button class="layui-btn layui-btn-radius layui-btn-lg layui-bg-liner layui-btn-fluid" lay-submit
                    lay-filter="updatepassword">立即修改
            </button>
        </div>
        <br>
    </form>
</section>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element', 'form', 'layer'], function () {
        var element = layui.element,
            form = layui.form,
            layer = layui.layer,
            $ = layui.jquery;


        $(".back").click(function () {
            window.history.back(-1);
        });

        form.on("submit(updatepassword)", function (data) {
            if($("input[name='newPwd']").val()!=$("input[name='confirmPwd']").val()){
                layer.msg("两次输入密码不一致");
            }else{
                $.post("updatepassword", data.field, function (result) {
                    if (result == "OK") {
                        $("form")[0].reset();
                        layer.msg("修改成功", {time: 1000}, function () {
                            window.history.back(-1);
                        });
                        $(".layui-btn").addClass("layui-hide");
                    }else if(result == "ERROR"){
                        layer.msg("原密码错误！");
                    }else if(result =="CHECK"){
                        layer.msg("两次输入密码不一致");
                    }else {
                        layer.msg("修改失败,请稍后重试");
                    }
                })
            }
            return false;
        });
    })
</script>
</body>
</html>
