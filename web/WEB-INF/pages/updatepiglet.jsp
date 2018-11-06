<%--
  Created by IntelliJ IDEA.
  User: y1ang
  Date: 2018.10.18
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <link rel="stylesheet" href="layui/css/layui.css" />
    <link rel="stylesheet" href="css/global.css" />
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_z7x5ppxb0ym.css" />
    <title>修改购买小猪记录</title>
</head>
<body>
<header class="layui-header layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                <a href="javascript:;" class="layui-icon layui-icon-left back" style="font-size: 22px;color: #fff;"></a>
            </div>
            <div class="text-middle layui-pull-center">
                <span>&nbsp;小猪明细 - 修改记录</span>
            </div>
        </div>
    </div>
</header>
<section style="margin-top: 35px;">
    <form method="post" class="layui-form layui-form-pane submit">
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">购买日期</label>
                <div class="layui-input-inline">
                    <input type="hidden" name="buyID" class="layui-input" value="${buy.buyID}"/>
                    <input type="text" name="buyDate" value="${buy.buyDate}" id="buyDate" class="layui-input" readonly="readonly" autocomplete="off" placeholder="请选择日期" lay-verify="buyDate" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">购买数量</label>
                <div class="layui-input-inline">
                    <input type="text" name="buyQuantity" value="${buy.buyQuantity}" class="layui-input" autocomplete="off" placeholder="请输入数量" required lay-verify="buyQuantity|number" lay-verType="msg"/>
                </div>
            </div>
        </div><br>

        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">购买价格</label>
                <div class="layui-input-inline">
                    <input type="text" name="buyPrice" value="${buy.buyPrice}" class="layui-input" autocomplete="off" placeholder="请输入购买价格" required lay-verify="buyPrice|number" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">超重价格</label>
                <div class="layui-input-inline">
                    <input type="text" name="beyondPrice" value="${buy.beyondPrice}" class="layui-input" autocomplete="off" placeholder="请输入超出标准重量价格" required lay-verify="beyondPrice" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">平均重量</label>
                <div class="layui-input-inline">
                    <input type="text" name="averageWeight" value="${buy.averageWeight}" class="layui-input" autocomplete="off" placeholder="请输入平均重量" required lay-verify="averageWeight" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">购买品种</label>
                <div class="layui-input-inline">
                    <input type="text" name="buyVariety" value="${buy.buyVariety}" class="layui-input" autocomplete="off" placeholder="请输入品种" required lay-verify="saleVariety" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">购买地址</label>
                <div class="layui-input-inline">
                    <input type="text" name="buyAddress" value="${buy.buyAddress}" class="layui-input" autocomplete="off" placeholder="请输入地址" required lay-verify="buyAddress" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">总金额</label>
                <div class="layui-input-inline">
                    <input type="text" name="totalMoney" value="${buy.totalMoney}" class="layui-input" autocomplete="off" placeholder="请输入总重量" required lay-verify="totalMoney|number" lay-verType="msg"/>
                </div>
            </div>
        </div>
        <div class="layui-btn-container layui-container" style="margin-top: 40px;">
            <hr class="layui-bg-gray">
            <button class="layui-btn layui-btn-radius layui-btn-lg layui-bg-liner layui-btn-fluid" lay-submit lay-filter="updatepiglet">立即修改</button>
        </div><br>
    </form>
</section>

<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element','laydate','form','layer'], function() {
        var element = layui.element,
            laydate = layui.laydate,
            form = layui.form,
            layer = layui.layer,
            $ = layui.jquery;

        laydate.render({
            elem:'#buyDate'
        });

        $(".back").click(function () {
            window.history.back(-1);
        });

        form.on("submit(updatepiglet)",function (data) {
            $.post("updatepiglet",data.field,function (result) {
                if(result == "OK"){
                    $("form")[0].reset();
                    layer.msg("修改成功",{time:1000},function(){window.history.back(-1);});
                    $(".layui-btn").addClass("layui-hide");
                }else{
                    layer.msg("修改失败,请稍后重试");
                }
            })
            return false;
        });

        form.verify({
            buyDate:function(value,item){
                if(value==""){
                    return "日期不能为空哦！";
                }
            },
            buyQuantity:function(value,item){
                if(value == ""){
                    return "请输入购买数量";
                }
                if(!new RegExp("^\\d*$/").test(value)){
                    return  '数量只能输入正整数';
                }
            },
            buyPrice:function(value,item){
                if(value == ""){
                    return '请输入购买价格';
                }
                if(!new RegExp("^\\d*\\.?\\d*?$").test(value)){
                    return "购买价格只能为数字";
                }
            },
            beyondPrice:function(value,item){
                if(value == ""){
                    return "请输入超出标准重量的价格";
                }
                if(!new RegExp("^\\d*\\.?\\d*?$").test(value)){
                    return "超出价格只能为数字";
                }
            },
            buyAddress:function(value,item){
                if(value == ""){
                    return "请输入购买地址";
                }
            },
            buyVariety:function(value,item){
                if(value==""){
                    return "请输入购买品种";
                }
            },
            totalMoney:function(value,item){
                if(value == ""){
                    return "总金额不能为空";
                }
            }
        });
    });
</script>
</body>
</html>