layui.use(['element', 'table', 'layer'], function () {
    var element = layui.element,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    element.init();

    $(function () {

        /*盈亏账单*/
        $.ajax({
           url:"profitChart",
           dataType:"json",
           type:"post",
           success:function (data) {
               var d = new Array();
               d.push(data.income);
               d.push(data.expend);
               d.push(data.profit);
               draw(d);
               $(".profitChart").append("<tr><td>"+data.income+" 元</td><td>"+data.expend+" 元</td><td>"+data.profit+" 元</td></tr>")
           }
        });

        /*饲料账单*/
        $.ajax({
            url: "feedChart",
            dataType: "json",
            type: "json",
            success: function (data) {
                $(".feedChart").append(("<tr><td>饲料已支付</td><td>" + data.feedPaid + " 包</td></tr>"));
                $(".feedChart").append(("<tr><td>饲料未支付</td><td>" + data.feedUnPaid + " 包</td></tr>"));
                $(".feedChart").append(("<tr><td>饲料总数量</td><td>" + data.feedTotal + " 包</td></tr>"));
                $(".feedChart").append("<br>");
                $(".feedChart").append(("<tr><td>金额已支付</td><td>" + data.moneyPaid + " 元</td></tr>"));
                $(".feedChart").append(("<tr><td>金额未支付</td><td>" + data.moneyUnPaid + " 元</td></tr>"));
                $(".feedChart").append(("<tr><td>金额总数</td><td>" + data.moneyTotal + " 元</td></tr>"));
            }
        });

        /*小猪账单*/
        $.ajax({
            url: "pigletChart",
            dataType: "json",
            type: "post",
            success: function (data) {
                $(".pigletChart").append("<tr><td>买猪合计</td><td>" + data.pigletChart + " 元</td></tr>")
            }
        });
        /*卖猪账单*/
        $.ajax({
            url: "saleChart",
            dataType: "json",
            type: "post",
            success: function (data) {
                $(".saleChart").append("<tr><td>卖猪合计</td><td>" + data.saleChart + " 元</td></tr>")
            }
        });

        /*疫苗账单*/
        $.ajax({
            url: "vaccineChart",
            dataType: "json",
            type: "post",
            success: function (data) {
                $(".vaccineChart").append("<tr><td>疫苗开销</td><td>" + data.vaccineTotal + " 元</td></tr>")
            }
        });

        /*其他账单*/
        $.ajax({
            url: "otherChart",
            dataType: "json",
            type: "post",
            success: function (data) {
                $(".otherChart").append("<tr><td>其他支出</td><td>" + data.otherChart + " 元</td></tr>")
            }
        });
    });

    function draw(data) {
        var profit = document.getElementById("profit").getContext('2d');
        var chart_profit = new Chart(profit, {
            type: 'bar',
            data: {
                labels: [ "收入","支出", "盈亏"],
                datasets: [{
                    label: '盈亏状态图',
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(255, 206, 86, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 2
                }]
            }
        });
    }
});