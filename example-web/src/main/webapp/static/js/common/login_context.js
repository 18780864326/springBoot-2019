layui.use('form', function(){
    var form = layui.form,
        $=layui.jquery;
    var login_vm = new Vue({
        el:'#context_login',
        data:{
            login_title1:'登 录',
            login_title2:'考勤点到管理系统',
        }
    });
    var rootDefault = '/demo/'
    form.render();
    //监听提交
    form.on('submit(LAY-user-login-submit)', function(data){
        $.ajax({
            url:"/demo/system/login",
            type:"POST",
            data:data.field,
            dataType:"JSON",
            error:function(e){
                layer.msg("登录失败/系统异常");
                return false;
            },
            success:function(result){
                if(result.status == 1){
                    layer.msg('登入成功', {
                        offset: '20rem'
                        ,icon: 1
                        ,time: 500
                    }, function(){
                        location.href= rootDefault +'static/html/system/systemHomePage.html';
                    });
                }else{
                    layer.msg(result.msg);
                }
            }
        });
        // layer.msg(JSON.stringify(data.field));
        return false;
    });

    //开启回车事件   监听到了 激活登录按钮
    $(document).keydown(function (e) {
        if (e.keyCode === 13) {
            $('[lay-filter=LAY-user-login-submit]').trigger("click");
        }
    });

});
layui.define("form",function(e){var t=layui.$,i=(layui.layer,layui.laytpl,layui.setter,layui.view,layui.admin,layui.form),a=t("body");i.verify({nickname:function(e,t){return new RegExp("^[a-zA-Z0-9_一-龥\\s·]+$").test(e)?/(^\_)|(\__)|(\_+$)/.test(e)?"用户名首尾不能出现下划线'_'":/^\d+\d+\d$/.test(e)?"用户名不能全为数字":void 0:"用户名不能有特殊字符"},pass:[/^[\S]{4,12}$/,"密码必须6到12位，且不能出现空格"]}),e("user",{})});
