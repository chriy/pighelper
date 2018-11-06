<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_nlehfxfast.css"/>
    <title></title>
    <style>input {
        border: none !important;
        color: #FF5722
    }</style>
</head>
<body class="layui-body-background">
<header class="layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div style="line-height:60px;font-size:18px;text-align:center;" class="layui-pull-left">
                <span class="main-title">
                    <i class="layui-icon layui-icon-release" style="font-size: 22px;"></i> 设置
               </span>
            </div>
        </div>
    </div>
</header>
<section>
    <div>
        <dl class="more-set">
            <dd>
                <a href="javascript:;">
                    <div style="height: 60px;margin: 20px 0px; background-color: #fff;padding: 5px 20px;">
                        <div class="head-pic">
                            <img src="img/f0554d758828564268b739662ecc1525.jpg" width="60px" height="60px"
                                 style="border-radius: 50%;"/>
                        </div>
                        <div id="acount">
                            <p><span>用户名：${UserSession.userName}</span><br></p>
                            <p><span>身&emsp;份：<span class="layui-badge layui-bg-green">管理员</span></span></p>
                        </div>
                    </div>
                </a>
            </dd>
            <dd>
                <div class="item addBatch">
                    <h5><i class="layui-icon layui-icon-add-1"></i>&emsp;添加批次</h5>
                </div>
            </dd>
            <dd style="position:relative;margin-top:20px;">
                <a href="javascript:;" class="switchBatch">
                    <div class="item border">
                        <i class="layui-icon layui-icon-senior"></i>&emsp;当前批次
                        <form class="layui-form" style="position:absolute;top:6px;left:130px;">
                            <div class="layui-input-inline">
                                <select>
                                    <option value="" <c:if test='${empty activeBatch}'>selected</c:if>>切换批次</option>
                                    <c:forEach items="${batch }" var="b">
                                        <option value="${b.batchNumber }"<c:if test='${b.batchNumber==activeBatch }'>selected</c:if>><span>第 ${b.batchNumber} 批</span></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </form>
                    </div>
                </a>
            </dd>
            <dd>
                <a href="batchmanager">
                    <div class="item border">
                        <h5><i class="layui-icon layui-icon-note"></i>&emsp;管理批次</h5>
                    </div>
                </a>
            </dd>
            <dd>
                <a href="updatepassword.html">
                    <div class="item updatePassword border">
                        <h5><i class="layui-icon layui-icon-util"></i>&emsp;修改密码</h5>
                    </div>
                </a>
            </dd>
            <dd>
                <a href="about.html">
                    <div class="item">
                        <h5><i class="layui-icon layui-icon-about"></i>&emsp;关于助手</h5>
                    </div>
                </a>
            </dd>
            <dd style="margin:20px 0px 75px 0px;">
                <div class="item signout">
                    <h5><i class="iconfont icon-exit"></i>&emsp;退出登录</h5>
                </div>
            </dd>
        </dl>
    </div>
</section>
<footer>
    <div class="footer-nav">
        <a href="index.html">
            <i class="iconfont icon-shouye" style="font-size: 20px;"></i><br/>
            <span>首页</span>
        </a>
        <a href="count.html">
            <i class="iconfont icon-tongji" style="font-size: 20px;"></i><br/>
            <span>统计</span>
        </a>
        <a href="prices.html">
            <i class="iconfont icon-jiage" style="font-size: 20px;"></i><br/>
            <span>猪价</span>
        </a>
        <a href="setting.html" class="on-this">
            <i class="iconfont icon-shezhichilun" style="font-size: 20px;"></i><br/>
            <span>设置</span>
        </a>
    </div>
</footer>

<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element', 'form', 'layer'], function () {
        var form = layui.form,
            element = layui.element,
            $ = layui.jquery,
            layer = layui.layer;

        $(".footer-nav").click(function () {
            layer.open({type: 3});
        });

        form.render();

        $(".addBatch").click(function () {
            layer.confirm("  提示：所有新增数据都将属于下一批。是否添加", {title: "添加新批次", icon: 3, area: "280px"}, function (index) {
                $.post("addbatch", function (data) {
                    if (data == "OK") {
                        layer.msg("添加成功", {anim: 2, time: 1000}, function () {
                            window.location.reload();
                        });
                    } else {
                        layer.msg("添加失败");
                    }
                });
            });
        });

        $(".updatePassword").click(function () {
            //layer.msg("您暂时还不能修改密码，请联系管理员");
        });

        $(".signout").click(function () {
            layer.confirm("确认退出登录?", {icon: 3}, function (index) {
                window.location.href = "signout";
                layer.close(index);
            })
        });

        form.on("select", function (data) {
            $.post("switchBatch", {batchNumber: data.value}, function (result) {
                if (result == "OK") {
                    layer.msg("切换成功", {time: 1000});
                    form.render();
                } else {
                    layer.msg("切换失败，请稍后重试");
                }
            });
        });
    });
</script>
</body>
</html>
