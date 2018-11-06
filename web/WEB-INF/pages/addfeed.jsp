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
                        <span>&nbsp;饲料账单 - 添加记录</span>
                    </div>
                </div>
            </div>
        </header>
        <section style="margin-top: 35px;">
            <form method="post" class="layui-form layui-form-pane submit">
                <div class="layui-container">
                    <div class="layui-form-item">
                        <label class="layui-form-label">配送日期</label>
                        <div class="layui-input-inline">
                            <input type="text" name="sendDate" id="date_time" class="layui-input" readonly="readonly" autocomplete="off" placeholder="请选择日期" lay-verify="sendDate" lay-verType="msg"/>
                        </div>
                    </div>
                </div><br />
                <div class="layui-container">
                    <div class="layui-form-item">
                        <label class="layui-form-label">配送数量</label>
                        <div class="layui-input-inline">
                            <input type="text" name="feedQuantity" class="layui-input" autocomplete="off" placeholder="请输入数量" lay-verify="feedQuantity" lay-verType="msg"/>
                        </div>
                    </div>
                </div><br />
                <div class="layui-container">
                    <div class="layui-form-item">
                        <label class="layui-form-label">饲料单价</label>
                        <div class="layui-input-inline">
                            <input type="text" name="feedPrice" class="layui-input" autocomplete="off" placeholder="请输入单价" lay-verify="feedPrice" lay-verType="msg"/>
                        </div>
                    </div>
                </div><br />
                <div class="layui-container">
                    <div class="layui-form-item">
                        <label class="layui-form-label">支付状态</label>
                        <div class="layui-input-block">
                            <select name="feedPayState" lay-verify="required|feedPayState">
                                <option value="">请选择支付状态</option>
                                <option value="已支付">已支付</option>
                                <option value="未支付">未支付</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="layui-btn-container layui-container" style="margin-top: 40px;">
                    <hr class="layui-bg-gray">
                    <button class="layui-btn layui-btn-radius layui-btn-lg layui-bg-liner layui-btn-fluid" lay-submit lay-filter="add">立即添加</button>
                </div>
            </form>
        </section>
        
        <script type="text/javascript" src="layui/layui.js"></script>
        <script type="text/javascript">
            layui.use(['element','laydate','form','util','layer'], function() {
                var element = layui.element,
                laydate = layui.laydate,
                form = layui.form,
                util = layui.util,
                $ = layui.jquery,
                layer = layui.layer;
                
                layer.config({anim:0});
                
                laydate.render({
                    elem:'#date_time'
                });
                
                $(".back").click(function(){
	            	window.history.back(-1);
	            });
                
                form.on('submit(add)',function(data){
                	$.post("addfeed",data.field,function(result){
                		if(result=="OK"){
                			$(".submit")[0].reset();
                			$(".layui-btn").addClass("layui-hide");
                			layer.msg("添加成功!",{time:1000},function(){
	                			window.history.back(-1);
                			});
                		}
                	});
                    return false;
                });
                form.verify({
                    sendDate:function(value,item){
                        if(value == ""){
                            return '请先选择日期';
                        }
                    },
                    feedQuantity:function(value,item){
                        if(value == ""){
                            return '请先输入数量';
                        }
                        if(!new RegExp("^\\d*$").test(value)){
                            return  '数量只能输入正整数';
                        }
                    },
                    feedPrice:function (value,item) {
                        if(value == ""){
                            return '请先输入饲料单价';
                        }
                        if(!new RegExp("^\\d*\\.?\\d*?$").test(value)){
                            return "价格只能输入数字";
                        }
                    },
                    feedPayState:function(value,item){
                        if(value == ""){
                            return "请先选择支付状态";
                        }
                    }
                });
            });
        </script>
	</body>
</html>
