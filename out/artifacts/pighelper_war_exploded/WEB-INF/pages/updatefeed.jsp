<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <link rel="stylesheet" href="layui/css/layui.css" />
    <link rel="stylesheet" href="css/global.css" />
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_z7x5ppxb0ym.css" />
    <title></title>
</head>
<body>
<header class="layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                <a href="javascript:;" class="back layui-icon layui-icon-left" style="font-size: 22px;color: #fff;"></a>
            </div>
            <div class="text-middle layui-pull-center">
                <span>&nbsp;饲料账单 - 修改记录</span>
            </div>
        </div>
    </div>
</header>
<section style="margin-top: 35px;">
    <form method="post" class="layui-form layui-form-pane edit">
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">配送日期</label>
                <div class="layui-input-inline">
                	<input type="hidden" name="feedID" value="${feed.feedID }"/>
                    <input type="text" name="sendDate" value="${feed.sendDate }" id="date_time" class="layui-input" readonly="readonly" autocomplete="off" placeholder="请选择日期" lay-verify="sendDate" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">配送数量</label>
                <div class="layui-input-inline">
                    <input type="text" name="feedQuantity" value="${feed.feedQuantity }" class="layui-input" autocomplete="off" placeholder="请输入数量" lay-verify="feedQuantity" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">饲料单价</label>
                <div class="layui-input-inline">
                    <input type="text" name="feedPrice" value="${feed.feedPrice }" class="layui-input" autocomplete="off" placeholder="请输入单价" lay-verify="feedPrice" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">支付状态</label>
                <div class="layui-input-block">
                    <select name="feedPayState" lay-verify="required|feedPayState" lay-verType="msg">
                        <option value="">请选择支付状态</option>
                        <option value="已支付" <c:if test="${feed.feedPayState=='已支付' }">selected</c:if>>已支付</option>
                        <option value="未支付" <c:if test="${feed.feedPayState=='未支付' }">selected</c:if>>未支付</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-btn-container layui-container" style="margin-top: 40px;">
            <hr class="layui-bg-gray">
            <button class="layui-btn layui-btn-radius layui-btn-lg layui-bg-liner layui-btn-fluid" lay-submit lay-filter="edit">修改</button>
        </div>
    </form>
</section>

<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element','laydate','form','util','layer'], function() {
        var element = layui.element,
            laydate = layui.laydate,
            form = layui.form,
            util = layui.util,
            $ = layui.jquery,
            layer = layui.layer;
		
        layer.config({anim:0});
        
        laydate.render({
            elem:'#date_time'
        });

        $(".back").click(function(){
            window.history.back(-1);
        });//提交
        form.on('submit(edit)',function(data){
            $.post("updatefeed",data.field,function(result){
                 if(result=="OK"){
                	 $(".layui-btn").addClass("layui-hide");
                	 layer.msg("修改成功",{time:1000},function(){window.history.back(-1);});
                 }else{
                	 layer.msg("修改失败,请稍后重试");
                 }
            });
            return false;
        });
        form.verify({
            sendDate:function(value,item){
                if(value == ""){
                    return '请先选择日期';
                }
            },
            feedQuantity:function(value,item){
                if(value == ""){
                    return '请先输入数量';
                }
                if(!new RegExp("^\\d*$").test(value)){
                    return  '数量只能输入正整数';
                }
            },
            feedPrice:function (value,item) {
                if(value == ""){
                    return '请先输入饲料单价';
                }
                if(!new RegExp("^\\d*\\.?\\d*?$").test(value)){
                    return "价格只能输入数字";
                }
            },
            feedPayState:function(value,item){
                if(value == ""){
                    return "请先选择支付状态";
                }
            }
        });
    });
</script>
</body>
</html>
