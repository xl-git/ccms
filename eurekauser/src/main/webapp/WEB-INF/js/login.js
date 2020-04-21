$(document).ready(function(){
    var $tab_li = $('#tab ul li');
    $tab_li.hover(function(){
        $(this).addClass('selected').siblings().removeClass('selected');
        var index = $tab_li.index(this);
        $('div.tab_box > div').eq(index).show().siblings().hide();
    });
});

$(function(){
    /*学生登录信息验证*/
    $("#user_username_hide").focus(function(){
        var username = $(this).val();
        if(username=='输入用户名'){
            $(this).val('');
        }
    });
    $("#user_username_hide").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $(this).val('输入用户名');
        }
    });
    $("#user_password_hide").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $(this).val('');
        }
    });
    $("#user_code_hide").focus(function(){
        var username = $(this).val();
        if(username=='输入验证码'){
            $(this).val('');
        }
    });
    $("#user_code_hide").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $(this).val('输入验证码');
        }
    });
    $(".user_login_error").Validform({
        tiptype:function(msg,o,cssctl){
            var objtip=$(".stu_error_box");
            cssctl(objtip,o.type);
            objtip.text(msg);
        },
        // ajaxPost:true
    });

    /*手机号登录信息验证*/
    $("#phone").focus(function(){
        var phone = $(this).val();
        if(phone=='输入手机号'){
            $(this).val('');
        }
    });
    $("#phone").focusout(function(){
        var phone = $(this).val();
        if(phone==''){
            $(this).val('输入手机号');
        }
    });
    $("#phone_code").focus(function(){
        var phone_code = $(this).val();
        if(phone_code=='输入验证码'){
            $(this).val('');
        }
    });
    $("#phone_code").focusout(function(){
        var phone_code = $(this).val();
        if(phone_code==''){
            $(this).val('输入验证码');
        }
    });
    $(".phone_login_error").Validform({
        tiptype:function(msg,o,cssctl){
            var objtip=$(".tea_error_box");
            cssctl(objtip,o.type);
            objtip.text(msg);
        },
        // ajaxPost:true
    });

    /*教务登录信息验证*/
    $("#rusername").focus(function(){
        var username = $(this).val();
        if(username=='输入用户名'){
            $(this).val('');
        }
    });
    $("#rusername").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $(this).val('输入用户名');
        }
    });
    $("#rephone").focus(function(){
        var username = $(this).val();
        if(username=='输入手机号'){
            $(this).val('');
        }
    });
    $("#rephone").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $(this).val('输入手机号');
        }
    });
    $("#sec_code_hide").focus(function(){
        var username = $(this).val();
        if(username=='输入验证码'){
            $(this).val('');
        }
    });
    $("#sec_code_hide").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $(this).val('输入验证码');
        }
    });
    $(".sec_login_error").Validform({
        tiptype:function(msg,o,cssctl){
            var objtip=$(".sec_error_box");
            cssctl(objtip,o.type);
            objtip.text(msg);
        },
        // ajaxPost:true
    });
});

$(function(){
    $(".screenbg ul li").each(function(){
        $(this).css("opacity","0");
    });
    $(".screenbg ul li:first").css("opacity","1");
    var index = 0;
    var t;
    var li = $(".screenbg ul li");
    var number = li.size();
    function change(index){
        li.css("visibility","visible");
        li.eq(index).siblings().animate({opacity:0},3000);
        li.eq(index).animate({opacity:1},3000);
    }
    function show(){
        index = index + 1;
        if(index<=number-1){
            change(index);
        }else{
            index = 0;
            change(index);
        }
    }
    t = setInterval(show,8000);
    //根据窗口宽度生成图片宽度
    var width = $(window).width();
    $(".screenbg ul img").css("width",width+"px");
});

//用户注册
var rusername = null;
var upassword=null;
var rupassword=null;
var rephone=null;
var securityCode2=null;
$(function() {
    rusername = $("#rusername");
    rusername.bind("blur", function () {
        //ajax后台验证--用户名是否已存在
        $.ajax({
            type: "GET",//请求类型
            url: "/user/isexistusername.html",//请求的url
            data: {method: "isExistUserName", userName: rusername.val()},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.result == "true") {//用户名已存在，错误提示
                    validateTip($("#messages").next(), " 该用户名已被注册", false);
                } else {//账号可用，正确提示
                    validateTip($("#messages").next(), "用户名可用", true);
                }
            }
        })
    });

    /*
     * 验证
     * 失焦\获焦
     * jquery的方法传递
     */
    rephone = $("#rephone");
    rephone.bind("blur",function(){
        //ajax后台验证--telphone是否已存在
        $.ajax({
            type:"GET",//请求类型
            url:"/user/isexisttelphone.html",//请求的url
            data:{method:"isExistTelphone",telphone:rephone.val()},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data.result == "true"){//手机号已存在，错误提示
                    validateTip($("#messages").next()," 该手机号已被注册",false);
                }
            }
        })
    });

    securityCode2=$("#securityCode2");
    securityCode2.bind("click",function () {
        $.ajax({
            type: "GET",//请求类型
            url: "/user/getphonecode.html",//请求的url
            data: {method: "getphonecode",phone: rephone.val()},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.result == "true") {//用户名已存在，错误提示
                    validateTip($("#messages").next(), " 请输入手机号！", false);
                }
            }
        });
    }).bind("click",function () {
        validateTip($("#messages").next(), " 验证码已发送！", true);
    });
    upassword=$("#upassword");
    repassword = $("#repassword");
    repassword.bind("focus",function(){
        validateTip($("#messages").next(),"* 请输入与上面一致的密码",false);
    }).bind("blur",function(){
        if(repassword.val() != null && repassword.val().length >= 6
            && repassword.val().length < 20 && upassword.val() == repassword.val()){
            validateTip($("#messages").next(),"两次密码输入一致",true);
        }else{
            validateTip($("#messagse").next()," 两次密码输入不一致，请重新输入",false);
        }
    });
})
//手机登录
var securityCode=null;
var phone = null;
$(function() {
    securityCode=$("#securityCode");
    phone = $("#phone");
    phone.bind("blur",function(){
        //ajax后台验证--telphone是否已存在
        $.ajax({
            type:"GET",//请求类型
            url:"/user/isexisttelphone.html",//请求的url
            data:{method:"isExistTelphone",telphone:phone.val()},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data.result == "false"){//手机号已存在，错误提示
                    validateTip($("#message").next()," 该手机号未注册，请注册后再登录！",false);
                }
            }
        });
    });
    securityCode.bind("click",function () {
        $.ajax({
            type: "GET",//请求类型
            url: "/user/getphonecode.html",//请求的url
            data: {method: "getphonecode",phone: phone.val()},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.result == "true") {//用户名已存在，错误提示
                    validateTip($("#message").next(), " 请输入手机号！", false);
                }
            }
        });
    }).bind("click",function () {
        validateTip($("#message").next(), " 验证码已发送！", true);
    });
})