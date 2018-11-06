<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_oo76d01a1rq.css"/>
    <link rel="stylesheet" href="layui/css/layui.css">
    <title>${title }</title>
    <style>
        section>a,section{
            color: #504f4f;
            font-size: 17px;
        }
        .layui-container img{width:100% !important;}
        p{overflow-x: auto;}
    </style>
</head>
<body>
    <header class="layui-header layui-bg-liner"  style="width:100%;height:60px;position: fixed;top: 0px;left: 0px;">
        <div class="layui-container">
            <div class="layui-row">
                <div class="text-middle layui-pull-left">
                    <a href="javascript:;" class="back layui-icon layui-icon-left" style="font-size: 22px;color: #fff;"></a>
                </div>
                <div class="text-middle layui-pull-center">
                    <span>&nbsp;资讯详情 </span>
                </div>
            </div>
        </div>
    </header>
    <section style="margin: 75px auto 75px;">
        <div class="layui-container">
            <blockquote class="layui-elem-quote layui-text"><h3>${title }</h3></blockquote>
        </div>
        <div class="layui-container wrap">
        	${newsDetails }
        </div>
        <hr>
        <p style="color: #01AAED;font-size: 15px;" class="text-center"><span>数据来源：中国养猪网</span></p>
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
    <script>
        layui.use(['element'],function () {
            element = layui.element,
            $ = layui.jquery;
			$(function () {
				$('img').attr("width",$(window).width);
	            $('.wrap a').each(function () {
	                $(this).attr("href","javascript:;");
	                $(this).click(function (event) {
	                    event.preventDefault();
	                })
	            });
	            
	            $(".back").click(function(){
	            	window.history.back(-1);
	            });
			})
        })
    </script>
</body>
</html>