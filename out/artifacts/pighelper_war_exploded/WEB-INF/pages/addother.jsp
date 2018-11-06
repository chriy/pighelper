<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <link rel="stylesheet" href="layui/css/layui.css" />
    <link rel="stylesheet" href="css/global.css" />
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_z7x5ppxb0ym.css" />
    <title>添加其他记录</title>
</head>
<body>
<header class="layui-header layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                <a href="javascript:;" class="layui-icon layui-icon-left back" style="font-size: 22px;color: #fff;"></a>
            </div>
            <div class="text-middle layui-pull-center">
                <span>&nbsp;其他收支 - 添加记录</span>
            </div>
        </div>
    </div>
</header>
<section style="margin-top: 35px;">
    <form action="" class="layui-form layui-form-pane submit">
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="recordDate" id="recordDate" class="layui-input" readonly="readonly" autocomplete="off" placeholder="请选择日期" lay-verify="recordDate" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">详细记录</label>
                <div class="layui-input-inline">
                    <input type="text" name="recordDetails" class="layui-input" autocomplete="off" placeholder="请输入详细记录" required lay-verify="recordDetails" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">金额总数</label>
                <div class="layui-input-inline">
                    <input type="text" name="recordMoney" class="layui-input" autocomplete="off" placeholder="请输入总数" required lay-verify="recordMoney" lay-verType="msg"/>
                </div>
            </div>
        </div>
        <div class="layui-btn-container layui-container" style="margin-top: 40px;">
            <hr class="layui-bg-gray">
            <button class="layui-btn layui-btn-radius layui-btn-lg layui-bg-liner layui-btn-fluid" lay-submit lay-filter="addother">立即添加</button>
        </div>
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
                elem:'#recordDate'
            });

            $(".back").click(function () {
                window.history.back(-1);
            });

            form.on("submit(addother)",function (data) {
                $.post("addother",data.field,function (result) {
                    if(result == "OK"){
                        $("form")[0].reset();
                        layer.msg("添加成功",{time:1000},function(){window.history.back(-1);});
                        $(".layui-btn").addClass("layui-hide");
                    }else{
                        layer.msg("添加失败,请稍后重试");
                    }
                })
                return false;
            });

            form.verify({
                recordDate:function(value,item){
                    if(value==""){
                        return "日期不能为空哦！"
                    }
                },
                recordDetails:function(value,item){
                    if(value==""){
                        return "详细记录你得填点东西啊！"
                    }
                },
                recordMoney:function(value,item){
                    if(value==""){
                        return "总数不能为空啊！"
                    }
                    if(!new RegExp("^\\d*\\.?\\d*?$").test(value)){
                        return "金额总数只能为正数";
                    }
                }
            });

        });
</script>
</body>
</html>