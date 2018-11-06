<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_412l1yn4gmg.css"/>
    <title>卖猪详情</title>
</head>
<body>
<header class="layui-header layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                 <span class="main-title">
                    <i class="layui-icon layui-icon-release" style="font-size: 22px;"></i> 卖猪详情
                </span>
            </div>
            <div class="layui-pull-right text-middle">
                <ul class="layui-nav" style="padding: 0px;background: transparent;;" lay-filter="">
                    <li class="layui-nav-item">
                        <a href="javascript:;" style="font-size:16px ;">卖猪详情</a>
                        <dl class="layui-nav-child">
                            <dd><a href="index.html" style="font-size:16px ;">今日资讯</a></dd>
                            <dd><a href="feed.html" style="font-size:16px ;">饲料账单</a></dd>
                            <dd><a href="piglet.html" style="font-size:16px ;">小猪明细</a></dd>
                            <dd><a href="sale.html" style="font-size:16px ;">卖猪详情</a></dd>
                            <dd><a href="vaccine.html" style="font-size:16px ;">疫苗接种</a></dd>
                            <dd><a href="other.html" style="font-size:16px ;">其他收支</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<section class="layui-container wrap">
    <div class="layui-row" style="margin-top: 10px;">
        <a href="addsale.html" class="btn layui-btn layui-btn-lg layui-bg-liner layui-btn-fluid layui-btn-radius">添加记录</a>
    </div>
        <table id="sale" lay-filter="sale"></table>
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
        <a href="salePrices.html">
            <i class="iconfont icon-jiage" style="font-size: 20px;"></i><br/>
            <span>猪价</span>
        </a>
        <a href="setting.html">
            <i class="iconfont icon-shezhichilun" style="font-size: 20px;"></i><br/>
            <span>设置</span>
        </a>
    </div>
</footer>

<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element', 'table', 'layer'], function () {
        var element = layui.element,
            $ = layui.jquery,
            table = layui.table,
            layer = layui.layer;

            var dt = table.render({
                elem:"#sale",
                url:"salerecord",
                page:true,
                limit:7,
                page:{
                  prev:"上一页",
                  next:"下一页",
                    layout:['prev', 'page', 'next','count'],
                    groups:3
                },
                cols:[[
                    {field:"saleDate",title:"日期",align:"center",width:115},
                    {field:"saleQuantity",title:"数量",align:"center",width:110},
                    {field:"salePrice",title:"售价/每斤",align:"center",width:120},
                    {field:"saleVariety",title:"售出品种",align:"center",width:115},
                    {field:"averageWeight",title:"平均毛重/斤",align:"center",width:120},
                    {field:"averageMoney",title:"平均每头金额/元",align:"center",width:160},
                    {field:"totalWeight",title:"总重量/斤",align:"center",width:115},
                    {field:"saleAmount",title:"总金额/元",align:"center",width:120},
                    {title:'操作',align:'center',width:120,toolbar:'#tools'}
                ]]
            });

        table.on('tool(sale)',function(obj){
            var data = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;
            if(layEvent === 'edit'){
                window.location.href="updatesale.html?saleID="+data.saleID;
            }
            if(layEvent === 'delete'){
                layer.confirm('确认删除当前数据吗？',{icon:3}, function(index){
                    $.post("deletesale",{saleID:data.saleID},function(result){
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