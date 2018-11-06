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
                <span>&nbsp;疫苗接种 - 添加记录</span>
            </div>
        </div>
    </div>
</header>
<section style="margin-top: 35px;">
    <form method="post" class="layui-form layui-form-pane">
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">疫苗种类</label>
                <div class="layui-input-inline">
                    <input type="hidden" name="viccineID" value=""/>
                    <input type="text" name="vaccineName" value="" class="layui-input" autocomplete="off" placeholder="请输入疫苗种类" lay-verify="vaccineName" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">接种日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="vaccineDate" value="" id="vaccine_date" class="layui-input" autocomplete="off" placeholder="请输入接种日期" lay-verify="vaccineDate" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">接种数量</label>
                <div class="layui-input-inline">
                    <input type="text" name="vaccineQuantity" value="" class="layui-input" autocomplete="off" placeholder="请输入接种数量" lay-verify="vaccineQuantity" lay-verType="msg"/>
                </div>
            </div>
        </div><br />
        <div class="layui-container">
            <div class="layui-form-item">
                <label class="layui-form-label">接种开销</label>
                <div class="layui-input-inline">
                    <input type="text" name="vaccineMoney" value="" class="layui-input" autocomplete="off" placeholder="请输入接种开销" lay-verify="vaccineMoney" lay-verType="msg"/>
                </div>
            </div>
        </div>
        <div class="layui-btn-container layui-container" style="margin-top: 40px;">
            <hr class="layui-bg-gray">
            <button class="layui-btn layui-btn-radius layui-btn-lg layui-bg-liner layui-btn-fluid" lay-submit lay-filter="addvaccine">立即添加</button>
        </div>
    </form>
</section>

<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element','laydate','form','layer','laydate'], function() {
        var element = layui.element,
            laydate = layui.laydate,
            form = layui.form,
            $ = layui.jquery,
            layer = layui.layer,
            laydate = layui.laydate;

        layer.config({anim:0});

        laydate.render({
            elem:'#vaccine_date'
        });

        $(".back").click(function(){
            window.history.back(-1);
        });//提交
        form.on("submit(addvaccine)",function (data) {
            $.post("addvaccine",data.field,function (result) {
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
            vaccineName:function(value,item){
                if(value == ""){
                    return "疫苗种类名字不能为空";
                }
            },
            vaccineDate:function(value,item){
                if(value == ""){
                    return '请先选择日期';
                }
            },
            vaccineQuantity:function(value,item){
                if(value == ""){
                    return '请先输入疫苗接种数量';
                }
                if(!new RegExp("^\\d*$").test(value)){
                    return  '数量只能输入正整数';
                }
            },
            vaccineMoney:function (value,item) {
                if(value == ""){
                    return '请先输入疫苗接种开销';
                }
                if(!new RegExp("^\\d*\\.?\\d*?$").test(value)){
                    return "开销只能输入数字";
                }
            }
        });
    });
</script>
</body>
</html>
