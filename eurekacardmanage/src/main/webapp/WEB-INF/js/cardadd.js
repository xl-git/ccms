var but1=$("#but1");
var phone=$("#phone1");
but1.bind("click",function(){
    $.ajax({
        type:"GET",//请求类型
        url:"/cardmanage/getphonecode.html",//请求的url
        data:{method:"getphonecode",phone:phone.val()},//请求参数
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            if(data.result == "true"){//手机号已存在，错误提示
                but1.next().html("验证码已发送");
            }else{
                but1.next().html("验证码发送失败");
            }
        }
    })
});

var but2=$("#but2");
var but3=$("#but3");
var but4=$("#but4");
var but6=$("#but6");
var div1=$("#baseinfo_div");
var div2=$("#unitinfo_div");
var div3=$("#contactinfo_div");
but2.bind("click",function () {
    div1.hide();
    div2.show();
});

but3.bind("click",function () {
    div2.hide();
    div3.show();
});

but4.bind("click",function () {
    div2.hide();
    div1.show();
});

but6.bind("click",function () {
    div3.hide();
    div2.show();
});

var checkbox1=$("#checkbox1");
var but5=$("#but5");
checkbox1.bind("click",function () {
    if(checkbox1.val()==0){
        checkbox1.val(1);
        but5.removeAttr("disabled");
    }else if(checkbox1.val()==1){
        checkbox1.val(0);
        but5.attr("disabled","disabled");
    }
});