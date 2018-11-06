<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_oo76d01a1rq.css"/>
    <title>今日要闻</title>
    <style>
        ul{
            width: 100%;
        }
        .groom_list>li{
            width: 100%;
            height: 36px;
            overflow: hidden;
            line-height: 36px;
            border-bottom: 1px solid #f0f0f0;
        }
        .groom_list>li>span{
            display:inline-block;
            width:18px;
            height: 20px;
            text-align: center;
            font-size: 16px;
            height: 20px;
            line-height: 20px;
            font-weight: bold;
            padding: 2px 4px;
            background: #009688;
            color: #fff;
            border-radius: 5px;
            margin-right: 10px;
        }
        .groom_list>li:nth-child(1) span{
            background: #f90f12;
        }
        .groom_list>li:nth-child(2) span{
            background: #f87300;
        }
        .groom_list>li:nth-child(3) span{
            background: #1E9FFF;
        }
        .groom_list>li>a{
            font-size: 16px;
        }
    </style>
</head>
<body>
<header class="layui-header layui-bg-liner" style="width:100%;height:60px;position: fixed;top: 0px;left: 0px;">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
                <span class="main-title" style="color:#fff;">
                	<i class="layui-icon layui-icon-release" style="font-size: 22px;"></i> 今日资讯
                </span>
            </div>
            <div class="layui-pull-right text-middle">
                <ul class="layui-nav" style="padding: 0px;background: transparent;">
                    <li class="layui-nav-item">
                        <a href="javascript:;" style="font-size:16px ;">切换分类</a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                            <dd><a href="javascript:;" style="font-size:16px ;">今日资讯</a></dd>
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
<section style="margin: 60px auto 70px;font-size: 18px;color: #858585;">
	<div class="layui-carousel" id="image">
            <div carousel-item style="float: left;">
				 <div style="background: url('img/carousel01.jfif')no-repeat center/cover"></div>
				 <div style="background: url('img/carousel02.jfif')no-repeat center/cover"></div>
            </div>
     </div>
    <div class="layui-container">
        <ul class="groom_list">
           	<c:if test="${empty title }">
				<div class="layui-disabled" style="margin-top:40px;text-align:center;color:#ff0000;">
					<p class="layui-icon layui-icon-face-cry" style="font-size: 30px; color: #FF5722;"></p>
					<span class="layui-text">数据接口请求异常：error</span>
				</div>
			</c:if>
            <c:forEach items="${title }" var="t" varStatus="index">
            	<li class="layui-elip"><span>${index.count }</span><a href="getMoreNews?title=${title.get(index.index)}&url=https://${url.get(index.index)}" class="layui-text layui-word-aux">${t }</a></li>
            </c:forEach>
        </ul>
    </div>
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
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element','carousel'], function () {
        var element = layui.element,
            $ = layui.jquery,
            carousel = layui.carousel;
        
        carousel.render({
            elem:"#image",
            width:"100%",
            height:"120px",
            anim:"fade",
            indicator:"none"
        });
    });
</script>
</body>
</html>