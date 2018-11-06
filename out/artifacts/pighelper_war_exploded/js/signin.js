layui.use(['element', 'form', 'layer'], function () {
    var element = layui.element,
        form = layui.form,
        $ = layui.jquery,
        layer = layui.layer;

    $(function () {
    	layer.msg("请您先登录",{offset: '130',time:3000});
        $("#username").val(layui.data("user").username);
        $("#pwd").val(layui.data("pwd").pwd)
        
        if(layui.data('user').username != undefined){
        	$(":checkbox").attr('checked',true);
        	form.render('checkbox');
        }
        
        var flag = true;
         $('.show-pwd').click(function () {
        	 if(flag == true){
        		 $('#pwd').prop('type','text');
        		 flag = false;
        	 }else{
        		 $('#pwd').prop('type','password');
        		 flag = true;
        	 }
        });
        
        $('button').click(function () {
            if ($("#username").val() == "") {
                layer.msg("请输入用户名");
                $("#username").focus();
            } else if ($("#pwd").val() == "") {
                layer.msg("请输入密码");
                $("#pwd").focus();
            } else {
                if ($(":checkbox").is(':checked')) {
                    layui.data("user", {
                        key: 'username',
                        value: $("#username").val()
                    });
                    layui.data("pwd", {
                        key: "pwd",
                        value: $("#pwd").val()
                    });
                } else {
                    layui.data('user', {
                        key: 'username'
                        , remove: true
                    });
                    layui.data('pwd', {
                        key: 'pwd'
                        , remove: true
                    });
                }
                
                var lay_index = layer.open({type:3});
                $.post("check",$('form').serialize(),function (result) {
                	layer.close(lay_index)
                    if(result == "FAIL"){
                        layer.msg("登录失败，请检查用户名或密码是否正确",{anim: 6});
                    }
                    if(result == "OK"){
                    	$('form').submit();
                    }
                })
            }
        })
    })
});