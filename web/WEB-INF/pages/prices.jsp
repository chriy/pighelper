<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0" />
        <link rel="stylesheet" href="css/global.css" />
        <link rel="stylesheet" href="layui/css/layui.css" />
        <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_z7x5ppxb0ym.css" />
		<title>今日猪价</title>
	</head>
	<body>
	    <header class="layui-header layui-bg-liner" style="width:100%;height:60px;position:fixed;top: 0px;right: 0px;z-index:100000;">
            <div class="layui-container">
                <div class="layui-row">
                    <div class="text-middle layui-pull-left">
                        <span>
                            <i class="layui-icon layui-icon-release" style="font-size: 22px;"></i> 今日猪价
                        </span>
                    </div>
                    <div class="layui-pull-right text-middle time"></div>
                </div>
            </div>
        </header>
	    
	    <section style="margin: 80px 0px">
	        <div class="layui-container" style="margin-top: 20px;">
	            <blockquote class="layui-elem-quote">今日全国猪价<span style="color: #01AAED;font-size:15px;">&emsp;(仅供参考)</span></blockquote>
	            <table id="day_qg_price"></table><br>	        
	            <blockquote class="layui-elem-quote">今日省内猪价<span style="color: #01AAED;font-size:15px;">&emsp;(仅供参考)</span></blockquote>
	            <table id="day_prov_price"></table>
	        </div>
	        
	        <div class="layui-container" style="margin-top: 20px;">
	        </div>
	        
	    </section>
	    
	    <footer>
            <div class="footer-nav">
                <a href="index.html">
                    <i class="iconfont icon-shouye" style="font-size: 20px;"></i><br />
                    <span>首页</span>
                </a>
                <a href="count.html">
                    <i class="iconfont icon-tongji" style="font-size: 20px;"></i><br />
                    <span>统计</span>
                </a>
                <a href="prices.html" class="on-this">
                    <i class="iconfont icon-jiage" style="font-size: 20px;"></i><br />
                    <span>猪价</span>
                </a>
                <a href="setting.html">
                    <i class="iconfont icon-shezhichilun" style="font-size: 20px;"></i><br />
                    <span>设置</span>
                </a>
            </div>
        </footer>
        <script type="text/javascript" src="layui/layui.js"></script>
        <script>
            layui.use(['table','element','util'],function(){
                var element = layui.element,
                table = layui.table,
                date = new Date(),
                $ = layui.jquery,
                util = layui.util;
                
                var currTime = date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日";
                $('.time').text(currTime);
                
                table.render({
                   elem:'#day_qg_price',
                   url:'getQGPrice',
                   cols:[[
                        {field:"city",title:"城市",align:'center'},
                        {field:"price",title:"价格",align:'center',sort:true},
                        {field:"range",title:"涨幅",align:'center',templet:'#rangeTpl'},
                   ]],
                });
                table.render({
                   elem:'#day_prov_price',
                   url:"getSNPrice",
                   cols:[[
                        {field:"city",title:"城市",align:'center'},
                        {field:"price",title:"价格",align:'center',sort:true},
                        {field:"range",title:"涨幅",align:'center',templet:'#rangeTpl'},
                   ]],
                });
                table.render({
                   elem:'#day_city_price',
                   url:"getCityPrice",
                   cols:[[
                        {field:"city",title:"城市",align:'center'},
                        {field:"price",title:"价格",align:'center',sort:true},
                        {field:"range",title:"涨幅",align:'center',templet:'#rangeTpl'},
                   ]],
                });
            });
            
        </script>
        <script type="text/html" id="rangeTpl">
          {{#  if(d.range === '0'){ }}
            <span style="color: #FF0000;">涨</span>
		  {{#  } }}
		  {{# if(d.range === '1'){ }}
			<span style="color: #009897;">降</span>
          {{#  } }}
		  {{# if(d.range==='-1') { }}
			<span>平</span>
		  {{#  } }}
        </script>
	</body>
</html>
