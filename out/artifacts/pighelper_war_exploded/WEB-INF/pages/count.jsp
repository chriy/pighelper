<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_774762_412l1yn4gmg.css"/>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script src="js/Chart.bundle.min.js" type="text/javascript"></script>
    <script src="js/count.js" type="text/javascript"></script>
    <title>账目汇总</title>
</head>
<body class="">
<header class="layui-header layui-bg-liner">
    <div class="layui-container">
        <div class="layui-row">
            <div class="text-middle layui-pull-left">
               <span class="main-title">
                    <i class="layui-icon layui-icon-release" style="font-size: 22px;"></i> 账目汇总
               </span>
            </div>
            <div class="layui-pull-right">
                <span class="main-title text-middle">
                    <span class="layui-badge layui-bg-orange">${active}</span>
                </span>
            </div>
        </div>
    </div>
</header>
<section style="margin-bottom:60px;">
    <div class="layui-collapse" lay-filter="chart">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">盈利亏损</h2>
            <div class="layui-colla-content layui-show">
                <canvas id="profit"></canvas>
                <table class="layui-table" style="text-align: center">
                    <thead style="text-align: center">
                    <tr style="text-align: center">
                        <th style="text-align: center">收入</th>
                        <th style="text-align: center">支出</th>
                        <th style="text-align: center">盈亏</th>
                    </tr>
                    </thead>
                    <tbody class="profitChart"></tbody>
                </table>
            </div>
        </div>
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">饲料账单</h2>
            <div class="layui-colla-content layui-show">
                <table class="layui-table" style="text-align: center">
                    <thead style="text-align: center">
                    <tr style="text-align: center">
                        <th style="text-align: center">条目</th>
                        <th style="text-align: center">统计</th>
                    </tr>
                    </thead>
                    <tbody class="feedChart"></tbody>
                </table>
            </div>
        </div>
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">小猪明细</h2>
            <div class="layui-colla-content">
                <table class="layui-table" style="text-align: center">
                    <thead style="text-align: center">
                    <tr style="text-align: center">
                        <th style="text-align: center">条目</th>
                        <th style="text-align: center">统计</th>
                    </tr>
                    </thead>
                    <tbody class="pigletChart"></tbody>
                </table>
            </div>
        </div>
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">卖猪详情</h2>
            <div class="layui-colla-content">
                <table class="layui-table" style="text-align: center">
                    <thead style="text-align: center">
                    <tr style="text-align: center">
                        <th style="text-align: center">条目</th>
                        <th style="text-align: center">统计</th>
                    </tr>
                    </thead>
                    <tbody class="saleChart"></tbody>
                </table>
            </div>
        </div>
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">疫苗接种</h2>
            <div class="layui-colla-content">
                <table class="layui-table" style="text-align: center">
                    <thead style="text-align: center">
                    <tr style="text-align: center">
                        <th style="text-align: center">条目</th>
                        <th style="text-align: center">统计</th>
                    </tr>
                    </thead>
                    <tbody class="vaccineChart"></tbody>
                </table>
            </div>
        </div>
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">其他支出</h2>
            <div class="layui-colla-content">
                <table class="layui-table" style="text-align: center">
                    <thead style="text-align: center">
                    <tr style="text-align: center">
                        <th style="text-align: center">条目</th>
                        <th style="text-align: center">统计</th>
                    </tr>
                    </thead>
                    <tbody class="otherChart"></tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<footer>
    <div class="footer-nav">
        <a href="index.html">
            <i class="iconfont icon-shouye" style="font-size: 20px;"></i><br/>
            <span>首页</span>
        </a>
        <a href="count.html" class="on-this">
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
</body>
</html>
