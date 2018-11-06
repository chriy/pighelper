<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <link rel="stylesheet" href="layui/css/layui.css" />
    <link rel="stylesheet" href="css/global.css">
    <title>批次管理</title>
</head>
<body>
    <header class="layui-header layui-bg-liner">
        <div class="layui-container">
            <div class="layui-row">
                <div class="text-middle layui-pull-left">
                    <a href="setting.html" class="layui-icon layui-icon-left" style="font-size: 22px;color: #fff;"></a>
                </div>
                <div class="text-middle layui-pull-center">
                    <span>&nbsp;批次管理</span>
                </div>
            </div>
        </div>
    </header>

    <section class="layui-container">
        <table id="batch" lay-filter="batch"></table>
    </section>

    <script src="layui/layui.js"></script>
    <script type="text/javascript">
        layui.use(['element','form','table'], function() {
            var element = layui.element,
                form = layui.form,
                table = layui.table,
                $ = layui.jquery;
			
            var dt = table.render({
                elem:"#batch",
                url:"getbatch",
                page:{  
                    prev:'上一页',
                    next:'下一页',
                    layout:['prev', 'page', 'next','count'],
                    groups:4
                },
                cols:[[
                    {field:"batchNumber",title:"批次",align:'center'},
                    {field:"batchStatus",title:"状态",align:'center',templet:"#status"},
                    {title:"操作",align:'center',toolbar:'#tools'},
                ]]
            });
            
            table.on('tool(batch)',function(obj){
                var data = obj.data;
                var layEvent = obj.event;
                var tr = obj.tr;
                
                if(layEvent === 'delete'){
                    layer.confirm('确认删除当前数据吗？',{icon:3},function(index){
                        $.post("deletebatch",{batchId:data.batchId},function(result){
                        	if(result=="OK"){
		                        layer.msg('删除成功');
		                        obj.del();
		                        dt.reload({
	                    			page:{curr:1}
	                    		});
                        	}else{
                        		layer.msg("该批次下存在数据,删除失败");
                        	}
                        })
                    });
                }
            });
        });
    </script>
    <script type="text/html" id="tools">
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
    </script>
    <script type="text/html" id="status">
          {{#  if(d.batchStatus === 0){ }}
            <span style="color:#FF5722; ">未选中</span>
          {{#  } else { }}
            <span style="color: #009688;">已激活</span>
          {{#  } }}
    </script>
</body>
</html>