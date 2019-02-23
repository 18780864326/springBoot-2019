layui.use('element', function(){
    var element = layui.element;
    var homePage_vm= new Vue({
        el:'#homePage_vm',
        data:{
            header_user_info :"C3005890",
            header_title:"考勤点到管理系统"
        }
    });
});

function openPage(path){
    var url='/MonitorSystem/static/html'+path+'.html';
    $('#showContent').attr('src',url);
}