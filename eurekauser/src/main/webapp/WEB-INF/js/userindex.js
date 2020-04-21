$(function (){
    function test(divObj,aobj) {
        var myDiv = $(divObj);
        $(aobj).mouseover(function (event) {
            $(divObj).fadeIn();;//调用显示DIV方法
            $(document).one("mouseover", function () {//对document绑定一个影藏Div方法
                $(divObj).hide();
            });

            event.stopPropagation();//阻止事件向上冒泡
        });

        $(divObj).mouseover(function (event) {
            event.stopPropagation();//阻止事件向上冒泡
        });
    }

    test("#myDiv", "#submeau");
    test("#myDiv2", "#submeau2");
    test("#myDiv3", "#submeau3");
    test("#myDiv4", "#submeau4");
    test("#myDiv5", "#submeau5");
    test("#myDiv6", "#submeau6");
    $("#login").click(function () {
        window.location.href="/user/login.html";
    });
    $("#register").click(function () {
        window.location.href="/user/login.html";
    })
});