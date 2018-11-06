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
    <title>添加卖猪记录</title>
</head>
<body>
<header class="layui-header layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                <a href="javascript:;" class="layui-icon layui-icon-left back" style="font-size: 22px;color: #fff;"></a>
            </div>
            <div class="text-middle layui-pull-center">
                <span>&nbsp;卖猪详情 - 添加记录</span>
            </div>
        </div>
    </div>
</header>
<section style="margin-top: 35px;">
    <form method="post" class="layui-form layui-form-pane submit">
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="saleDate" id="saleDate" class="layui-input" readonly="readonly" autocomplete="off" placeholder="请选择日期" lay-verify="saleDate" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">数量</label>
                <div class="layui-input-inline">
                    <input type="text" name="saleQuantity" class="layui-input" autocomplete="off" placeholder="请输入数量" required lay-verify="saleQuantity|number" lay-verType="msg"/>
                </div>
            </div>
        </div><br>

        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">售价</label>
                <div class="layui-input-inline">
                    <input type="text" name="salePrice" class="layui-input" autocomplete="off" placeholder="请输入售价" required lay-verify="salePrice|number" lay-verType="msg"/>
                </div>
            </div>
        </div><br>

        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">品种</label>
                <div class="layui-input-inline">
                    <input type="text" name="saleVariety" class="layui-input" autocomplete="off" placeholder="请输入卖出品种" required lay-verify="saleVariety" lay-verType="msg"/>
                </div>
            </div>
        </div><br>
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">总重量</label>
                <div class="layui-input-inline">
                    <input type="text" name=totalWeight class="layui-input" autocomplete="off" placeholder="请输入总重量" required lay-verify="totalWeight|number" lay-verType="msg"/>
                </div>
            </div>
        </div>
        <div class="layui-btn-container layui-container" style="margin-top: 40px;">
            <hr class="layui-bg-gray">
            <button class="layui-btn layui-btn-radius layui-btn-lg layui-bg-liner layui-btn-fluid" lay-submit lay-filter="addsale">立即添加</button>
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
            elem:'#saleDate'
        });

        $(".back").click(function () {
            window.history.back(-1);
        });

        form.on("submit(addsale)",function (data) {
            $.post("addsale",data.field,function (result) {
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
            saleDate:function(value,item){
                if(value==""){
                    return "日期不能为空哦！";
                }
            },
            salePrice:function(value,item){
                if(value == ""){
                    return '请先输入售价';
                }
                if(!new RegExp("^\\d*\\.?\\d*?$").test(value)){
                    return "售价只能为数字";
                }
            },
            saleQuantity:function(value,item){
                if(value==""){
                    return "数量不能为空啊！";
                }
                if(!new  RegExp("^\\d*$").test(value)){
                    return "数量只能输入正整数";
                }
            },
            totalWeight:function(value,item){
            	if(value == ""){
            		return "总重量不能为空";
            	}
            }
        });
    });
</script>
</body>
</html>