<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_oo76d01a1rq.css"/>
    <title>疫苗接种</title>
</head>
<body>
<header class="layui-header layui-bg-liner" style="width:100%;height:60px;position: fixed;top: 0px;left: 0px;">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                <span class="main-title" style="color:#fff;">
                    <i class="layui-icon layui-icon-release" style="font-size: 22px;"></i> 疫苗接种
                </span>
            </div>
            <div class="layui-pull-right text-middle">
                <ul class="layui-nav" style="padding: 0px;background: transparent;;" lay-filter="">
                    <li class="layui-nav-item">
                        <a href="javascript:;" style="font-size:16px ;">疫苗接种</a>
                        <dl class="layui-nav-child">
                            <dd><a href="index.html" style="font-size:16px ;">今日资讯</a></dd>
                            <dd><a href="feed.html" style="font-size:16px ;">饲料账单</a></dd>
                            <dd><a href="piglet.html" style="font-size:16px ;">小猪明细</a></dd>
                            <dd><a href="sale.html" style="font-size:16px ;">卖猪详情</a></dd>
                            <dd><a href="javascript:;" style="font-size:16px ;">疫苗接种</a></dd>
                            <dd><a href="other.html" style="font-size:16px ;">其他收支</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<section class="layui-container wrap">
    <div class="layui-row" style="margin-top: 70px;">
        <a href="addvaccine.html" class="btn layui-btn layui-btn-lg layui-bg-liner layui-btn-fluid layui-btn-radius">添加记录</a>
    </div>
    <table id="vaccine" lay-filter="vaccine"></table>
</section>
<footer>
    <div class="footer-nav">
        <a href="index.html" class="on-this">
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
        <a href="setting.html">
            <i class="iconfont icon-shezhichilun" style="font-size: 20px;"></i><br/>
            <span>设置</span>
        </a>
    </div>
</footer>
<script src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element','form','table','layer'],function () {
        var element = layui.element,
            table = layui.table,
            layer = layui.layer,
            $ = layui.jquery;

        var dt = table.render({
            elem:"#vaccine",
            url:"vaccinerecord",
            page:{  
                prev:'上一页',
                next:'下一页',
                layout:['prev', 'page', 'next','count'],
                groups:4
            },
            cols:[[
                {field:"vaccineName",title:"疫苗名称",align:"center",width:120},
                {field:"vaccineDate",title:"接种日期",align:"center",width:120},
                {field:"vaccineQuantity",title:"接种头数",align:"center"},
                {field:"vaccineMoney",title:"接种开销",align:"center"},
                {title:"操作",align:"center",toolbar:"#tools",width:120}
            ]]
        });

        table.on('tool(vaccine)',function(obj){
            var data = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;
            if(layEvent === 'edit'){
                window.location.href="updatevaccine.html?vaccineID="+data.vaccineID;
            }
            if(layEvent === 'delete'){
                layer.confirm('确认删除当前数据吗？',{icon:3}, function(index){
                    $.post("deletevaccine",{vaccineID:data.vaccineID},function(result){
                        if(result=="OK"){
                            obj.del();
                            layer.msg('删除成功');
                            dt.reload({
                                page:{curr:1}
                            });
                        }else{
                            layer.msg("删除失败,请稍后重试");
                        }
                    });
                });
            }
        });
    });
</script>
<script type="text/html" id="tools">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
</script>
</body>
</html>